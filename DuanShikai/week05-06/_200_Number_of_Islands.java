package com.sky.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2016年1月6日 下午1:16:40
 * @content 
 */

public class _200_Number_of_Islands {
	public int numIslands(char[][] grid) {
		if(grid==null || grid.length==0 || grid[0].length==0) return 0;
		int m=grid.length, n=grid[0].length, result=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]=='1'){
					result++;
					flip(grid,new int[]{i,j});
				}
			}
		}
		return result;
    }

	private void flip(char[][] grid, int[] pos) {
		Queue<int[]> queue=new LinkedList<>();
		queue.add(pos); grid[pos[0]][pos[1]]='0';
		while(!queue.isEmpty()){
			int[] curr=queue.poll();
			int x=curr[0], y=curr[1];
			
			int[][] surrounded = new int[4][2];
			surrounded[0][0]=x+1;surrounded[0][1]=y;
			surrounded[1][0]=x-1;surrounded[1][1]=y;
			surrounded[2][0]=x;surrounded[2][1]=y+1;
			surrounded[3][0]=x;surrounded[3][1]=y-1;
			
			for(int i=0;i<surrounded.length;i++){
				int m=surrounded[i][0], n=surrounded[i][1];
				if(m>=0 && m<grid.length &&
						n>=0 && n<grid[0].length &&
						grid[m][n]=='1'){
					grid[m][n]='0';
					queue.add(new int[]{m,n});
				}
			}
		}
	}
}
