#include<stdio.h>
#include"utils.h"
/*
 *Author: LHearen 
 *E-mail: LHearen@126.com 
 *Time: Tue Dec  1 08:26:45 CST 2015
 *Source: https://leetcode.com/problems/word-search/
 */

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
    for(int i = 0; i < row; i++)
        for(int j = 0; j < col; j++)
        {
            if(isFound(board, row, col, word, i, j))
                return true;
        }
    return false;
}
