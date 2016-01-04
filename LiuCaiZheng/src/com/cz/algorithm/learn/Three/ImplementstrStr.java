package com.cz.algorithm.learn.Three;

////  https://leetcode.com/problems/implement-strstr/

/**
 * here we use the KMP algorithm to achieve the goal. the method of KMP
 * algorithm: to use the information have been compared and
 * 
 * 
 * 
 * 
 * 
 * the complexity of time is O(m + n); the complexity of space is O(m);
 * */
public class ImplementstrStr {

	public static void main(String[] args) {
		String str = "ksdasdfasdfsdfas";
		String needle = "sdfsd";
		System.out.println(new ImplementstrStr().strStr(str, needle));
	}

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null
				|| haystack.length() < needle.length()) {
			return -1;
		}
		if (haystack.length() == 0 && haystack.length() == 0)
			return 0;
		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

}
