package com.zyy.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {

	//使用Map存放10位的数组，如果有重复出现一次的就放入结果集中，如果多于一次，就让value值增加
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < s.length() - 9; i++) {
			String t = s.substring(i, i + 10);
			if (map.containsKey(t)) {
				if (map.get(t) == 1) {
					result.add(t);
				}
				map.put(t, map.get(t) + 1);
			} else {
				map.put(t, 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RepeatedDNASequences rds = new RepeatedDNASequences();
		String s = "AAAAAAAAAAAAA";
		List<String> result = rds.findRepeatedDnaSequences(s);
		for (String t : result) {
			System.out.println(t);
		}

	}

}
