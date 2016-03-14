/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-23 10:51
Description : 
Source      : https://leetcode.com/problems/unique-binary-search-trees/
*******************************************/
//AC - 0ms;
int numTrees(int n)
{
    int *arr = (int*)malloc(sizeof(int)*(n+1));
    for(int i = 0; i < n; i++)
        arr[i] = 0;
    arr[0] = 1;
    arr[1] = 1;
    for(int i = 2; i <= n; i++)
        for(int j = 0; j <= i-1; j++)
            arr[i] += arr[j] * arr[i-j-1];
    return arr[n];
}
