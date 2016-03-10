/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-10 14:01
Description : Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Source      : https://leetcode.com/problems/basic-calculator-ii/
*******************************************/
#include <cstdbool.h>
int calculate(char* s)
{
    bool d = false;
    int ret=0, sign=1, num=0, pre=0;
    for(int i = 0; s[i]; i++)
    {
        if(isdigit(s[i]))
            num = 10*num+s[i]-'0';
        else if(s[i]=='+' || s[i]=='-' || s[i]=='*' || s[i]=='/')
        {
            if(d)
            {
                num = pre/num;
                d = !d;
            }
            if(s[i] == '/')
            {
                d = true;
                pre = num*sign;
                sign = 1;
            }
            else if(s[i] == '*')
                sign *= num;
            else
            {
                ret += sign*num;
                sign = (c=='+')? 1 : -1;
            }
            num = 0;
        }
    }
    if(num > 0)
    {
        if(d)
            num = pre/num;
        ret += sign*num;
    }
    return ret;
}
