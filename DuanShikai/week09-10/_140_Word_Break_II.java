package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author DuanSky
 * @date 2016年3月11日 下午1:11:27
 * @content 
 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
"catsanddog"
["cat","cats","and","sand","dog"]
 */

public class _140_Word_Break_II {
	
	public static void main(String args[]){
		_140_Word_Break_II test = new _140_Word_Break_II();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Set<String> wordDict = new HashSet<>(Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
		System.out.println(test.wordBreak_1(s, wordDict));
	}
	
	
	//算法 o(n^2)复杂度 Time Limit Exceeded ！！！
	private List<String> wordBreak(String s, Set<String> wordDict) {
		if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<String>();
		List<String>[] d = new ArrayList[s.length()];
		for(int i=0;i<s.length();i++) {
			d[i]=new ArrayList<String>();
			if(wordDict.contains(s.substring(0,i+1))) 
				d[i].add(s.substring(0,i+1));
			for(int j=1;j<=i;j++){ //j 是 分裂点，将原来的串分解成  d[j-1],s[j~i]
				String tail = s.substring(j,i+1); 
				 if(wordDict.contains(tail)){
					 if(d[j-1].size() != 0){
						 for(String temp : d[j-1]){
							 d[i].add(temp +" " + tail);
							// wordDict.add(temp+" "+tail);
						 }
					 }
				 }
			}
		}
		return d[s.length()-1];
	}


	//很朴素直白的想法，但是效率依旧很慢。Time Limit Exceeded 
	public List<String> wordBreak_1(String s, Set<String> wordDict) {
		Map<String,List<String>> cache = new HashMap<>();
		return core_(s,wordDict,cache);
    }
	public List<String> core_(String s,Set<String> wordDict,Map<String,List<String>> cache){
		if(cache.containsKey(s)) return cache.get(s);
		List<String> res = new ArrayList<String>();
		if(wordDict.contains(s)){
			res.add(s);
		}
		for(int i = 0; i < s.length(); i++){
			String temp = s.substring(0,i+1); //固定左边进行分解
			if(wordDict.contains(temp)){ //如果左边是一个单词
				List<String> list = core_(s.substring(i+1),wordDict,cache); //这个是右边的分解情况
				if(list!=null && list.size()!=0){ //右边不为空，即右边可分解
					for(String curr : list){
						res.add(temp + " " + curr);
					}
				}
			}
		}
		cache.put(s, res);
		return res;
	}
}
