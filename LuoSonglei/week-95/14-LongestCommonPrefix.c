/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-07 21:37
Description : Write a function to find the longest common prefix string amongst an array of strings.
Source      : https://leetcode.com/problems/longest-common-prefix/
*******************************************/
#include <cstdbool.h>
//AC - 0ms;
char* longestCommonPrefix(char** strs, int size)
{
    if(!size) return "";
    char *s = (char*)malloc(sizeof(char)*(strlen(strs[0]+1)));
    int index = 0;
    for(int i = 0; strs[0][i]; i++)
    {
        char c = strs[0][i];
        int j = 1;
        while(j < size)
        {
            if(strs[j][i] != c)
                break;
            j++;
        }
        if(j == size)
            s[index++] = c;
        else
            break;
    }
    s[index] = '\0';
    return s;
}
