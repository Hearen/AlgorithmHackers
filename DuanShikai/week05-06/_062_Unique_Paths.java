package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月28日 下午2:39:28
 * @content 
 */

public class _062_Unique_Paths {
	
	public static void main(String args[]){
		System.out.println(uniquePaths(2,2));
	}
	
	 public static int uniquePaths(int m, int n) {
		 if(m==0 || n==0) return 0;
		 int[][] d=new int[m][n];
		 for(int i=0;i<m;i++) d[i][0]=1;
		 for(int j=0;j<n;j++) d[0][j]=1;
		 d[0][0]=0;
		 for(int i=1;i<m;i++){
			 for(int j=1;j<n;j++){
				 d[i][j]=d[i-1][j]+d[i][j-1];
			 }
		 }
		 return m==1 && n==1 ? 1 : d[m-1][n-1];
	 }
}
