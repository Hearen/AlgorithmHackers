package com.zyy.week3;

public class ImplementStr {

	public int strStr(String haystack, String needle) {
		// 判断空
		if (needle.equals("")) {
			return 0;
		}
		if (haystack.equals("")) {
			return -1;
		}
		// 找到haystack中包含字符串needle的第一个字符的位置
		int len = needle.length();
		for (int i = 0; i < haystack.length() - len + 1; i++) {
			// equal 而非 ==
			if (haystack.charAt(i) == needle.charAt(0)) {
				if (haystack.substring(i, i + len).equals(needle)) {
					return i;
				}
			}
		}
		//没有满足条件的
		return -1;

	}

	public static void main(String[] args) {
		String haystack = "";
		String needle = "";
		ImplementStr is = new ImplementStr();
		System.out.println(is.strStr(haystack, needle));
	}

}
