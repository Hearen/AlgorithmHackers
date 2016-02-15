/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-15 21:26
Description : 
Source      : https://leetcode.com/problems/scramble-string/
*******************************************/
#include <stdbool.h>
bool equal(char* s1, char* s2, int len)
{
    int i = 0; 
    for(; i < len; i++)
        if(*(s1+i) != *(s2+i)) return false;
    return true;
}

bool isScramble0(char* s1, char* s2, int len)
{
    if(equal(s1, s2, len)) return true;
    int count[26] = {0};
    for(int i = 0; i < len; i++)
        count[s1[i]-'a']++, count[s2[i]-'a']--;
    for(int i = 0; i < 26; i++)
        if(count[i]) return false;
    for(int i=1; i < len; i++)
    {
        if(isScramble0(s1, s2, i) && isScramble0(s1+i, s2+i, len-i)) return true;
        if(isScramble0(s1, s2+len-i, i) && isScramble0(s1+i, s2, len-i)) return true;
    }
    return false;
}

//AC - 0ms - beats 100% submissions;
bool isScramble(char* s1, char* s2)
{
    int len1 = strlen(s1), len2 = strlen(s2);
    if(len1 != len2) return false;
    int len = len1;
    return isScramble0(s1, s2, len);
}
