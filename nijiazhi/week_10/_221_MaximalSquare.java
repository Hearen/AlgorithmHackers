package leetcode_njz;

public class _221_MaximalSquare {

	/*
	 * 暴力解 --- 穷举所有以matrix[i][j]为左上角的正方形
	 * You are here! Your runtime beats 0.41% of java submissions.
	 */
    public static int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int maxArea = 0;
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		int maxSideLen = Math.min(col-j, row-i);
        		for(int len=1; len<=maxSideLen; len++){
        			if(check(matrix,i,j,len) && maxArea<len*len)
        				maxArea = len*len;
        		}
        	}
        }
        
        return maxArea;
    }
	
	private static boolean check(char[][] matrix, int i, int j, int len) {
		for(int row=i; row<i+len; row++)
			for(int col=j; col<j+len; col++)
				if(matrix[row][col]=='0') return false;
		return true;
	}

	
	/*
	 * dp---当前元素为正方形的右下角所在的最大正方形边长
	 * 当前元素不为0 --- area=min(周围三个)+1
	 * 
	 * You are here!  Your runtime beats 25.36% of java submissions.
	 */
    public static int maximalSquare1(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int maxLen = 0;
        int dp[][] = new int[row][col];
        for(int i=0; i<row; i++)
        	dp[i][0] = matrix[i][0]-'0';
        for(int i=0; i<col; i++)
        	dp[0][i] = matrix[0][i]-'0';
        
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		if(matrix[i][j] == '0') continue;
        		
        		int diag = 0;
        		if(i-1>=0 && j-1>=0)
        			diag = dp[i-1][j-1];
        		
        		int left = 0;
        		if(j-1 >= 0)
        			left = dp[i][j-1];
        		
        		int up = 0;
        		if(i-1 >= 0)
        			up= dp[i-1][j];
        		
        		int min = getMin(diag,left,up);
        		dp[i][j] = min+1;
        		if(maxLen < dp[i][j])
        			maxLen = dp[i][j];
        	}
        }
        
        return maxLen*maxLen;
    }
	
	private static int getMin(int diag, int left, int up) {
		int min = Math.min(diag, left);
		min = Math.min(min, up);
		return min;
	}

	public static void main(String[] args) {
		char[][] matrix = {
				{'1','0' ,'1' ,'0' ,'0'},
				{'1' ,'0' ,'1' ,'1' ,'1'},
				{'1' ,'1' ,'1' ,'1' ,'1'},
				{'1' ,'0' ,'0' ,'1' ,'0'},
				};
		
		int rs = maximalSquare(matrix);
		System.out.println(rs);
		
		int rs1 = maximalSquare1(matrix);
		System.out.println(rs1);
	}

}
