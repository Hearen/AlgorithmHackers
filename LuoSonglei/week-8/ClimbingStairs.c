/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 15:33
Description : 
Source      : https://leetcode.com/problems/climbing-stairs/
*******************************************/
//Time Limit Exceeded;
int climbStairs0(int n)
{
    if(n <= 1)
        return 1;
    else
        return climbStairs(n-1) + climbStairs(n-2);
}

//AC - 0ms;
int climbStairs(int n)
{
    int *arr = (int*)malloc(sizeof(int)*(n+1));
    arr[0] = arr[1] = 1;
    for(int i = 2; i <= n; i++)
        arr[i] = arr[i-1] + arr[i-2];
    return arr[n];
}
