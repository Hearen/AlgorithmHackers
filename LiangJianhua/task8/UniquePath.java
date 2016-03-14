package com.josh.task8;

import org.junit.Test;

public class UniquePath {
	@Test
	public void test(){
		System.out.println(uniquePaths(1, 2));
	}
	/*
	 * 在一个表格中寻找从左上到右下不同的路径一共有几条
	 * DP:
	 * 当前位置的路径总数=正前方位置路径总数+正上方位置路径总数
	 * 初始状态：dp[0][j]=0,dp[i][0]=0
	 * 递推公式：dp[i][j]=dp[i][j-1]+dp[i-1][j]
	 * 
	 */
	public int uniquePaths(int m,int n){
		 int[][] dp = new int[m][n];
	     //初始状态，第一行和第一例均为1
		 for(int i=0;i<m;i++){//行初始化
			 dp[i][0]=1;
		 }
		 for(int j=0;j<n;j++){//列初始化
			 dp[0][j]=1;
		 }
		 for(int i=1;i<m;i++){//动态规划求解
			 for(int j=1;j<n;j++){
				 dp[i][j]=dp[i][j-1]+dp[i-1][j];
			 }
		 }
		 return dp[m-1][n-1];
	}
	//解法同问题一
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0]==1 || obstacleGrid.length==0) return 0;//初始位置就有障碍物
	    for(int i=0;i<obstacleGrid.length;i++){//重新初始化。-1表示障碍物
	    	if(obstacleGrid[i][0]==1){//从当前位置开始后面都是0，不可达
	    		for(;i<obstacleGrid.length;i++){
	    			obstacleGrid[i][0]=0;
	    		}
	    	}else{
	    		obstacleGrid[i][0]=1;
	    	}
	    }
	    for(int j=1;j<obstacleGrid[0].length;j++){
	    	if(obstacleGrid[0][j]==1){
	    		for(;j<obstacleGrid[0].length;j++){
	    			obstacleGrid[0][j]=0;
	    		}
	    	}else{
	    		obstacleGrid[0][j]=1;
	    	}
	    }
	    for(int i=1;i<obstacleGrid.length;i++){//动态规划求解
			 for(int j=1;j<obstacleGrid[0].length;j++){
				 if(obstacleGrid[i][j]==1){
					 obstacleGrid[i][j]=0;
				 }else{
					 obstacleGrid[i][j]=obstacleGrid[i][j-1]+obstacleGrid[i-1][j];
				 }
			 }
		 }
		return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]; 
	}
//    public int uniquePaths1(int m, int n) {
//    	if(m*n==0) return 0;
//    	if(m==1 || n==1) return 1;
//    	int count = 0;//记录总路径数目
//        int[][] grid = new int[m][n];//初始化表格
//        int[][] visit = new int[m][n];//标记是否访问
//        for(int i=0;i<m;i++){
//        	for(int j=0;j<n;j++){
//        		grid[i][j] = 0;
//        		if(i==m-1 ||j==n-1) visit[i][j]=1;
//        		else visit[i][j]=2;
//        	}
//        }
//        
//        int x=0,y=0,preX=m-1,preY=n-1;
//        grid[0][0]=1;//开始位置
//        visit[0][0]=2;//visit[m-1][n-1]=0;
//        while((x<m || y<n)){
//        	if(y+1<n && grid[x][y+1]==0 && visit[x][y+1]>0){//向右走
//            	if(x==0 && y==0) visit[0][0]--;
//        		grid[x][y+1]=1;
//        		visit[x][y+1]--;
//        		y++;
//        	}else if(x+1<m && grid[x+1][y]==0 && visit[x+1][y]>0){//向下走
//        		if(x==0 && y==0) visit[0][0]--;
//        		grid[x+1][y]=1;
//        		visit[x+1][y]--;
//        		x++;
//        	}else{//上下都走不通有两种情况：1 真走不动了，回退上一步；2 到达终点了，也回退到上一步
//        		if(visit[0][0]==0) break;
//        		if(x==m-1 && y==n-1){//到达终点、回退上一级
//            		count++;
//            		visit[x][y]=1;
////            		if(count==2){
////            			System.err.println("ee");
////            		}//跳出循环
//            	}
//        		grid[preX][preY]=0;//前一位值可访问
//        		preX=x;preY=y;
//        		grid[preX][preY]=-1;//新前一位置重新置为-1
//        		if(y>=1 && grid[x][y-1]==1){//回退到上一个位置
//        			y=y-1;
//        		}else if(x>=1 && grid[x-1][y]==1){
//        			x=x-1;
//        		}else {
//					//break;
//				}
//        	}
//        }
//    	return count;
//    }
}
