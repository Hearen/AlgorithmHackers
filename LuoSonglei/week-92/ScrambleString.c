/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-15 21:26
Description : 
Source      : https://leetcode.com/problems/scramble-string/
*******************************************/
#include <stdbool.h>
bool isnScramble(char* s1, char* s2, int len)
{
    if(!strncmp(s1, s2, len)) return true;
    int count[26] = {0};
    for(int i = 0; i < len; i++) //using this method can filter almost all useless traversals;
        count[s1[i]-'a']++, count[s2[i]-'a']--;
    for(int i = 0; i < 26; i++)
        if(count[i]) return false;
    for(int i=1; i < len; i++)
        if(isnScramble(s1, s2, i) && isnScramble(s1+i, s2+i, len-i) ||
                isnScramble(s1, s2+len-i, i) && isnScramble(s1+i, s2, len-i)) return true;
    return false;
}

//AC - 0ms - beats 100% submissions;
bool isScramble1(char* s1, char* s2)
{
    int len = strlen(s1);
    return isnScramble(s1, s2, len);
}

//AC - 20ms - beats 100% submissions - DP solution;
bool isScramble(char* s1, char* s2)
{
    int len = strlen(s1);
    if(!len) return true;
    if(len==1) return *s1==*s2;
    bool*** match = (bool***)malloc(sizeof(bool**)*(len+1)); //recording the states for different length of strings starting from index 1 and index 2 respectively;
    for(int i = 0; i <= len; i++)
    {
        match[i] = (bool**)malloc(sizeof(bool*)*len);
        for(int j = 0; j < len; j++)
        {
            match[i][j] = (bool*)malloc(sizeof(bool)*len);
            memset(match[i][j], 0, sizeof(bool)*len);
        }
    }
    for(int i = 0; i < len; i++)
        for(int j = 0; j < len; j++)
            match[1][i][j] = (s1[i] == s2[j]);
    for(int size = 2; size <= len; size++)
        for(int i = 0; i <= len-size; i++)
            for(int j = 0; j <= len-size; j++)
                for(int k = 1; k<size && !match[size][i][j]; k++)
                    match[size][i][j] = (match[k][i][j] && match[size-k][i+k][j+k]) || (match[k][i+size-k][j] && match[size-k][i][j+k]);
    return match[len][0][0];
}
