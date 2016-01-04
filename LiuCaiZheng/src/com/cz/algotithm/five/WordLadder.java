package com.cz.algotithm.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {

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
		if(wordList == null  || wordList.size() == 0  || beginWord == null || endWord == null)  return 0;
		//create graph  
	       HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();  
	         
	       graph.put(beginWord, new ArrayList<String>());  
	       graph.put(endWord, new ArrayList<String>());  
	       for(String d : wordList) {  
	           graph.put(d, new ArrayList<String>());  
	       }  
	       for(String s : graph.keySet()) {  
	           ArrayList<String> list = graph.get(s);  
	           for(String t : graph.keySet()) {  
	               if(getDiff(s,t) == 1) {  
	                   list.add(t);  
	               }                
	           }  
	       }  
	       // use BFS to traverse the node in the graph, we begin with "start"  
	       int step = 0;  
	       HashSet<String> visited = new HashSet<String>();  
	       ArrayList<String> firstLevel = new ArrayList<String>(graph.get(beginWord));  
	       while (firstLevel.size() != 0) {  
	           step++;  
	           ArrayList<String> nextLevel = new ArrayList<String>();  
	           for (String s : firstLevel) {  
	               if (s.equals(endWord)) return step + 1;  
	               visited.add(s);  
	               nextLevel.addAll(graph.get(s));  
	           }  
	           firstLevel.clear();  
	           for (String t : nextLevel) {  
	               if (!visited.contains(t)) {  
	                   firstLevel.add(t);  
	               }  
	           }  
	           nextLevel.clear();  
	       }  
		return 0;
	}
	private  int getDiff(String w1, String w2) {  
	       int count = 0;          
	       for(int i = 0; i < w1.length(); i++) {  
	           if(w1.charAt(i) != w2.charAt(i)) {  
	               count++;  
	           }  
	       }  
	       return count;  
	    }  
}
