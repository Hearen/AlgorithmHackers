public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int[][] height = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(matrix[i][j]=='1'){
                    height[i][j]=1;
                    if(i>0&&height[i-1][j]>0)
                        height[i][j] = height[i-1][j]+1;
                }
        int ans = 0;
        for(int i=0;i<m;i++){
            int stack[] = new int[n+1];
            int top = -1;
            for(int j=0;j<=n;j++){
                int now = -1;
                if(j<n) now = height[i][j];
                if(top>=0&&now<=height[i][stack[top]]){
                    int index = stack[top];
                    while(top>=0&&now<=height[i][stack[top]]){
                        int width = index+1;
                        if(top>0) width = index-stack[top-1];
                        ans = Math.max(ans,height[i][stack[top]]*width);
                        --top;
                    }
                }
                stack[++top] = j;
            }
        }
        return ans;
    }
}
