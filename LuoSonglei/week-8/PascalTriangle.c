/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 10:33
Description : 
Source      : https://leetcode.com/problems/pascals-triangle/
*******************************************/
#include <stdlib.h>
//AC - 0ms;
int** generate(int rSize, int** colSizes, int* returnSize)
{
    if(rSize == 0)
        return NULL;
    *returnSize = rSize;
    *colSizes = (int*)malloc(sizeof(int)*rSize);
    int** arrs = (int**)malloc(sizeof(int*)*rSize);
    for(int i = 0; i < rSize; i++)
    {
        (*colSizes)[i] = i+1;
        arrs[i] = (int*)malloc(sizeof(int)*(i+1));
        for(int j = 0; j < i+1; j++)
            arrs[i][j] = 1;
    }
    for(int i = 2; i < rSize; i++)
        for(int j = 1; j < (*colSizes)[i]; j++)
            if(j < (*colSizes)[i-1])
                arrs[i][j] = arrs[i-1][j-1]+arrs[i-1][j];
    return arrs;
}
