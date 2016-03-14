/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-14 15:38
Description : 
Source      : https://leetcode.com/problems/ugly-number/
*******************************************/
#include <stdbool.h>
//AC - 4ms;
bool isUgly(int n)
{
    if(n == 1)
        return true;
    if(n <= 0)
        return false;
    int next = n;
    while(n > 0)
    {
        if(n % 2 == 0)
            next = n/2;
        else if(n % 3 == 0)
            next = n/3;
        else if(n % 5 == 0)
            next = n/5;
        if(next == 1)
            return true;
        if(n == next)
            return false;
        n = next;
    }
}
