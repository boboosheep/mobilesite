package com.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.vo.JsonData;

@RestController
@RequestMapping(value="/demo")
public class testController {
	@RequestMapping(value="/test",method={RequestMethod.GET,RequestMethod.POST})
	public JsonData check(HttpServletRequest req,String platform) throws IOException{
		String aaa = req.getParameter("platform");
		System.out.println(aaa);
		/*System.out.println(vo.getAa());
		vo.setAa("right");
		return vo;*/
		StringBuffer sb = new StringBuffer() ; 
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);  
		BufferedReader br = new BufferedReader(isr);
		String s = "" ;
		while((s=br.readLine())!=null){
		sb.append(s) ;
		}
		String str =sb.toString();
		System.out.println(str); 
		
		JsonData json = new JsonData();
		json.setData("0");
		return json;
		
	}
	
}