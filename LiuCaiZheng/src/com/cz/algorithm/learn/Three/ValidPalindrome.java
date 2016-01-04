package com.cz.algorithm.learn.Three;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(new ValidPalindrome().isPalindrome(s));
	}
		public boolean isPalindrome(String s) {
			int len = s.length();
			int left = 0;
			int right = len -1;
			while(left < right) {
			    if(!isAlphanumeric(s.charAt(left))) {
					left ++;
				} 
			    if(!isAlphanumeric(s.charAt(right))) {
					right --;
				} 
			    if(isAlphanumeric(s.charAt(left)) && isAlphanumeric(s.charAt(right))){
					if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) ) {
						return false;
				   }
					left ++;
					right --;
			}
		}
		return true;
	}
	private boolean isAlphanumeric(char ch) {
		if( ch >= 'A'  &&  ch <= 'Z'  || ch >= 'a'  && ch <= 'z' || ch >= '0' && ch <= '9')
			     return true;
		return false;
	}
}
