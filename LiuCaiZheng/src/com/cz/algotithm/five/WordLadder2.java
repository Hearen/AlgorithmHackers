package com.cz.algotithm.five;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//运行时间是89ms.
public class WordLadder2 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		String beginWord = "hit";
		String endWord = "cog";
		System.out.println(new WordLadder().ladderLength(beginWord, endWord, set));
	}

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		if (wordList.size() == 0)
			return 0;

		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		wordQueue.add(beginWord);
		distanceQueue.add(1);

		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();
			if (currWord.equals(endWord)) {
				return currDistance;
			}
			for (int i = 0; i < currWord.length(); i++) {
				char[] currCharArr = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;
					String newWord = new String(currCharArr);
					if (wordList.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						wordList.remove(newWord);
					}
				}
			}
		}
		return 0;
	}
}
