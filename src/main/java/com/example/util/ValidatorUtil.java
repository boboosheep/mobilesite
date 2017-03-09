package com.example.util;

import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

/**
 * JSR303验证工具
 *
 * @author 玄玉<http://blog.csdn.net/jadyer>
 * @version v1.1
 * @history v1.0-->增加将验证的错误信息存入Map<String,String>后返回的<code>validateToMap()<code>方法
 * @history v1.0-->新建
 * @create 2015-6-9 下午11:25:18
 * @create 2015-6-9 下午11:25:18
 * @see -------------------------------------------------------------------------------------------
 * @see 本工具类完整代码见https://github.com/jadyer/JadyerEngine/blob/master/JadyerEngine-common/src/main/java/com/jadyer/engine/common/util/ValidatorUtil.java
 * @see -------------------------------------------------------------------------------------------
 * @see 本工具需要借助以下三个jar
 * @see hibernate-validator-5.1.3.Final.jar
 * @see validation-api-1.1.0.Final.jar
 * @see jboss-logging-3.1.3.GA.jar
 * @see 其实也可以像我博客写的这样http://blog.csdn.net/jadyer/article/details/7574668
 * @see 采用org.springframework.validation.BindingResult来验证,只是个人觉得单独一个工具类更好些
 * @see -------------------------------------------------------------------------------------------
 * @see 以下为Bean Validation规范内嵌的约束注解定义
 * @see @Null        限制只能为null
 * @see @NotNull     限制必须不为null
 * @see @AssertTrue  限制必须为true
 * @see @AssertFalse 限制必须为false
 * @see @Min         限制必须为一个不小于指定值的数字
 * @see @Max         限制必须为一个不大于指定值的数字
 * @see @DecimalMin  限制必须为一个不小于指定值的数字
 * @see @DecimalMax  限制必须为一个不大于指定值的数字
 * @see @Size        限制字符长度必须在min到max之间
 * @see @Digits      限制必须为一个小数,且整数部分的位数不能超过integer,小数部分的位数不能超过fraction
 * @see @Past        限制必须是一个过去的日期
 * @see @Future      限制必须是一个将来的日期
 * @see @Pattern     限制必须符合指定的正则表达式
 * @see -------------------------------------------------------------------------------------------
 * @see 除了以上列出的JSR-303原生支持的限制类型之外,还可以定义自己的限制类型
 * @see 本工具类最下方的注释部分是一个例子
 * @see 另外也可参考文章http://haohaoxuexi.iteye.com/blog/1812584
 * @see -------------------------------------------------------------------------------------------
 */
public final class ValidatorUtil {
    private static Validator validator = null;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private ValidatorUtil() {
    }

    /**
     * 判断属性是否属于例外属性列表
     *
     * @return true--是例外属性,false--不是例外属性
     */
    private static boolean isExcept(String field, String... exceptFields) {
        if (exceptFields == null)
            return false;

        for (String obj : exceptFields) {
            if (StringUtils.isNotBlank(obj) && field.indexOf(obj) >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证对象中的属性的值是否符合注解定义
     *
     * @param obj          需要验证的对象
     * @param exceptFields 不需要验证的属性
     * @return 返回空字符串""表示验证通过,否则返回错误信息,多个字段的错误信息用英文分号[;]分隔
     */
    public static String validate(Object obj, String... exceptFields) {
        if (null == obj) {
            return "被验证对象不能为null";
        }

        String validateMsg = "";
        Set<ConstraintViolation<Object>> validateSet = validator.validate(obj);
        for (ConstraintViolation<Object> constraintViolation : validateSet) {
            String field = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            if (!isExcept(field, exceptFields)) {
                validateMsg += field + ":" + message + ";";
            }
        }
        return validateMsg;
    }

    /**
     * 验证对象中的属性的值是否符合注解定义
     *
     * @param obj          需要验证的对象
     * @param exceptFields 不需要验证的属性
     * @return 返回空Map<String, String>(not null)表示验证通过,否则会将各错误字段作为key放入Map,value为错误信息
     */
    public static Map<String, String> validateToMap(Object obj, String... exceptFields) {
        if (null == obj) {
            throw new NullPointerException("被验证对象不能为null");
        }
        Map<String, String> resultMap = Maps.newHashMap();
        Set<ConstraintViolation<Object>> validateSet = validator.validate(obj);
        for (ConstraintViolation<Object> constraintViolation : validateSet) {
            String field = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            if (!isExcept(field, exceptFields)) {
                resultMap.put(field, message);
            }
        }
        return resultMap;
    }
}