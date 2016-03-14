# 62. Unique Paths

## Problem

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

tag:
- array
- dp

## Solution 

组合问题：
向右需要n-1步，向下需要m-1步骤, 总的走法C(m-1, m-1+n-1)

**深搜**

```java
    public int uniquePaths(int m, int n) {
        if(m==1||n==1) return 1;
        return uniquePaths(m-1,n)+uniquePaths(m, n-1);
    }
```
Unfortunately LTE :(

**dp**

m[i,j] = m[i-1,j]+m[i,j-1]

```java
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++)
			res[i][0] = 1;
		for (int j = 0; j < n; j++)
			res[0][j] = 1;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				res[i][j] = res[i - 1][j] + res[i][j - 1];
		return res[m - 1][n - 1];
	}
```

## Unique Paths II

在 unique path的基础上设置障碍节点。采用dp：  
非障碍节点：m[i,j] = m[i-1,j]+m[i,j-1]  
障碍节点：m[i,j]=0  
注意初始化的一些细节

```java
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] res = new int[m][n];
		res[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
		for (int i = 1; i < m; i++) {
			res[i][0] = (obstacleGrid[i][0] == 1) ? 0 : res[i - 1][0];
		}
		for (int j = 1; j < n; j++) {
			res[0][j] = (obstacleGrid[0][j] == 1) ? 0 : res[0][j - 1];
		}
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					res[i][j] = 0;
				else
					res[i][j] = res[i - 1][j] + res[i][j - 1];
				res[i][j] = (obstacleGrid[i][j] == 1) ? 0 : (res[i - 1][j] + res[i][j - 1]);
			}
		return res[m - 1][n - 1];
	}
```