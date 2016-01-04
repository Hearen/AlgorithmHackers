package leetcode_njz;

import java.util.ArrayList;
import java.util.List;

public class _052_NQueens2 {

	public static int totalNQueens(int n) {
		 if(n <= 0)
        	return 0;
        
        List<Integer> rs = new ArrayList<>();
        int data[][] = new int[n][n];
        
        //column --- for
      	for(int i=0; i<n; i++){
      		data[0][i] = 1;
      		dfs(0, i, n, data, rs);
      		data[0][i] = 0;
      	}
      	
      	return rs.size();
    }
	
	
	private static void dfs(int x, int y, int n, int[][] data, List<Integer> rs) {
		if(x==n-1 && Check(data, x, y, n)){
			rs.add(1);
			return;
		}else if (x == n-1)
			return;
		else if(!Check(data, x, y, n))
			return;
		
		//column --- for
		for(int i=0; i<n; i++){
			data[x+1][i] = 1;
			dfs(x+1, i, n, data, rs);
			data[x+1][i] = 0;
		}
		
	}

	private static boolean Check(int[][] data, int x, int y, int n) {
		//column---check
		for(int i=0; i<x; i++)
			if(data[i][y] == 1) return false;
		
		//row---check---貌似不需要
		for(int j=0; j<y; j++)
			if(data[x][j] == 1) return false;
		
		//diagonal---check
		int x1 = x-1;
		int y1 = y-1;
		while(x1>=0 && y1>=0)
			if(data[x1--][y1--] == 1) return false;
		
		int x2 = x-1;
		int y2 = y+1;
		while(x2>=0 && y2<n)
			if(data[x2--][y2++] == 1) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		int i = 4;
		int rs = totalNQueens(i);
		System.out.println(rs);
	}

}
