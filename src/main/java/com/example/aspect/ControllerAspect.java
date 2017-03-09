package com.example.aspect;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.ErrorCode;
import com.example.exception.MsxfException;
import com.example.exception.MsxfValidationException;
import com.example.util.IPUtil;
import com.example.util.JsonUtil;
import com.example.util.ValidatorUtil;

   
@Aspect
@Component
public class ControllerAspect {
	
	private static final Logger log = LoggerFactory.getLogger(ControllerAspect.class);
	
	@Around("execution(* com.example..*.*Controller.*(..))")
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
		Object respData = null;
		long startTime = System.currentTimeMillis();
		String className = joinPoint.getTarget().getClass().getSimpleName(); //获取类名(这里只切面了Controller类)
		String methodName = joinPoint.getSignature().getName();              //获取方法名
		String methodInfo = className + "." + methodName;                    //组织类名.方法名

		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		String paramJsonValue = getParamJsonValue(request);
		
		log.info(methodInfo + "()被调用, 客户端IP=" + IPUtil.getClientIP(request) + ", 入参为" + paramJsonValue);
		
		Exception catchedException = null;
		String returnInfo = null;
		try{
			this.formValidate(joinPoint.getArgs(), methodInfo);
			respData = joinPoint.proceed();
		} catch(MsxfException e){
			returnInfo = "errorCode:" + e.getCode() + ", message:" + e.getMessage();
			catchedException = e;
		} catch(MsxfValidationException e){
			returnInfo = "errorCode:" + ErrorCode.ERR_PARAM.getCode() + ", message:" + this.buildStringFromMap(e.getFields());
			catchedException = e;
		} catch(Exception e){
			returnInfo = "未知异常:" + e.getMessage();
			catchedException = e;
		}
		if(respData != null){
			returnInfo = getResutlJsonValue(respData);;
		}
		long callMillis = System.currentTimeMillis() - startTime;
		
		// 记录操作日志

		log.info(methodInfo + "()被调用, 出参为" + returnInfo + ", Duration[" + (callMillis) + "]ms");
		
		if(catchedException != null){
			throw catchedException;
		}
		return respData;
	}


	@SuppressWarnings("rawtypes")
	private String getResutlJsonValue(Object respData) {
		String returnInfo = null;
		if(null!=respData && respData.getClass().isAssignableFrom(ResponseEntity.class)){
			returnInfo = JsonUtil.toJson(((ResponseEntity)respData).getBody());
		}else{
			returnInfo = JsonUtil.toJson(respData);
		}
		return returnInfo;
	}


	private void formValidate(Object[] args, String methodInfo) {
		for (int i = 0, len = args.length; i < len; i++) {
			if (null != args[i] && args[i].getClass().getName().startsWith("com.example")) {
				Map<String, String> resultMap = ValidatorUtil.validateToMap(args[i]);
				if (!resultMap.isEmpty()) {
					throw new MsxfValidationException(resultMap);
				}
			}
		}
	}

	private String getParamJsonValue(HttpServletRequest request) {
		Enumeration<String> paramEnum = request.getParameterNames();
		Map<String, String> paramMap = new HashMap<String, String>();
		while(paramEnum.hasMoreElements()){
			String paramName = paramEnum.nextElement();
			paramMap.put(paramName, request.getParameter(paramName));
		}
		return this.buildStringFromMap(paramMap);
	}

	/**
	 * 获取Map中的属性
	 * @see 由于Map.toString()打印出来的参数值对,是横着一排的...参数多的时候,不便于查看各参数值
	 * @see 故此仿照commons-lang3.jar中的ReflectionToStringBuilder.toString()编写了本方法
	 * @return String key11=value11 \n key22=value22 \n key33=value33 \n......
	 */
	private String buildStringFromMap(Map<String, String> map){
		StringBuilder sb = new StringBuilder();
		sb.append(map.getClass().getName()).append("@").append(map.hashCode()).append("[");
		for(Map.Entry<String,String> entry : map.entrySet()){
			sb.append("\n").append(entry.getKey()).append("=").append(entry.getValue());
		}
		return sb.append("\n]").toString();
	}
}