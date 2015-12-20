package com.zyy.week3;

public class ValidPalindrome {

	// 循环两遍:38%
	public boolean isPalindrome(String s) {
		// alphanumeric 包括文字和数字
		StringBuilder sb = new StringBuilder();
		// 去除字符串中的空格等多余元素
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isInRange(c)) {
				sb.append(Character.toLowerCase(c));
			}
		}
		int begin = 0, end = sb.length() - 1;
		while (begin < end) {
			char a = sb.charAt(begin);
			char b = sb.charAt(end);
			// 0:a=b;-1:a<b;1:a>b
			if (Character.compare(a, b) != 0) {
				return false;
			}
			begin++;
			end--;
		}
		return true;

	}

	public boolean isInRange(char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0'
				&& c <= '9';
	}

	//66.6%
	public boolean isPalindrome1(String s) {
		int begin = 0, end = s.length() - 1;
		while (begin < end) {
			char a = s.charAt(begin);
			char b = s.charAt(end);
			if (!isInRange(a)) {
				begin++;
			}
			if (!isInRange(b)) {
				end--;
			}
			if (isInRange(s.charAt(begin)) && isInRange(s.charAt(end))) {
				if (Character.compare(Character.toLowerCase(s.charAt(begin)),
						Character.toLowerCase(s.charAt(end))) != 0) {
					return false;
				}
				begin++;
				end--;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		String str1 = "race a car";
		String str2 = "";
		String str3 = " ";
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome1(str));
		System.out.println(vp.isPalindrome1(str2));
		System.out.println(vp.isPalindrome1(str3));
	}
}
