package com.josh.task8;
import org.junit.Test;
/*
 * 从s中删减若干个字符串可以产生多少个和t相同的子串
 * 动态规划
 * 
 */
public class DistinctSubsequences {
	@Test
	public void test(){
		String s="aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
		String t="bddabdcae";
		//String s="abceabc",t="abc";
		System.out.println(numDistinct(s,t));
	}
	public int numDistinct(String S, String T) {//DP Internet 10582116
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        dp[0][0] = 1;//initial
        for(int j = 1; j <= T.length(); j++)//S is empty
            dp[0][j] = 0;
            
        for (int i = 1; i <= S.length(); i++)//T is empty
            dp[i][0] = 1;
           
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) 
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[S.length()][T.length()];
    }

	public int numDistinct1(String s, String t) {//深搜 超时。。。
		if(s.length() ==0){
			return t.length()==0?1:0;
		}
		if(t.length()==0){
			return 1;
		}
		int count =0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==t.charAt(0)){
				count += numDistinct1(s.substring(i+1), t.substring(1));
			}
		}
		return count;
    }
//	public int like(String s,String t,int s_begin,int t_begin ,List<Integer> count){
//		if(s==t || t.length()==0) return count.size()+1;
//		if(s.length()-s_begin < t.length()-t_begin) return count.size();
//		//声明一个数组记录t的每个字符在s中的位置
//		int[] A = new int[t.length()-t_begin];
//		int i=s_begin,j=t_begin,index = 0;
//		while(i<s.length() && j<t.length()){//找到s中第一个和t匹配的子串
//			if(s.charAt(i) == t.charAt(j)){
//				A[index] = i;
//				j++;
//				index++;
//			}
//			i++;
//			if(j==t.length()){
//				count.add(0);
//				break;
//			}
//		}
//		if(j==t.length()){
//			for(int k=A.length-1;k>=0;k--){//递归寻找其他匹配子串
//				like(s, t, A[k]+1, k, count);
//			}
//		}	
//		return count.size();
//	}
}
