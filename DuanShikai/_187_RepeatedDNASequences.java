/**
* @author DuanSky
* @date 2015年12月8日 下午10:02:38
* @content 
*/
package com.sky.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _187_RepeatedDNASequences {
	
	public static void main(String args[]){
		String s = "AAAAAAAAAAAAA";
		System.out.println(findRepeatedDnaSequences(s));
	}
	
	
	public static List<String> findRepeatedDnaSequences(String s){
		Map<Integer,Boolean> words=new HashMap<Integer,Boolean>();
		List<String> result=new ArrayList<String>();
		int[] map=new int[26];
		map['A'-'A']=0;map['C'-'A']=1;map['G'-'A']=2;map['T'-'A']=3;
		for(int i=0;i<s.length()-9;i++){
			int word=0;
			for(int j=i;j<i+10;j++){
				word<<=2;//上次字符左移两位
				word+=map[s.charAt(j)-'A'];
			}
			if(words.containsKey(word)){
				if(words.get(word)){
					result.add(s.substring(i,i+10));
					words.put(word, false);
				}
			}
			else
				words.put(word, true);
		}
		return result;
	}
	
	/*
	 * 标准答案
	 * 1. 将10个字符映射到整数上，可以大大简化比较的速度；
	 * 2. 采用双集合可以巧妙的用来判断子串恰巧在出现两次的时候添加，在出现一次和三次的时候都不添加。
	 */
	public static List<String> findRepeatedDnaSequences_Answer(String s) {
	    Set<Integer> words = new HashSet<>();
	    Set<Integer> doubleWords = new HashSet<>();
	    List<String> rv = new ArrayList<>();
	    char[] map = new char[26];
	    //map['A' - 'A'] = 0;
	    map['C' - 'A'] = 1;
	    map['G' - 'A'] = 2;
	    map['T' - 'A'] = 3;

	    for(int i = 0; i < s.length() - 9; i++) {
	        int v = 0;
	        for(int j = i; j < i + 10; j++) {
	            v <<= 2;
	            v |= map[s.charAt(j) - 'A'];
	        }
	        if(!words.add(v) && doubleWords.add(v)) {//左值计算，如果左边返回为空，就不会再执行右边
	            rv.add(s.substring(i, i + 10));
	        }
	    }
	    return rv;
	}
	
	//o(n^2)复杂度
	public static List<String> findRepeatedDnaSequences_TimeLimited(String s) {
		Set<String> result=new HashSet<String>();
        if(s.length()<20)
        	return new ArrayList<String>(result);
        for(int i=0;i<s.length()-20;i++){
        	String test=s.substring(i,i+10);
        	if(result.contains(test))
        		continue;
        	for(int j=i+10;j<s.length()-10;j++){
        		String iscopy=s.substring(j,j+10);
        		if(test.equals(iscopy)){
        			result.add(test);
        			break;
        		}
        	}
        }
        return new ArrayList<String>(result);
    }

}
