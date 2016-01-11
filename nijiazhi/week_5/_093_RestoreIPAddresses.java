package leetcode_njz;

import java.util.ArrayList;
import java.util.List;


public class _093_RestoreIPAddresses {
	
	//dfs回溯法---有好多情况可以提前剪纸，这里没有考虑
	public static List<String> restoreIpAddresses(String s) {
		if(s.length()>12 || s.length()==0)
			return new ArrayList<String>();
		List<String> rs = new ArrayList<String>();
        dfs(s, "", rs);
        return rs;
    }
	
	private static void dfs(String left_s , String ip, List<String> rs) {
		String[] ip_list = ip.split("\\."); 
		if(ip_list.length == 4 && !left_s.equals(""))
			return;
		
		if(left_s.equals(""))
			return;
		
		if(ip_list.length == 3 && Long.valueOf(left_s) <= 255){
			if(left_s.length() > 1 && left_s.charAt(0) == '0')
				return;
			
			rs.add(ip+left_s);
			return;
		}
		
		if(left_s.length() > 0)
			dfs(left_s.substring(1), ip+left_s.substring(0,1)+".", rs);
		
		if(left_s.length() > 1 && left_s.charAt(0) != '0')
			dfs(left_s.substring(2), ip+left_s.substring(0,2)+".", rs);
		
		if(left_s.length() > 2 && left_s.charAt(0) != '0')
			if( Long.valueOf(left_s.substring(0,3)) <= 255 )
				dfs(left_s.substring(3), ip+left_s.substring(0,3)+".", rs);
			
		return;
	}

	public static void main(String[] args) {
		String s = "010010";
		List<String> rs = restoreIpAddresses(s);
		
		for(String tmp : rs)
			System.out.println(tmp);
	}

}
