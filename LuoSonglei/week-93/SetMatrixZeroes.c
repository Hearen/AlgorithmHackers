/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-26 10:17
Description : 
Source      : https://leetcode.com/problems/set-matrix-zeroes/
*******************************************/
#include <bool.h>
//AC - 44ms;
void setZeroes0(int** matrix, int rSize, int cSize)
{
    bool *rSet = (bool*)malloc(sizeof(bool)*rSize);
    bool *cSet = (bool*)malloc(sizeof(bool)*cSize);
    memset(rSet, 0, sizeof(bool)*rSize);
    memset(cSet, 0, sizeof(bool)*cSize);
    for(int r = 0; r < rSize; r++)
        for(int c = 0; c < cSize; c++)
            if(!matrix[r][c])
            {
                rSet[r] = true;
                cSet[c] = true;
            }
    for(int r = 0; r < rSize; r++)
        if(rSet[r])
            memset(matrix[r], 0, sizeof(int)*cSize);
    for(int c = 0; c < cSize; c++)
        if(cSet[c])
            for(int r = 0; r < rSize; r++)
                matrix[r][c] = 0;
}

//AC - 44ms;
void setZeroes(int** matrix, int rSize, int cSize)
{
    int col0 = 1; //the first column can be affected by the other columes of the first row;
    for(int r = 0; r < rSize; r++)
    {
        if(matrix[r][0]==0) col0 = 0;
        for(int c = 1;  c < cSize; c++)
            if(matrix[r][c]==0)
                matrix[r][0] = matrix[0][c] = 0;
    }
    for(int r = rSize-1; r > -1; r--) //using reverse direction to ensure previously set value will not affect the latter ones;
    {
        for(int c = cSize-1; c > 0; c--)
            if(matrix[r][0]==0 || matrix[0][c]==0)
                matrix[r][c] = 0;
        if(col0==0) matrix[r][0] = 0; //ensure the first column will not affect the other columns in the same row;
    }
}
