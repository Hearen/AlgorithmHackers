/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-12 09:01
Description : 
Source      : https://leetcode.com/problems/valid-anagram/
*******************************************/
#include <stdbool.h>
//Time Limit Exceeded;
bool isAnagram0(char* s, char* t)
{
    int size = -1;
    while(*(t+(++size)) != '\0');
    while(*s != '\0')
    {
        int i = 0;
        for(; i < size; i++)
        {
            if(*s == *(t+i))
            {
                *(t+i) = '0';
                break;
            }
        }
        s++;
        if(i == size)
            return false;
    }
    for(int i = 0; i < size; i++)
        if(*(t+i) != '0')
            return false;
    return true;
}

#define LEN 26
//AC - 0ms;
bool isAnagram1(char* s, char* t)
{
    char *p = s;
    int map[LEN] = {0};
    while(*p)
        map[*(p++)-'a']++;
    p = t;
    while(*p)
        map[*(p++)-'a']--;
    for(int i = 0; i < LEN; i++)
        if(map[i])
            return false;
    return true;
}
