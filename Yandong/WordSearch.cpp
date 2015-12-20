#include<iostream>
#include<string>
#include<vector>
#include<cstring>

using namespace std;

class Solution {
public:
    bool visited[1000][1000];
    /********************************
    Input:
        board:字母表
        word:查找单词
        cur:当前将要匹配的单词
        visited:访问标记
        i、j:当前位置坐标
    Return:
        是否查找成功
    ********************************/
    bool dfs(vector<vector<char>>& board,string &word,int cur,bool visited[1000][1000],int i,int j){
        if(cur == word.size()){
            return true;
        }
        int rows = board.size();
        int cols = board[0].size();
        int direction[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int idx=0;idx<4;idx++){
            int row = i + direction[idx][0];
            int col = j + direction[idx][1];
            if(row>=0 && row < rows && col >=0 && col < cols && !visited[row][col] && board[row][col] == word[cur]){
                visited[row][col] = true;
                if(dfs(board,word,cur+1,visited,row,col))
                    return true;
                visited[row][col] = false;
            }
        }
        return false;

    }
    bool exist(vector<vector<char>>& board, string word) {

        if(word.size()<=0)
            return true;
        memset(visited,false,sizeof(visited));
        for(int i = 0;i < board.size();i++){
            for(int j=0;j< board[i].size();j++){
                if(board[i][j] == word[0]){
                    visited[i][j] = true;
                    if(dfs(board,word,1,visited,i,j)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    bool test(){
        vector<vector<char> >board(3,vector<char>());
        board[0] = {'A','B','C','E'};
        board[1] = {'S','F','C','S'};
        board[2] = {'A','D','E','E'};
        //cout<<board[0][0]<<endl;
        string word1 = "ABCCED";
        string word2 = "SEE";
        string word3 = "ABCB";
        return exist(board,word3);
    }
};
int main(){
    Solution sol;
    cout<<sol.test()<<endl;
    return 0;
}
