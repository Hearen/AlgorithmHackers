/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-17 21:17
Description : 
Source      : https://leetcode.com/problems/wildcard-matching/
*******************************************/
#include<stdbool.h>
bool cMatch(char* s, char* p)
{
    return (*s == *p || (*p == '?' && *s != '\0'));
}

bool sMatch(char* s, char* p)
{
    if(*p == '\0')
        return *s == '\0';
    if(*p != '*')
    {
        if(!cMatch(s,p))
            return false;
        else
            return sMatch(s+1, p+1);
    }
    else
    {
        while(*s!= '\0')
            if(sMatch(s++, p+1))
                return true;
        return false;
    }
}

//Time Limit Exceeded
bool isMatch(char* s, char* p)
{
    int index = 0;
    char* tmp = (char*)malloc(sizeof(char) * (strlen(p) + 1));
    int count = 0;
    while(*p != '\0')
    {
        *p == '*'? count++ : (count = 0);
        if(count < 2) tmp[index++] = *p;
        p++;
    }
    tmp[index] = '\0';
    return sMatch(s, p);
}
