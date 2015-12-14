/**
 * 这道题寻找最长不重复的子串，可以采用动态规划的思想，采用两个指针，一个指向目前子段的开头，一个指向正在检查的字符；
 * 如果这个字符在前面的子段中不存在，则可以将这个字符加入到子段中，同时最大长度+1;如果这个字符在前面的子串中已经出现，则说明
 * 该子串遍历结束，计算出其长度，更新最长子串值，同时将start指针指向在该子串中出现该字符的下一个位置，继续遍历。
* @author DuanSky
* @date 2015年12月7日 下午10:50:28
* @content 
*/
package com.sky.leetcode;

public class _003_LongestSubstringWithoutRepeatingCharacters {

	
	public static void main(String args[]){
		String s="abfdda";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0) return 0;
        int max=1;int start=0;
        for(int i=1;i<s.length();i++){
        	char c=s.charAt(i);
        	int position=0;
        	if((position=s.substring(start,i).indexOf(c))==-1){
        		if(i-start+1>max) //update max
        			max=i-start+1;
        	}
        	else
        		start=start+position+1;
        }
        return max;
    }
}
