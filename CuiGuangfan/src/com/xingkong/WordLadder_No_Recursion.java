package com.xingkong;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月2日 上午3:10:36 class description
 */
public class WordLadder_No_Recursion {
	public int ladderLength(String start, String end, Set<String> dict_set) {
		HashSet<String> dict=new HashSet<String>(dict_set);
		if (start.equals(end) == true || start == null || end == null) {
			return 0;
		}
		LinkedList<String> queue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
		queue.add(start);
		distanceQueue.add(1);
		int ret = 0;
		while (!queue.isEmpty()) {
			String str = (String) queue.poll();
			ret = (int) distanceQueue.poll();
			for (int i = 0; i < str.length(); i++) {
				char[] strCharArr = str.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					strCharArr[i] = c;
					String newWord = new String(strCharArr);
					if (dict.contains(newWord)) {
						if (newWord.equals(end)) {
							return ret + 1;
						}
						queue.add(newWord);
						distanceQueue.add(ret + 1);
						dict.remove(newWord);
					}
				}
			}
		}
		return 0;
	}
}