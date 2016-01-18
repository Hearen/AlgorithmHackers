package com.josh.task7;

import org.junit.Test;
/*
 * 给定一个字符串，求最小回文串
 */
public class ShortestPalindrome {
	@Test
	public void test(){
		String str = "aabaaa";
		System.out.println(shortestPalindrome(str));
		//System.out.println(isPalindrome(str));
	}
	//首相判断给定的字符串是否是回文串，若是，直接输出；若不是，构造最短回文
    public String shortestPalindrome(String s) {
		if(s.length()==0 || isPalindrome(s)) return s;
		int mid=0;//note：cbabcd - dcbabcd not dcbabcbabcd
		for(int i=0;i<s.length();i++){//寻找回文中点
			int pre = i-1,next = i+1;
			while((pre>=0 && next<s.length()) && s.charAt(pre) == s.charAt(next)){
				pre--;
				next++;
			}
			if(pre<0) mid = i;
		}
		String subStr = s.substring(2*mid+1, s.length());//截取后面字符串
		String reverseSubStr = reverse(subStr);//构造回文部分
    	return reverseSubStr+s;
        
    }
    public boolean isPalindrome(String s){
    	if(s.length() == 1) return true;
    	int head = 0,end = s.length()-1;//前后位置指针
    	while(head<end){
    		if(s.charAt(head) != s.charAt(end)) return false;
    		head ++;
    		end --;
    	}
    	return true;
    }
    public String reverse(String str){
    	if(str.length() == 0) return null;
    	String reverseStr = str.substring(str.length()-1, str.length());
    	for(int i=str.length()-2;i>=0;i--){
    		reverseStr = reverseStr + str.charAt(i);
    	}
    	return reverseStr;
    }
}
