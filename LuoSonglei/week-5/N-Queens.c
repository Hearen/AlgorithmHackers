/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-02 10:06
Description : 
Source      : https://leetcode.com/problems/n-queens/
*******************************************/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
void find(int row, int n, int* rows, bool* cols, bool* fslash, bool* bslash, char*** boards, int* count)
{
    printf("Inside find, row: %d\tn: %d\n", row, n); 
    if(row == n)
    {
        boards[*count] = (char**)malloc(sizeof(char*)*n);
        for(int i = 0; i < n; i++)
        {
            boards[*count][i] = (char*)malloc(sizeof(char)*n);
            for(int j = 0; j < n; j++)
                boards[*count][i][j] = '.';
            boards[*count][i][n] = '\0';
        }
        for(int i = 0; i < n; i++)
        {
            boards[*count][i][rows[i]] = 'Q';
        }
        (*count)++;
        return;
    }
    for(int i = 0; i < n; i++)
    {
        if(cols[i] && fslash[row+i] && bslash[row+n-1-i])
        {
            cols[i] = fslash[row+i] = bslash[row+n-1-i] = false;
            rows[row] = i;
            find(row+1, n, rows, cols, fslash, bslash, boards, count);
            cols[i] = fslash[row+i] = bslash[row+n-1-i] = true;
        }
    }
}

//AC - 4ms;
char*** solveNQueens(int n, int* returnSize)
{
    char*** boards = (char***)malloc(sizeof(char**)*100000);
    bool* cols = (bool*)malloc(sizeof(bool)*n);
    for(int i = 0; i < n; i++)
        cols[i] = true;
    bool* fslash = (bool*)malloc(sizeof(bool)*(2*n));
    bool* bslash = (bool*)malloc(sizeof(bool)*(2*n));
    for(int i = 0; i < 2*n; i++)
    {
        fslash[i] = true;
        bslash[i] = true;
    }
    int* rows = (int*)malloc(sizeof(int)*n);
    find(0, n, rows, cols, fslash, bslash, boards, returnSize);
    return boards;
}

int main(int argc, char *argv[])
{
    int size = 0;
    int n = 5;
    char*** boards = solveNQueens(n, &size);
    printf("size: %d\n", size);
    for(int i = 0; i < size; i++)
    {
        printf("board No. %d\n", i);
        for(int row = 0; row < n; row++)
        {
            printf("%s\t", boards[i][row]);
            printf("\n");
        }
        printf("\n\n\n");
    }
    return 0;
}
