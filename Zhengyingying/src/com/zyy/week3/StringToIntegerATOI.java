package com.zyy.week3;

public class StringToIntegerATOI {
	// 把字符串转换成int类型，需要找到其中的数字组成的字符串
	public int myAtoi(String str) {
		int first = 0;
		int result = 0;
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			// 空字符unicode 32
			if (str.charAt(i) == (char) 32) {
				continue;
			} else {
				if(!(str.charAt(i) == (char) '-' || str.charAt(i) >= '0'
						&& str.charAt(i) <= '9'))
				if (str.charAt(i) == (char) '-' || str.charAt(i) >= '0'
						&& str.charAt(i) <= '9') {
					first = i;
					flag = true;
					break;
				} else {
					return 0;
				}
			}
		}
		if (!flag) {
			return 0;
		} else {
			if (first == str.length() - 1 && str.charAt(first) == (char) '-') {
				return 0;
			}
			result = Integer.valueOf(str.substring(first, str.length()));
			if (result > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if (result < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			} else {
				return result;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Integer.valueOf("-+1"));
		String data = "   -53423";
		// System.out.println(Integer.valueOf("123"));
		StringToIntegerATOI st = new StringToIntegerATOI();
		System.out.println(st.myAtoi(data));
		System.out.println(st.myAtoi("-"));
		System.out.println(st.myAtoi("-+1"));
		System.out.println(st.myAtoi("       "));
	}

}
