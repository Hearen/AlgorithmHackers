/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-13 08:18
Description : 
Source      : https://leetcode.com/problems/isomorphic-strings/
*******************************************/
#include <stdbool.h>
//AC - 0ms;
bool isIsomorphic(char* s, char* t)
{
    int len = 128;
    char* map = (char*)malloc(sizeof(char)*len);
    for(int i = 0; i < len; i++)
        map[i] = 0;
    while(*s != '\0')
    {
        if(map[*s]==0)
        {
            map[*s] = *t;
            int count = 0;
            for(int i = 0; i < len; i++)
                if(map[i] == *t)
                    count++;
            if(count > 1)
                return false;
        }
        else if(map[*s] != *t)
            return false;
        s++, t++;
    }
    return true;
}
