public class Solution {
    boolean[][] hang = null;
    boolean[][] lie = null;
    boolean[][] fang = null;
    public void solveSudoku(char[][] board) {
        int len = board.length;
        hang = new boolean[len][len];
        lie = new boolean[len][len];
        fang = new boolean[len][len];
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                if(board[i][j]!='.'){
                    hang[i][board[i][j]-'1'] = true;
                    lie[j][board[i][j]-'1'] = true;
                    fang[i/3*3+j/3][board[i][j]-'1'] = true;
                }
        solve(0,0,board);
    }
    //从x,y开始向右下角遍历，查找'.'
    private boolean solve(int x,int y,char[][] board){
        for(;x<board.length;x++){
            for(y=0;y<board.length;y++)
                if(board[x][y]=='.')
                    break;
            if(y<board.length) break;
        }
        if(x>=board.length) return true;
        
        for(int i=0;i<9;i++)
            if(!hang[x][i]&&!lie[y][i]&&!fang[x/3*3+y/3][i]){
                hang[x][i]=lie[y][i]=fang[x/3*3+y/3][i] = true;
                board[x][y] = (char)(i+'1');
                if(solve(x,y,board)) return true;
                hang[x][i]=lie[y][i]=fang[x/3*3+y/3][i] = false;
            }
        board[x][y] = '.';
        return false;
    }
}
