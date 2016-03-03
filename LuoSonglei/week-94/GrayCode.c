/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-03 19:53
Description : 
Source      : https://leetcode.com/problems/gray-code/
*******************************************/
//AC - 0ms;
int grayCode(int n, int* returnSize)
{
    *returnSize = 0;
    int *arr = (int*)malloc(sizeof(int));
    n = 1<<n;
    for(int i = 0; i < n; i++)
    {
        *returnSize += 1;
        arr = (int*)realloc(arr, sizeof(int)*(*returnSize));
        arr[*returnSize-1] = ((i<<1)^i)>>1;
    }
    return arr;
}
