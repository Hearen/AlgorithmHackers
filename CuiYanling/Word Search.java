public class Solution {
    int dir[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m==0) return false;
        int n = board[0].length;
        if(word.length()==0) return true;
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(board[i][j]==word.charAt(0)&&exist(board,i,j,word,1))
                    return true;
        return false;
    }
    private boolean exist(char[][] board,int x,int y,String word,int idx){
        if(idx==word.length()) return true;
        char c = board[x][y];
        board[x][y] = '\0';
        for(int d = 0;d<4;d++){
            int i=x+dir[d][0],j=y+dir[d][1];
            if(i<0||j<0||i>=board.length||j>=board[0].length)
                continue;
            if(board[i][j]==word.charAt(idx)&&exist(board,i,j,word,idx+1))
                return true;
        }
        board[x][y] = c;
        return false;
    }
}
