package com.zyy.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
	// 运行超时
	public int lengthOfLongestSubstring1(String s) {
		int maxLength = 0;
		List<Character> list = new ArrayList<Character>();
		for (char c : s.toCharArray()) {
			if (!list.contains(c)) {
				list.add(c);
				if (maxLength < list.size()) {
					maxLength = list.size();
				}
			} else {
				int position = list.indexOf(c) + 1;
				list = list.subList(position, list.size());
				list.add(c);
			}
		}
		return maxLength;
	}

	/**
	 * 用HashMap存放出现过的字符， 当出现重复的字符的时候，比较现在的位置和之前的位置， 他们的差值就是当前字符串的长度，和最大值比较
	 * 
	 */
	// 正常运行
	public int lengthOfLongestSubstring2(String s) {
		if (s.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int maxLength = 0;
		int length = 0;
		for (char c : s.toCharArray()) {
			length++;
			if (map.containsKey(c) && (length > (i - map.get(c)))) {
				length = i - map.get(c);
			}
			map.put(c, i);
			maxLength = Math.max(maxLength, length);
			i++;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(lswrc.lengthOfLongestSubstring2("abba"));
		System.out.println(lswrc.lengthOfLongestSubstring2("ldmvdf"));
		System.out.println(lswrc.lengthOfLongestSubstring2("pwwkew"));
	}
}
