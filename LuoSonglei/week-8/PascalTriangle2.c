/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 11:09
Description : 
Source      : https://leetcode.com/problems/pascals-triangle-ii/
*******************************************/
#include <stdlib.h>
//AC - 0ms;
int* getRow(int rSize, int* returnSize)
{
    rSize++;
    if(rSize == 0)
        return NULL;
    *returnSize = rSize;
    int *colSizes = (int*)malloc(sizeof(int)*rSize);
    int** arrs = (int**)malloc(sizeof(int*)*rSize);
    for(int i = 0; i < rSize; i++)
    {
        colSizes[i] = i+1;
        arrs[i] = (int*)malloc(sizeof(int)*(i+1));
        for(int j = 0; j < i+1; j++)
            arrs[i][j] = 1;
    }
    for(int i = 2; i < rSize; i++)
        for(int j = 1; j < colSizes[i]; j++)
            if(j < colSizes[i-1])
                arrs[i][j] = arrs[i-1][j-1]+arrs[i-1][j];
    return arrs[rSize-1];
}

//AC - 0ms;
int* getRow1(int index, int* returnSize)
{
    int size = index+1;
    *returnSize = size;
    int* arr0 = (int*)malloc(sizeof(int)*size);
    int* arr1 = (int*)malloc(sizeof(int)*size);
    int *t;
    for(int i = 0; i < size; i++)
        arr0[i] = arr1[i] = 1;
    for(int i = 2; i < size; i++)
    {
        for(int j = 1; j <= i; j++)
           if(j < i)
              arr0[j] = arr1[j] + arr1[j-1]; 
        t = arr0;
        arr0 = arr1;
        arr1 = t;
    }
    return arr1;
}
