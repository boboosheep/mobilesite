package com.example.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * @描述: 
 * @创建日期: 2016年4月5日
 * @作者: bob
 * @email: yangbo@eloancn.com
 */
public class arraylist {
	   public static void main(String[] args) 
	    { 
	       /* //Constructing An ArrayLista 

	        ArrayList<String> listWithDuplicateElements = new ArrayList<String>(); 

	        listWithDuplicateElements.add("JAVA"); 

	        listWithDuplicateElements.add("J2EE"); 

	        listWithDuplicateElements.add("JSP"); 

	        listWithDuplicateElements.add("SERVLETS"); 

	        listWithDuplicateElements.add("JAVA"); 

	        listWithDuplicateElements.add("STRUTS"); 

	        listWithDuplicateElements.add("JSP"); 

	        //Printing listWithDuplicateElements 

	        System.out.print("ArrayList With Duplicate Elements :"); 

	        System.out.println(listWithDuplicateElements); 

	        //Constructing HashSet using listWithDuplicateElements 

	        HashSet<String> set = new HashSet<String>(listWithDuplicateElements); 

	        //Constructing listWithoutDuplicateElements using set 

	        ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set); 

	        //Printing listWithoutDuplicateElements 

	        System.out.print("ArrayList After Removing Duplicate Elements :"); 

	        System.out.println(listWithoutDuplicateElements); */
		   
		   //Constructing An ArrayList 

	        ArrayList<String> listWithDuplicateElements = new ArrayList<String>(); 

	        listWithDuplicateElements.add("JAVA"); 

	        listWithDuplicateElements.add("J2EE"); 

	        listWithDuplicateElements.add("JSP"); 

	        listWithDuplicateElements.add("SERVLETS"); 

	        listWithDuplicateElements.add("JAVA"); 

	        listWithDuplicateElements.add("STRUTS"); 

	        listWithDuplicateElements.add("JSP"); 

	        //Printing listWithDuplicateElements 

	        System.out.print("ArrayList With Duplicate Elements :"); 

	        System.out.println(listWithDuplicateElements); 

	        //Constructing LinkedHashSet using listWithDuplicateElements 

	        LinkedHashSet<String> set = new LinkedHashSet<String>(listWithDuplicateElements); 

	        //Constructing listWithoutDuplicateElements using set 

	        ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set); 

	        //Printing listWithoutDuplicateElements 

	        System.out.print("ArrayList After Removing Duplicate Elements :"); 

	        System.out.println(listWithoutDuplicateElements); 
	    } 
}
