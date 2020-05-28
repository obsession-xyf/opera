package com.sxl.util;

import java.util.UUID;

/**
 * 主键生成器
 * 
 * 
 */
public class UUIDGenerator {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
