package leetcode_njz;

import java.util.HashMap;
import java.util.Map;

public class _003_lengthOfLongestSubstring {
	
	//map记录位置，left记录当前最左的位置
	public static int lengthOfLongestSubstring1(String s){
		if(s==null || s.length()==0)
			return 0;
		
		Map<String,Integer> posMap = new HashMap<>();
		int left = 0;
		int rs_len = 0;
		for(int cur=0; cur<s.length(); cur++){
			String cur_str = s.substring(cur,cur+1);
			
			if(posMap.containsKey(cur_str)){
				int tmp_pos = posMap.get(cur_str);
				left = (tmp_pos>=left)? tmp_pos+1 : left;
			}
			posMap.put(cur_str, cur);
			rs_len = (rs_len<cur-left+1)? cur-left+1 : rs_len;
		}
		
		return rs_len;
	}
	
	public static void main(String[] args){
		String s = new String("abba");
		
		int rs1 = lengthOfLongestSubstring1(s);
		System.out.println(rs1);
	}
}
