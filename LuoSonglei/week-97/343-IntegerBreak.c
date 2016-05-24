/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : Tue, 24 May 2016 20:21 CST
Description : Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
Note: you may assume that n is not less than 2.
Source      : https://leetcode.com/problems/integer-break/
*******************************************/
//AC - 0ms - DP;
#define MAX(a, b) ((a) > (b) ? (a) : (b))
int integerBreak0(int n) 
{
    int *arr = (int*)malloc(sizeof(int)*(n+1)); //used to store the max product of the index;
    arr[2]=1, arr[3]=2, arr[4]=4; //corner cases;
    for(int i = 5; i <= n; i++) 
    {
        int max = 0;
        for(int j = 2; j < i-1; j++)
        {
            int t = MAX(j, arr[j])*MAX(i-j, arr[i-j]); //select the value itself or the its product value;
            if(t > max) max = t;
        }
        arr[i] = max;
    }
    return arr[n];
}

//AC - 0ms - mathematical solution;
//only 2 or 3 will be used to make the product bigger;
//elements bigger than them can be splitted further to make bigger;
//meantime 3*3 > 2*2*2 so we should get as many 3 as possible;
int integerBreak(int n) 
{
    if(n == 2) return 1;
    if(n == 3) return 2;
    int ret = 1;
    while(n > 4)
    {
        ret *= 3;
        n -= 3;
    }
    return ret*n;
}
