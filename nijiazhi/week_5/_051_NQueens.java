package leetcode_njz;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.IRObject;


public class _051_NQueens {

    public static List<List<String>> solveNQueens(int n) {
        if(n <= 0)
        	return null;
        
        List<List<String>> rs = new ArrayList<List<String>>();
        int data[][] = new int[n][n];
        
        //column --- for
      	for(int i=0; i<n; i++){
      		data[0][i] = 1;
      		dfs(0, i, n, data, rs);
      		data[0][i] = 0;
      	}
      	
      	return rs;
    }
	
	private static void dfs(int x, int y, int n, int[][] data, List<List<String>> rs) {
		if(x==n-1 && Check(data, x, y, n)){
			writeRS(data, rs);
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

	private static void writeRS(int[][] data, List<List<String>> rs) {
		List<String> tmp = new ArrayList<>();
		for(int i=0; i<data.length; i++){
			String tmp_str = "";
			for(int j=0; j<data[i].length; j++){
				if(data[i][j] == 1)
					tmp_str += "Q";
				else
					tmp_str += ".";
			}
			tmp.add(tmp_str);
		}
		rs.add(tmp);
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
		List<List<String>> rs = solveNQueens(i);
		System.out.println(rs.size());
	}

}
