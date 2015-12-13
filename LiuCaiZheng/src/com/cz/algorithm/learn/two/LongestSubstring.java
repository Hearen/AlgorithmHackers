package com.cz.algorithm.learn.two;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstring {

	public static void main(String[] args) {
		String s = "asdfgfsds";
		int n =  findLongestSubString(s);
	    System.out.println(n);
	}
	/**
	 * 暴力破解这个解法,时间复杂度是 O(n2).
	 * 不是最优解.不可取.
	 * 
	 * 把字符串转化为字符数组,对字符数组排序,
	 *     然后一遍扫描, 时间复杂度取决于排序算法 最好的是 O(nLogn)
	 * 
	 * 应该存在时间复杂度是O(n)的情况
	 * 使用map数据结构进行解决.
	 * 
	 * 思路说明:寻找两个相同字母之间的长度,作为嫌疑长度进行考察.
	 *       并且保存一个中间值进行标记.
	 * */
	public static int findLongestSubString(String s) {
		if(s == null || s.length() == 0) return 0;
		int  max = -1;
		int lastIndex = -1;
		Map <Character, Integer>  letterMap = new HashMap<Character, Integer>();
		for(int i = 0 ; i < s.length(); i ++) {
			char temp = s.charAt(i);
			if(letterMap.containsKey(temp) && lastIndex < letterMap.get(temp)) {
				lastIndex = letterMap.get(temp);
			}
			if( i - lastIndex > max) 
				  max = i - lastIndex;
			letterMap.put(temp , i);
		}
		return max;
	}
}
