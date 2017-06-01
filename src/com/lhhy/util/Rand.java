package com.lhhy.util;

public class Rand {

	public String rand(int length) {
		// 字符源，可以根据需要删减
		String str = "0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String rtnStr = "";
		for (int i = 0; i < length; i++) {
			// 循环随机获得当次字符，并移走选出的字符
			String nowStr = String.valueOf(str.charAt((int) Math.floor(Math.random() * str.length())));
			rtnStr += nowStr;
			str = str.replaceAll(nowStr, "");
		}
		return rtnStr;
	}

}
