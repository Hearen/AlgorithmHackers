class Solution {
public:
 bool validPartial(vector<vector<char>>& board,int i,int j,char val){
        for(int col = 0 ;col < board[0].size();++col){
            if(col == j)
                continue;
            if(board[i][col] == val)
                return false;
        }
        for(int row = 0;row < board.size();row++){
            if(row == i)
                continue;
            if(board[row][j] == val)
                return false;
        }
        for(int ii = 0;ii < 9;ii++){
            for(int jj = 0 ;jj < 9; jj++){
                if(ii == i && jj==j)
                    continue;
                if(ii/3 == i/3 && jj/3 == j/3 && board[ii][jj] == val)
                    return false;
            }
        }
        return true;

    }
    bool dfs(vector<vector<char>>& board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    for(int k = 1; k <= 9;k++){
                        board[i][j] = '0' + k;
                        if(validPartial(board,i,j,'0'+k)){
                            if(dfs(board)){
                                return true;
                            }
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }

            }
        }
        //全部完成赋值
        return true;
    }
    void solveSudoku(vector<vector<char>>& board) {
       dfs(board);
    }
};