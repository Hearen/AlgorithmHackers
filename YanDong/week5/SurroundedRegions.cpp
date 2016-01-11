#include<vector>
#include<iostream>
#include<queue>
#include<stack>
using namespace std;
class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int boardRowSize = board.size();
        int boardColSize;

        if(boardRowSize == 0){
            boardColSize = 0;
        }else{
            boardColSize = board[0].size();
        }
          int i = 0,j = 0;
          for(i = 0;i<boardRowSize;++i){
                if(board[i][0] == 'O'){
                    dfs1(board,i,0,boardRowSize,boardColSize);
                }
                if(board[i][boardColSize-1] == 'O'){
                    dfs1(board,i,boardColSize-1,boardRowSize,boardColSize);
                }
            }
            for(i = 0;i<boardColSize;++i){
                if(board[0][i] == 'O'){
                    dfs1(board,0,i,boardRowSize,boardColSize);
                }
                if(board[boardRowSize-1][i] == 'O'){
                    dfs1(board,boardRowSize-1,i,boardRowSize,boardColSize);
                }
            }
            for(i = 0;i<boardRowSize;++i){
                for(j = 0;j<boardColSize;++j){
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }else if(board[i][j]=='1'){
                        board[i][j] = 'O';
                    }
                }
            }
    }
    struct Point{
        int x;
        int y;
        Point(int x,int y):x(x),y(y){}
    };
    void bfs(vector<vector<char>>& board,int x,int y,int boardRowSize,int boardColSize){
        queue<Point> q;
        q.push(Point(x,y));
        while(!q.empty()){
            Point p = q.front();
            q.pop();
            if(p.x < 0 || p.x >= boardRowSize || p.y<0 || p.y >=boardColSize)
                continue;
            if(board[p.x][p.y] == 'O'){
                board[p.x][p.y] = '1';
                q.push(Point(p.x-1,p.y));
                q.push(Point(p.x+1,p.y));
                q.push(Point(p.x,p.y-1));
                q.push(Point(p.x,p.y+1));
            }
        }
    }
    /*非递归的dfs也成功*/
    void dfs1(vector<vector<char>>& board,int x,int y,int boardRowSize,int boardColSize){
        stack<Point> s;
        s.push(Point(x,y));
        while(!s.empty()){
            Point p = s.top();
            s.pop();
             if(p.x < 0 || p.x >= boardRowSize || p.y<0 || p.y >=boardColSize)
                continue;
             if(board[p.x][p.y] == 'O'){
                board[p.x][p.y] = '1';
                s.push(Point(p.x-1,p.y));
                s.push(Point(p.x+1,p.y));
                s.push(Point(p.x,p.y-1));
                s.push(Point(p.x,p.y+1));
            }

        }
    }
    /*dfs 会出现 Runtime Error 猜测可能是超过最大递归层数的限制*/
    void dfs(vector<vector<char>>& board,int x,int y,int boardRowSize,int boardColSize){
        if(x < 0 || x >= boardRowSize || y<0 || y >=boardColSize)
            return;
        if(board[x][y] == 'O'){
            board[x][y] = '1';
            dfs(board,x-1,y,boardRowSize,boardColSize);
            dfs(board,x+1,y,boardRowSize,boardColSize);
            dfs(board,x,y-1,boardRowSize,boardColSize);
            dfs(board,x,y+1,boardRowSize,boardColSize);
        }
    }
};
int main(){
    Solution sol;
    vector<vector<char>> v;
    sol.solve(v);
    return 0;
}
