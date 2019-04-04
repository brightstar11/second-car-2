package com.xh.common;

import java.security.MessageDigest;


public class MD5Util {
	// 密盐
	private static final char HEXDIGITS[] = {'0','1','2','3','4','~','!','@','#','$','%','^','&','*','(',')','?','<','>','-','='};
	/**
	 * 生成32位MD5码,默认密盐加密
	 * @param key
	 * @return
	 */
	public static String MD5(String key) {
		try {
			byte[] btInput = key.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = HEXDIGITS[byte0 >>> 4 & 0xf];
				str[k++] = HEXDIGITS[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 生成32位MD5码  
	 * @param key
	 * @param hexDigits 自定义密盐加密
	 * @return
	 */
	public static String MD5(String key,char[] hexDigits) {
		try {
			byte[] btInput = key.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 判断明文加密后是否与密文相等
	 * @param key
	 * @param md5Str
	 * @return
	 */
	public static Boolean checkEquals(String key,String md5Str){
		return MD5(key).equals(md5Str);
	}
	public static void main(String[] args) {
		System.out.println(MD5Util.MD5(""));
	}
}
