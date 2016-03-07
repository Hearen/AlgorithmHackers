package week8;

public class UniquePaths62 {
	/**
	 * @param m
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月21日
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
	 */
	public int uniquePaths(int m, int n) {
		/*思路：机器人要么向下要么向右，总共有m-1次向下和n-1次向右，
		 * 即其在n-1次向右的过程中，可以任意选择某空，插入m-1次向下的过程。
		 * 所以总的次数是A(m-1,m+n-2)/(m-1)!
		 * 
		 */
		int up = n+m-2;
		int small = m>n?n:m;
		long result=1;
        for(int i = 1 ;i < small;i++){
        	result*=up--;
        	result/=i;
        }
        return (int)result;
    }
	/**
	 * @param m
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月22日
	 * 
	 */
	public int uniquePathsII(int[][] obstacleGrid) {
		/*思路：动态规划，pp[i][j]表示到该节点的路径数，如果是障碍，赋值0
		 * 那么pp[i][j]的路径必然经过pp[i-1][j]和pp[i][j-1],即两者路径的和，因为两者没有交叉的路径。
		 * 
		 * 
		 */
		int m = obstacleGrid.length;
		if (m<1) {
			return 1;
		}
		int n = obstacleGrid[0].length;
		int[][] pp = new int[m][n];
		boolean stuck = false;
		for (int i = 0; i < m; i++) {
			stuck = stuck || obstacleGrid[i][0]==1;
			pp[i][0] = stuck?0:1;
		}
		stuck = false;
		for (int i = 0; i < n; i++) {
			stuck = stuck || obstacleGrid[0][i]==1;
			pp[0][i] = stuck?0:1;
		}
		for(int i = 1; i < m; i++){
			for (int j = 1; j < n; j++) {
				if (1== obstacleGrid[i][j]) {
					pp[i][j] = 0;
				}else{
					pp[i][j] = pp[i-1][j]+pp[i][j-1];
				}
			}
		}
		
        return pp[m-1][n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths62 up = new UniquePaths62();
		int[][] test = {
		                {0,0,0,1,0},
		                {0,1,0,0,0},
		                {1,0,1,0,0},
		                {0,0,0,0,0}
		              };
		System.out.println(up.uniquePathsII(test));
	}

}
