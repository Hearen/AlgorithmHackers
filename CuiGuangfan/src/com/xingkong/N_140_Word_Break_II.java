package com.xingkong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月10日 下午9:59:12 
* class description
*/
public class N_140_Word_Break_II {
	public List<String> result=new ArrayList<String>();
	public List<String> wordBreak(String s, Set<String> wordDict) {//timeout
		Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
		for(String word:wordDict){
			int pos=s.indexOf(word);
			while(pos!=-1){
				Integer start=pos;
				Integer end=pos+word.length();
				if(!map.containsKey(start)) 
					map.put(start, new ArrayList<Integer>());
				map.get(start).add(end);
				pos=s.indexOf(word,start+1);
			}
		}
		recusive(0,map,s,"");
        return this.result;
    }
	
	private void recusive(int key,Map<Integer,List<Integer>> map,String orginal,String s){
		if(key>=orginal.length()) {
			if(!s.trim().equals(""))
				result.add(s.trim());
			return;
		}
		if(!map.containsKey(key)) return ;
		List<Integer> list=map.get(key);
		for(Integer i:list){
			//System.out.println(i);
			recusive(i,map,orginal,orginal.substring(key,i)+" "+s);
		}
	}
	HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    public List<String> wordBreak1(String s, Set<String> wordDict) {//15ms
        List<String> res = new ArrayList<String>();
        if(s.isEmpty())
            return res; // return empty list upon empty string

        if(map.containsKey(s))
            return map.get(s);

        for(int i=0; i<s.length(); i++) {
            String firstWord = s.substring(0,i+1);
            if(wordDict.contains(firstWord)) {
                List<String> rest = wordBreak1(s.substring(i+1),wordDict);
                if(rest.isEmpty()) {
                    if(i==s.length()-1)
                        res.add(firstWord);
                } else {
                    for(String str : rest)
                        res.add(firstWord + " " + str);
                }
            }
        }

        map.put(s,res);

        return res;
    }
	public static void main(String[] args){
		N_140_Word_Break_II n=new N_140_Word_Break_II();
		Set<String> set=new HashSet<String>();
		set.add("a");
		set.add("aa");
		set.add("aaa");
		set.add("aaaa");
		set.add("aaaaa");
		set.add("aaaaaa");
		set.add("aaaaaaa");
		set.add("aaaaaaaa");
		set.add("aaaaaaaaa");
		System.out.println(n.wordBreak("aaaaaaa" //7
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"//36
				+ "aaaaaaaaaabaaaaaaaaaaaaaaaaaa"//28
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaa", set));
	}
}
