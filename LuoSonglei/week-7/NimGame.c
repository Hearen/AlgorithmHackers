/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-12 08:38
Description : 
Source      : https://leetcode.com/problems/nim-game/
*******************************************/
#include <stdbool.h>

//Time Limit Exceeded;
bool canWinNim0(int n)
{
    int a = 4;
    while(a <= n)
    {
        if(a == n)
            return false;
        a += 4;
    }
    return true;
}

//AC - 0ms;
bool canWinNim1(int n)
{
    return n%4;
}
