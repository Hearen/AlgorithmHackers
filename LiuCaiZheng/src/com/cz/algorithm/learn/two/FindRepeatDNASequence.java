package com.cz.algorithm.learn.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRepeatDNASequence {

	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		new  FindRepeatDNASequence().findRepeatedDnaSequences(s);
	}
	
	/**
	 *  during the process to compute the subString, we can use the hash algorithm to compute the hash value to identify weather two string is equal or not
	 *    this is a inspect and method to solve the class question.
	 * */
	public List<String> findRepeatedDnaSequences(String s) {

		List<String> result = new ArrayList<String>();
		if (s == null || s.length() < 10)
			return result;
		int len = s.length();
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> unique = new HashSet<Integer>();
		int hash = 0;
		for (int i = 0; i < len; i++) {
			if (i < 9) {
				hash = (hash << 2) + getVal(s.charAt(i));
			} else {
				hash = (hash << 2) + getVal(s.charAt(i));
				// in the subStirng it has 10 , so the 20bit is enough for the
				// subString.
				hash &= (1 << 20) - 1;
				if (set.contains(hash) && !unique.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					unique.add(hash);
					System.out.println(s.substring(i - 9, i + 1));
				} else {
					set.add(hash);
				}
			}
		}
		return result;
	}

	private int getVal(char ch) {
		if (ch == 'A')
			return 0;
		if (ch == 'C')
			return 1;
		if (ch == 'G')
			return 2;
		if (ch == 'T')
			return 3;
		return -1;
	}
}
