package com.example.test;

import java.io.UnsupportedEncodingException;

public class BobTestCo {
	 /** 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块 */
	 public static final String US_ASCII = "US-ASCII";

	 /** ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1 */
	 public static final String ISO_8859_1 = "ISO-8859-1";

	 /** 8 位 UCS 转换格式 */
	 public static final String UTF_8 = "UTF-8";

	 /** 16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序 */
	 public static final String UTF_16BE = "UTF-16BE";

	 /** 16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序 */
	 public static final String UTF_16LE = "UTF-16LE";

	 /** 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识 */
	 public static final String UTF_16 = "UTF-16";

	 /** 中文超大字符集 */
	 public static final String GBK = "GBK";
	 
	 
		public static void main(String[] args) {
			String a = "鑾峰彇鐢ㄦ埛缈煎瓨瀹濈粺璁′俊鎭�";
			String b = "[鎴戠殑璐︽埛>>缈煎瓨瀹漖";
			String c = " 鐢ㄦ埛ID";
			BobTestCo bob = new BobTestCo();
			try {
				System.out.println(bob.changeCharset(a, GBK, UTF_8));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			try {
				System.out.println(bob.changeCharset(b, GBK, UTF_8));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println(bob.changeCharset(c, GBK, UTF_8));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		 /**
		  * 字符串编码转换的实现方法
		  * @param str  待转换编码的字符串
		  * @param oldCharset 原编码
		  * @param newCharset 目标编码
		  * @return
		  * @throws UnsupportedEncodingException
		  */
		 public String changeCharset(String str, String oldCharset, String newCharset)
		   throws UnsupportedEncodingException {
		  if (str != null) {
		   //用旧的字符编码解码字符串。解码可能会出现异常。
		   byte[] bs = str.getBytes(oldCharset);
		   //用新的字符编码生成字符串
		   return new String(bs, newCharset);
		  }
		  return null;
		 }
}
