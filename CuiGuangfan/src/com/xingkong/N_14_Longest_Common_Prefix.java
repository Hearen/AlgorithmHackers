package com.xingkong;

import java.util.Arrays;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月7日 下午10:07:26 
* class description
*/
public class N_14_Longest_Common_Prefix {
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0) return "";
		char[] array=strs[0].toCharArray();
		char[] tempArray;
		for(int i=1;i<strs.length;i++){
			tempArray=strs[i].toCharArray();
			int count=0;
			for(int j=0;j<tempArray.length&&j<array.length;j++){
				if(array[j]==tempArray[j]) {
					count++;
				}
				else break;
			}
			if(count==0) return "";
			array=Arrays.copyOfRange(array, 0, count);
		}
        return String.valueOf(array);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_14_Longest_Common_Prefix.longestCommonPrefix(new String[]{"","b"}));
	}

}
