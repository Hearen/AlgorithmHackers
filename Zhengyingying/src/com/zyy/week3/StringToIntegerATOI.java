package com.zyy.week3;

import java.util.HashMap;
import java.util.Map;

public class StringToIntegerATOI {
	// 把字符串转换成int类型，需要找到其中的数字组成的字符串
	public int myAtoi(String str) {
		if (str.equals("")) {
			return 0;
		}
		int target = 0;
		int len = 0;
		StringBuilder sb = new StringBuilder();
		int start = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < 10; i++) {
			map.put("'" + i + "'", i);
		}
		for (int i = 0; i < str.length(); i++) {
			if ("-".equals(str.charAt(i)) || "+".equals(str.charAt(i))) {
				start = i;
			}
		}

		for (int i = start + 1; i < i + 10; i++) {
			if (map.containsKey(str.charAt(i))) {
				sb.append(map.get(str.charAt(i)));
				len++;
			} else {
				break;
			}
		}

		target = Integer.parseInt(sb.toString());

		if (target > Integer.MAX_VALUE) {
			target = Integer.MAX_VALUE;
		}

		if ("-".equals(str.charAt(start))) {
			return 0 - target;
		} else {
			return target;
		}

	}

	public static void main(String[] args) {
		String data = "   -53423";
		StringToIntegerATOI st = new StringToIntegerATOI();
		System.out.println(st.myAtoi(data));
	}

}
