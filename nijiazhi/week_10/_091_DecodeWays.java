package leetcode_njz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class _091_DecodeWays {
	
	/*
	 * 初始思想 --- 回溯法，按照1个、2个去匹配
	 */
	public static int numDecodings(String s) {
		if(s==null || s.length()==0) return 0; 
		
		List<Integer> rs = new ArrayList<Integer>();
		dfs(0,rs,s);
		return rs.size();
    }
	
	
	private static void dfs(int cur, List<Integer> rs, String s) {
		if(cur<0) return;
		if(cur==s.length()) {
			rs.add(1);
			return;
		}
		
		//处理1位情况
		int cur_val = Integer.valueOf(s.substring(cur,cur+1));
		if(cur_val>0 && cur_val<10)
			dfs(cur+1, rs, s);
		
		//处理2位情况
		if(cur < s.length()-1){
			int pre_val = Integer.valueOf(s.substring(cur,cur+2));
			if(pre_val>=10 && pre_val<= 26)
				dfs(cur+2, rs, s);
		}
		
	}


	/*
	 * dp思想 --- 来源于回溯法，在回溯的过程中，做了很多次重复计算
	 * dp[i]代表当前的匹配方法数目，也是考虑两种情况
	 */
	public static int numDecodings_1(String s) {
		if(s==null || s.length()==0) return 0; 
		
		int[] dp = new int[s.length()];
		//dp[0]
		if(Integer.valueOf(s.substring(0,1))>0 && Integer.valueOf(s.substring(0,1))<10)
			dp[0] = 1;
		if(s.length() == 1) return dp[0];
		
		//dp[1]
		if(Integer.valueOf(s.substring(1,2))>0 && Integer.valueOf(s.substring(1,2))<10)
			dp[1] += dp[0];
		if(Integer.valueOf(s.substring(0,2))>=10 && Integer.valueOf(s.substring(0,2))<=26)
			dp[1] += 1;
		
		for(int i=2; i<s.length(); i++){
			int cur_val = Integer.valueOf(s.substring(i,i+1));
			if(cur_val>0 && cur_val<10)
				dp[i] += dp[i-1];
			int pre_val = Integer.valueOf(s.substring(i-1,i+1));
			if(pre_val>=10 && pre_val<= 26)
				dp[i] += dp[i-2];
		}
		return dp[s.length()-1];
    }
	
	public static void main(String[] args) {
		String s = "10";
		int rs = numDecodings(s);
		System.out.println(rs);
		
		int rs1 = numDecodings_1(s);
		System.out.println(rs1);
	}

}
