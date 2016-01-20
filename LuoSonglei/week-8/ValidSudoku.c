/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 14:47
Description : 
Source      : https://leetcode.com/problems/valid-sudoku/
*******************************************/
#include <stdbool.h>
//AC - 4ms;
bool isValidSudoku(char** board, int rSize, int cSize)
{
    int a[10];
    for(int i = 0; i < rSize; i++)
    {
        for(int i = 0; i < 10; i++)
            a[i] = 0;
        for(int j = 0; j < cSize; j++)
        {
            if(board[i][j] != '.')
                if(a[board[i][j]-'0']++)
                    return false;
        }
    }
    for(int i = 0; i < cSize; i++)
    {
        for(int i = 0; i < 10; i++)
            a[i] = 0;
        for(int j = 0; j < rSize; j++)
        {
            if(board[j][i] != '.')
                if(a[board[j][i]-'0']++)
                    return false;
        }
    }
    for(int row = 0; row < 9; row += 3)
        for(int col = 0; col < 9; col +=3)
        {
            for(int i = 0; i < 10; i++)
                a[i] = 0;
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++)
                {
                    if(board[row+i][col+j] != '.')
                        if(a[board[row+i][col+j]-'0']++)
                            return false;
                } 
        }
    return true;
}
