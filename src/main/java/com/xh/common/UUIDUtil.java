package com.xh.common;

import java.util.UUID;

public class UUIDUtil {
	/**
	 * 得到指定数量的UUID，以数组的形式返回
	 * @param num
	 * @return
	 */
	public static String[] getUUID(int num) {
		if (num <= 0)
			return null;
		String[] uuidArr = new String[num];
		for (int i = 0; i < uuidArr.length; i++) {
			uuidArr[i] = getUUID32();
		}
		return uuidArr;
	}
	/**
	 * 得到32位的uuid
	 * @return
	 */
	public static String getUUID32() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
	 
}
