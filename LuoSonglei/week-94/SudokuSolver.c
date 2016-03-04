/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-04 09:20
Description : 
Source      : https://leetcode.com/problems/sudoku-solver/?sort=votes
*******************************************/
#include <bool.h>
bool check(char** board, int r, int c, char a) //check it in row, column and the sub three-dimension cube;
{
    for(int i = 0; i < 9; i++) if(board[r][i]==a || board[i][c]==a) return false;
    int r0=r-r%3, c0=c-c%3; //get the start row and column of the sub cube;
    for(int i = 0; i < 3; i++)
        for(int j = 0; j < 3; j++)
            if(board[r0+i][c0+j] == a) return false;
    return true;
}
bool solver(char** board, int r, int c) //check and try it from left to right and then downwards;
{
    if(r == 9) return true; //now till the end and nothing wrong so far, so return true;
    if(c == 9) return solver(board, r+1, 0); //till the end of the current row and then downwards;
    if(board[r][c] != '.') return solver(board, r, c+1); //already taken just move to the next;
    for(char a = '1'; a <= '9'; a++) //try each possible candidate;
    {
        if(check(board, r, c, a)) //check its validity;
        {
            board[r][c] = a; //set it then and just move to the next;
            if(solver(board, r, c+1)) return true; //if it's solvable then just return true;
            board[r][c] = '.'; //restore it for easier checking in the next round;
        }
    }
    return false; //nothing works around then return false;
}
void solveSudoku(char** board, int rSize, int cSize)
{
    solver(board, 0, 0); //start from the top-left position to the bottom right end;
}
