/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-28 14:49
Description : 
Source      : https://leetcode.com/problems/reverse-integer/
*******************************************/
#include <bool.h>
//AC - 4ms;
int reverse(int n)
{
    if(n==INT_MIN || n==INT_MAX) return 0; //two extreme values are ignored;
    bool negative = n<0? true : false;
    n = negative? -n : n;
    long long a = 0;
    while(n) //reverse n;
    {
        a = 10*a + n%10;
        n /= 10;
    }
    if(a > INT_MAX) return 0; //in case of reversed big number;
    return negative? -a : a;
}
