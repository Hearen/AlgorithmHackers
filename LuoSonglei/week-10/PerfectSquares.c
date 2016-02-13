/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-12 16:49
Description : 
Source      : https://leetcode.com/problems/perfect-squares/
*******************************************/
#include <limits.h>
//AC - 144ms;
int numSquares(int n)
{
    int *mins = (int*)malloc(sizeof(int)*(n+1));
    mins[0] = 0;
    for(int i = 1; i <= n; i++)
    {
        int min = INT_MAX;
        int square = 1;
        for(int r=1; square <= i; r++)
        {
            int t = mins[i-square]+1;
            min = t < min? t : min;
            square = r*r;
        }
        mins[i] = min;
    }
    return mins[n];
}


