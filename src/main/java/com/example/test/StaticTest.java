package com.example.test;
/**
 * @描述: 
 * @创建日期: 2016年4月5日
 * @作者: bob
 * @email: yangbo@eloancn.com
 */
public class StaticTest {
	
	private static int a;
	
	static{
		a = 4;
		System.out.println(a);
	}
	
	static{
		a = 5;
		System.out.println(a);
	}
	
	static{
		a++;
	}
	
	public static void main(String[] args) {
		System.out.println(a);
	}

}
