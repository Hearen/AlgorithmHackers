# 62. Unique Paths

## Problem

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
```
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
```

The total number of unique paths is 2.

tag:
- array
- dp

## Solution 

在 unique path的基础上增加了障碍节点。采用dp：  
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