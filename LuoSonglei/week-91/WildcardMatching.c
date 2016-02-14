/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-14 15:11
Description : 
Source      : https://leetcode.com/problems/wildcard-matching/
*******************************************/
#include <stdbool.h>
#include <stdlib.h>
//AC - 12ms;
//can be optimized to 8ms by simplify the variable names;
bool isMatch(char* s, char* p)
{
    const char *pAsterisk = NULL, *sAsterisk = NULL;
    while(*s)
    {
        if(*p=='?' || *s==*p){p++, s++; continue;}
        if(*p=='*'){pAsterisk=p++, sAsterisk=s; continue;}
        if(pAsterisk){p=pAsterisk+1, s=++sAsterisk; continue;}
        return false;
    }
    while(*p=='*') p++;
    return !*p;
}
