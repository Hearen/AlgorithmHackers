package com.sky.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DuanSky
 * @date 2015年12月16日 上午9:26:28
 * @content 
 */

public class _316_RemoveDuplicateLetters_1 {
	
	public static void main(String args[]){
		String s="cbacdcbc";
		System.out.println(removeDuplicateLetters(s));
	}
	
	//TODO不能理解为什么这么做。。。。。。。。
	public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;

        //在字符串中最后一次出现该字符的位置。
        Map<Character, Integer> lastPosMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPosMap.put(s.charAt(i), i);
        }

        char[] result = new char[lastPosMap.size()];
        int begin = 0, end = findMinLastPos(lastPosMap);

        for (int i = 0; i < result.length; i++) {
            char minChar = 'z' + 1;
            for (int k = begin; k <= end; k++) {
                if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    begin = k+1;
                }
            }

            result[i] = minChar;
            if (i == result.length-1) break;

            lastPosMap.remove(minChar);
            if (s.charAt(end) == minChar) 
            	end = findMinLastPos(lastPosMap);
        }

        return new String(result);
    }

    private static int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if (lastPosMap == null || lastPosMap.isEmpty()) return -1;
        int minLastPos = Integer.MAX_VALUE;
        for (int lastPos : lastPosMap.values()) {
             minLastPos = Math.min(minLastPos, lastPos);
        }
        return minLastPos;
    }
	
	/*
	 * 该题总共有两个条件，一个是字典序，一个是统计所有出现的字符。最后给出的顺序必须是按照字符出现的顺序。
	 * 不能违反原来字符的相对位置。
	 */
	public static String removeDuplicateLetters_2(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
        	//这里是记录目前出现的最小字符的位置。
            if (s.charAt(i) < s.charAt(pos)) 
            	pos = i;
            /*如果在查找最小字符过程中，出现了某个字符的总次数为0的情况，即在后面的字符中，不再出现了该字符。那么即从pos处截断，
             * 因为pos是目前找到的最小的字符，所以可以保证这样的截断是字典序的，又因为在pos之前出现的字符，在后面都会再次出现，
             * （可以反过来想，如果在pos之前出现的字符在后面没有出现，那么会立即在后面没有再次出现该字符的位置跳出循环，而该位置一定不小于pos
             * 的位置，）可以重复这样的过程，直至把所有的字符都找完。
             */
            if (--cnt[s.charAt(i) - 'a'] == 0) 
            	break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	
	//MISTAKE 没有理解清楚题意。
	public static String removeDuplicateLetters_wrong_solution(String s) {
		byte flags[]=new byte[26];
		for(int i=0;i<s.length();i++){
			flags[s.charAt(i)-'a']=1;
		}
		String result="";
		for(int i=0;i<flags.length;i++){
			if(flags[i]==1)
				result+=(char)(i+'a')+"";
		}
		return result;
    }
}
