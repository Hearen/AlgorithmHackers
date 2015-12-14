/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-02 21:28
Description: 
Source: https://leetcode.com/problems/word-search/
*******************************************/
#include"utils.h"
//using recursive function to achieve backtracking;
//the termination conditions should be carefully handled;
bool isFound(char** board, int row, int col, char*word, int rIndex, int cIndex)
{
    if(rIndex >= row || cIndex >= col || rIndex < 0 || cIndex < 0 || *word != board[rIndex][cIndex])
        return false;
    if(*(word+1) == '\0')
        return true;
    char t = board[rIndex][cIndex];
    //avoid re-visiting;
    board[rIndex][cIndex] = '\0';
    if(isFound(board, row, col, word + 1, rIndex + 1, cIndex) || isFound(board, row, col, word + 1, rIndex - 1, cIndex) ||
            isFound(board, row, col, word + 1, rIndex, cIndex + 1) || isFound(board, row, col, word + 1, rIndex, cIndex - 1))
        return true;
    board[rIndex][cIndex] = t;
    return false;
}

bool exist(char** board, char row, int col, char* word)
{
    //start the searching from every point;
    for(int i = 0; i < row; i++)
        for(int j = 0; j < col; j++)
        {
            if(isFound(board, row, col, word, i, j))
                return true;
        }
    return false;
}
