/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-16 15:44
Description : 
Source      : https://leetcode.com/problems/interleaving-string/
*******************************************/
#include <stdbool.h>
//AC - 0ms - DP solution;
bool isInterleave(char* s1, char* s2, char* s3)
{
    int len1=strlen(s1), len2=strlen(s2);
    if(!len1 || !len2) return !strcmp(s1, s3) || !strcmp(s2, s3);
    if(strlen(s3) != len1+len2) return false;
    bool* cur=(bool*)malloc(sizeof(bool)*(len2+1));
    bool* pre=(bool*)malloc(sizeof(bool)*(len2+1));
    memset(pre, 0, sizeof(bool)*(len2+1));
    pre[0] = true; //initialize boundary condition;
    for(int i = 1; i <= len2; i++)
        if(s2[i-1] == s3[i-1])
            pre[i] = true;
        else
            break;
    for(int i = 1; i <= len1; i++) //i and j represent length of s1 and s2 respectively;
    {
        for(int j = 0; j <= len2; j++)
            cur[j] = (j>0 && cur[j-1] && s2[j-1]==s3[i+j-1]) ||
                (pre[j] && s1[i-1]==s3[i+j-1]);
        bool *t = pre; pre = cur; cur = t;
    }
    return pre[len2];
}
