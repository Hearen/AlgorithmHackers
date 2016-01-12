/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-12 08:21
Description : 
Source      : https://leetcode.com/problems/power-of-three/
*******************************************/
#include <stdlib.h>
#include <stdbool.h>
//AC - 136ms;
bool isPowerOfThree0(int n)
{
    long a = 1;
    while(a <= n)
    {
        if(a==n)
            return true;
        a *= 3;
    }
    return false;
}

//AC - 132ms;
//This process can be faster using hashmap or binary search;
bool isPowerOfThree1(int n)
{
    return (n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 || n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 || n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 || n == 387420489 || n == 1162261467);
}

//AC - 132ms;
bool isPowerOfThree2(int n)
{
    return n>0?!(1162261467 % n):0;
}
