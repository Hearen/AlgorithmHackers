package leetcode_njz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class _140_WordBreakII {

    public static List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> rs = new ArrayList<String>();
        if(wordDict.contains(s)) rs.add(s+" ");
        
		/*
		 * 问题在于map，其中不应该存放boolean型，不然直接根据判断就跳出了
		 * map应该存放当前字符串所能构成的所有答案 --- （不含有初始串）
		 */
		HashMap<String, List<String>> map = new HashMap<>();
        dfs(s, wordDict, map);
        return map.get(s);
    }
	
    
	private static List<String> dfs(String s2, Set<String> wordDict, HashMap<String, List<String>> map) {
		if(map.containsKey(s2)) return map.get(s2);
		
		List<String> rs = new ArrayList<String>();
		if(s2.equals("")) return rs;
		
		for(int i=1; i<=s2.length(); i++){
			String pre = s2.substring(0,i);
			String append = s2.substring(i);
			
			boolean f1 = wordDict.contains(pre);
			if(!f1) continue;
			
			List<String> tmp;
			if(map.containsKey(append)){
				tmp = map.get(append);
			}else{
				tmp = dfs(append, wordDict, map);
			}
			
			//注意条件 --- append.isEmpty()
			if(tmp.size() == 0 && append.isEmpty())
				rs.add(pre);
			for(int k=0; k<tmp.size(); k++){
				String s = tmp.get(k);
				rs.add(pre+" "+s);
			}
			
		}
		map.put(s2, rs);
		return map.get(s2);
	}

	/*
	 * 在for循环内部不需要考虑map的contains问题
	 */
   public static List<String> wordBreak2(String s, Set<String> wordDict) {
		List<String> rs = new ArrayList<String>();
        if(wordDict.contains(s)) rs.add(s+" ");
		HashMap<String, List<String>> map = new HashMap<>();
        dfs2(s, wordDict, map);
        return map.get(s);
    }
	
    
	private static List<String> dfs2(String s2, Set<String> wordDict, HashMap<String, List<String>> map) {
		if(map.containsKey(s2)) return map.get(s2);
		
		List<String> rs = new ArrayList<String>();
		if(s2.equals("")) 
			return rs;
		
		for(int i=1; i<=s2.length(); i++){
			String pre = s2.substring(0,i);
			String append = s2.substring(i);
			
			boolean f1 = wordDict.contains(pre);
			if(!f1) continue;
			
			List<String> tmp = dfs2(append, wordDict, map);
			
			if(tmp.size()==0 && append.equals("")){
				rs.add(pre);
			}
			
			for(int k=0; k<tmp.size(); k++){
				String s = tmp.get(k);
				rs.add(pre+" "+s);
			}				
		}
		map.put(s2, rs);
		return rs;
	}
	
	public static void main(String[] args) {
//		String s = "catsanddog";
//		String[] dict = {"cat", "cats", "and", "sand", "dog"};
		
//		String s = "abcd";
//		String[] dict = {"a","abc","b","cd"};
		
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] dict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		
		Set<String> wordDict = new HashSet<>();
		for(int i=0; i<dict.length; i++)
			wordDict.add(dict[i]);
		
//		List<String> rs2 = wordBreak2(s,wordDict);
//		System.out.println(rs2);
		
		List<String> rs = wordBreak(s,wordDict);
		System.out.println(rs);
	}

}
