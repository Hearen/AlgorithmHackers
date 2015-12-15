package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月15日 上午11:01:13
 * @content
 * 	Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases. 
 */

public class _125_ValidPalindrome {
	
	public static void main(String args[]){
		String s="ab2a";
		System.out.println(isPalindrome(s));
	}
	
	/*
	 * 本题首先没有理解alphanumeric的意思，以为只是字母，实际上指的是字母和数字；
	 * 本以为 a~Z 是连续的ascII,其实是分开的，因此需要按照大小写分开来判断区间；
	 * 本题怎么从前面找到第一个字母数字，以及怎么从后面找到第一个字母数字 的方法，调试了多次。
	 */
	public static boolean isPalindrome(String s){
		if(s.length()==0) return true;
		int start=-1; int end=s.length(); //start是上一次从前面找到字符的位置，end是上一次从后面找到字符的位置
		while(start<end){
			char left=s.charAt(++start); //如果该位置不是字符，就一直循环往下找
			while(!(('0'<=left && left<='9') || ('a'<=left && left<='z') || ('A'<=left && left<='Z'))){
				if(++start==end) return true;
				left=s.charAt(start);//while循环出来后，start指向的位置，肯定是字符
			}
			char right=s.charAt(--end); //如果该位置不是字符，就一直循环往上找，一直到找到字符为止。
			while(!(('0'<=right && right<='9') || ('a'<=right && right<='z') || ('A'<=right && right<='Z'))){
				right=s.charAt(--end);
			}
			//MISTAKE 注意这里需要判断大小写，所以分两种情况。
			if(left!=right && Math.abs(left-right)!=32)
				return false;
		}
		return true;
	}
	
	/*
	 * MISTAKE a~z 97-122; A~Z 65-90
	 */
	 public static boolean isPalindrome_time_limited(String s) {
		 String r="";
		 for(int i=0;i<s.length();i++){
			 char current=s.charAt(i);
			 if(('a'<=current && current<='z') ||('A'<=current && current<='Z'))//该字符是字母
				 r+=current;
		 }
		 String l="";
		 for(int i=s.length()-1;i>=0;i--){
			 char current=s.charAt(i);
			 if(('a'<=current && current<='z') ||('A'<=current && current<='Z'))//该字符是字母
				 l+=current;
		 }
		 return r.equalsIgnoreCase(l);
	 }

}
