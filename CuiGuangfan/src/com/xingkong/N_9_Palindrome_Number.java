package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月6日 上午10:53:58 
* class description
*/
public class N_9_Palindrome_Number {
	public static boolean isPalindrome(int x) {
		if(x<0) return false;
        long result=0;
        int original=x;
        for(;x!=0;x/=10){
        	result=result*10+x%10;
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
        	return false;
        }else if((int)result!=original)
        	return false;
        return true;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_9_Palindrome_Number.isPalindrome(0));
	}

}
