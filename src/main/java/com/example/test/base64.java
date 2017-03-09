package com.example.test;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @描述: 
 * @创建日期: 2016年3月31日
 * @作者: bob
 * @email: yangbo@eloancn.com
 */
public class base64 {
	public static void main(String[] args){  
        String str = "jia2123812";  
        try{  
            byte[] encodeBase64 = Base64.encodeBase64(str.getBytes("UTF-8"));  
            System.out.println("RESULT: " + new String(encodeBase64));  
        } catch(UnsupportedEncodingException e){  
            e.printStackTrace();  
        }  
    }  
}
