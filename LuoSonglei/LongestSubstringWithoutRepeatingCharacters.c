/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-13 20:50
Description: 
Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/
*******************************************/
#include"utils.h"
//rather ugly;
#define T
bool exists(char c, char* s, int size)
{
    for(int i = 0; i < size; i++)
    {
        #ifdef T
            printf("ei: %d\tec: %c\n", i, *(s+i));
        #endif
        if(c == *(s+i))
            return true;
    }
    return false;
}

int lengthOfLongestSubstring(char *s)
{
    /*if(*s == '\0')*/
    /*return 0;*/
    /*if(*s != *(s+1))*/
    /*return 1 + lengthOfLongestSubstring(s + 1);*/
    /*else*/
    /*return lengthOfLongestSubstring(s + 1);*/
    int i = 0, count = 1;
    while(*(s+i) != '\0')
    {
        count++;
        i++;
    }
    #ifdef T0
        printf("count: %d\n", count);
    #endif
    //count will include '\0';
    char* tmp = (char*)malloc(sizeof(char)*count);
    int max = 0;
    int index = 0;
    int i0 = 0;
    count = 0;
    i = 0;
    while(*(s+i) != '\0')
    {
        #ifdef T
            printf("i: %d\tc: %c\n", i, *(s+i));
        #endif
        if(!exists(*(s+i), tmp, index))
        {
            count++;
            #ifdef T
                printf("count: %d\n", count);
            #endif
            tmp[index++] = *(s+i);
            if(count > max)
                max = count;
        }
        else
        {
            count = 1;
            index = 0;
            i0++;
            i = i0 - 1;
        }
        i++;
    }
    return max;
}
