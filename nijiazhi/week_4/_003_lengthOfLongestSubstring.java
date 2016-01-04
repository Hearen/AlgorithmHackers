package leetcode_njz;

import java.util.HashMap;
import java.util.Map;

public class _003_lengthOfLongestSubstring {
	
	//贪心算法
	//�?�?个数组记录当前字符最近出现的位置，一遍算过去，更新左边界，用计算�?大�?�就行了�?
	public static int lengthOfLongestSubstring(String s){
		int len = 0, left = 0;  
        int prev[] = new int[300]; //asc码使�?
  
        // init prev array  
        for (int i = 0; i < 300; ++i)  
            prev[i] = -1;  
  
        for (int i = 0; i < s.length(); ++i) {  
            if (prev[s.charAt(i)] >= left)//当前这个字符出现�?
                left = prev[s.charAt(i)] + 1;//更新�?始位�?
            
            prev[s.charAt(i)] = i;  
            
            if (len < i - left + 1)  
                len = i - left + 1;  
        }  
        return len;  
	}
	
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
		
		int rs = lengthOfLongestSubstring(s);
		System.out.println(rs);
		
		int rs1 = lengthOfLongestSubstring1(s);
		System.out.println(rs1);
	}
}
