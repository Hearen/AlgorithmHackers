/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-21 08:37
Description : 
Source      : https://leetcode.com/problems/reverse-bits/
*******************************************/
#include <stdint.h>
//AC - 4ms;
uint32_t reverseBits(uint32_t n)
{
    if(n == 0)
        return 0;
    int i = n;
    int count = 0;
    while(n%2==0)
        count++, n /= 2;
    i = 0;
    while(n)
    {
        i = (i<<1) + n%2;
        n /= 2;
    }
    while(!((1<<(31-count))&i))
            i <<= 1;
    return i;
}
