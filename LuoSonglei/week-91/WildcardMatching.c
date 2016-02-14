/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-14 15:11
Description : 
Source      : https://leetcode.com/problems/wildcard-matching/
*******************************************/
#include <stdbool.h>
#include <stdlib.h>
//AC - 12ms; - not a DP solution
//can be optimized to 8ms by simplify the variable names;
bool isMatch0(char* s, char* p)
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


//AC - 28ms - DP solution;
bool isMatch1(char* s, char* p)
{
    int sLen=strlen(s), pLen=strlen(p);
    int count = 0;
    for(int i = 0; i < pLen; i++)
        if(p[i] == '*') count++;
    if((count==0 && pLen!=sLen) || (pLen-count>sLen)) return false;
    bool *match = (bool*)malloc(sizeof(bool)*(sLen+1));
    memset(match, 0, sizeof(bool)*(sLen+1));
    match[0] = true;
    for(int i = 0; i < pLen; i++)
    {
        if(p[i] == '*')
        {
            for(int j = 1; j <= sLen; j++)
                match[j] = match[j-1] || match[j];
        }
        else
        {
            for(int j = sLen; j > 0; j--)
                match[j] = (p[i] == '?' || p[i] == s[j-1]) && match[j-1];
            match[0] = false;
        }
    }
    return match[sLen];
}

//AC - 132ms - a typical DP solution;
bool isMatch(char* s, char* p)
{
    int sLen=strlen(s), pLen=strlen(p);
    sLen++, pLen++;
    bool **match = (bool**)malloc(sizeof(bool*)*sLen);
    for(int i = 0; i < sLen; i++)
        match[i] = (bool*)malloc(sizeof(bool)*pLen);
    match[sLen-1][pLen-1] = true;
    for(int i = pLen-2; i > -1; i--)
        if(p[i] != '*')
            break;
        else
            match[sLen-1][i] = true;
    for(int i = sLen-2; i > -1; i--)
        for(int j = pLen-2; j > -1; j--)
        {
            if(s[i]==p[j] || p[j]=='?')
                match[i][j] = match[i+1][j+1];
            else if(p[j] == '*')
                match[i][j] = match[i+1][j] || match[i][j+1];
            else
                match[i][j] = false;
        }
    return **match; 
}
