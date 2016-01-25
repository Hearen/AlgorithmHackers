/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-21 09:32
Description : 
Source      : https://leetcode.com/problems/length-of-last-word/
*******************************************/
#include <stdbool.h>
//AC - 0ms;
int lengthOfLastWord(char* s)
{
    int len = 0;
    int in = false;
    int pre = 0;
    while(*s)
    {
        if(isalpha(*s))
        {
            len++;
            in = true;
        }
        else
        {
            if(in)
                pre = len;
            in = false;
            len = 0;
        }
        s++;
    }
    if(isalpha(*(s-1)))
            return len;
    return pre;
}
