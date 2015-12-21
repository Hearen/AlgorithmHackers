/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-21 08:56
Description : 
Source      : https://leetcode.com/problems/roman-to-integer/
*******************************************/
#include<string.h>
//Roman numeral
//any of the letters representing numbers in the Roman numerical system: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000. In this system a letter placed after another of greater value adds (thus XVI or xvi is 16), whereas a letter placed before another of greater value subtracts (thus XC is 90).

int romanToInt(char* s)
{
    int pre = 0, cur = 0;
    int sum = 0;
    for(int i = strlen(s)-1; i > -1; i--)
    {
        switch(*(s+i))
        {
            case 'i':
            case 'I': cur = 1; break;
            case 'v':
            case 'V': cur = 5; break;
            case 'x':
            case 'X': cur = 10; break;
            case 'l':
            case 'L': cur = 50; break;
            case 'c':
            case 'C': cur = 100; break;
            case 'd':
            case 'D': cur = 500; break;
            case 'm':
            case 'M': cur = 1000; break;
            default: break;
        } 
        if(cur >= pre)
        {
            sum += cur;
            pre = cur;
        }
        else
        {
            sum -= cur;
        }
    }
    return sum > 3999? 3999 : sum;
}
