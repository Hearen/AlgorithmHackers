/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-13 10:28
Description : Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
Source      : https://leetcode.com/problems/word-break/
*******************************************/
#include <cstdbool.h>
#define MIN(a, b) ((a) < (b) ? (a) : (b))
bool traverse(char* s, int start, int len, int min, int max, char** dict, int size)
{
    if(start == len)
        return true;
    int top = MIN(len-start, max);
    for(int i = min; i < top; i++) //the length of the substring starting from index start;
    {
        int j = 0;
        for(; j < size; j++) //check whether the substring is a word in the dictionary;
            if(strlen(dict[j])==i && strncmp(s+start, dict[j], i)==0)
                break;
        if(j!=size && traverse(s, start+i, len, min, max, dict, size)) return true;
    }
    return false;
}

//TLE
//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
bool wordBreak(char* s, char** dict, int size)
{
    if(*s=='\0') return true;
    if(size == 0) return false;
    int min = strlen(dict[0]), max = 0;
    for(int i = 0; i < size; i++)
    {
        int len = strlen(dict[i]);
        if(len < min) min = len;
        if(len > max) max = len;
    }
    return traverse(s, 0, strlen(s), min, max, dict, size);
}
