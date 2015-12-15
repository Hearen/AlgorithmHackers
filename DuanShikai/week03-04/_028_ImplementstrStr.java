package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月15日 上午10:06:49
 * @content 
 */

public class _028_ImplementstrStr {
	
	public static void main(String args[]){
		String haystack="mississippi";
		String needle="issip";
		System.out.println(strStr(haystack,needle));
		
	}
	
	/*
	 * 	算法的思想是给定两个指针，用这两个指针指向当前需要比较的两个字符，如果这两个字符相等，
	 * 则继续比较下一个字符，如果下一个字符不相等，则需要重置，然后从头开始比较。直到遍历到
	 * haystack的结尾或者找到为止。
	 */
	
	public static int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int i=0; int j=0; int counter=0; int lastPos=-1;
        while(i<haystack.length() && j<needle.length()){
        	char cn=needle.charAt(j);
        	char ch=haystack.charAt(i);
        	if(cn==ch){//找到相同的元素
        		//MISTAKE 这里要先进行判断是否是最后一个相同的元素。
        		if(counter+1==needle.length()) //这是最后一个相同的元素
    				return lastPos-counter+1;
        		else if(counter==0)//这是第一个相同的元素
        			lastPos=i;
    			else //既不是第一个，也不是最后一个相同的元素
    				lastPos++;
    			counter++;i++;j++; //接着往下找
        	}
        	else {//如果这个元素不相同，则需要重新开始找
        		//MISTAKE 如果发现有元素不匹配时，需要重新开始查找，j置为0，i将从上一次找到的地方的下一个地方继续查找。
        		j=0;i=i-counter+1;lastPos=-1;counter=0;
        	}
        }
        return -1;
    }
}
