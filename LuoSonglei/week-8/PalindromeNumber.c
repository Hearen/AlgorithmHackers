/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 11:32
Description : 
Source      : https://leetcode.com/problems/palindrome-number/
*******************************************/
#include <stdbool.h>
//AC - 56ms;
bool isPalindrome(int n)
{
    if(n < 0)
        return false;
    if(n < 2)
        return true;
    if(n%10 == 0)
        return false;
    int t = 0;
    while(t < n)
    {
        t = t*10+n%10;
        n /= 10;
    }
    if(n == t)
        return true;
    else
        return t/10 == n;
}
