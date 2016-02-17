/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-17 16:49
Description : 
Source      : https://leetcode.com/problems/word-break-ii/
*******************************************/
#include <stdbool.h>
#include <limits.h>
#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a) : (b))
bool exist(char* s, int len, char** wordDict, int size)
{
    for(int i = 0; i < size; i++)
        if(!strncmp(wordDict[i], s, len))
            return true;
    return false;
}

char* merge(char* s, int len, char* cur, int total)
{
    char* t = (char*)malloc(sizeof(char)*(total));
    *t = '\0';
    strcat(t, cur);
    strncat(t, s, len);
}

void buildPath(bool* breakable, char* s, int pos, char** arr, int* returnSize, char* cur, char** wordDict, int size, int min, int max)
{
    int len = strlen(s);
    for(int i = min; i <= MIN(max, len-pos); i++)
    {
        int total = i+strlen(cur)+2;
        if(breakable[i+pos] && exist(s+pos, i, wordDict, size))
        {
            (*returnSize)++;
            arr = (char**)realloc(arr, sizeof(char*)*(*returnSize));
            arr[*returnSize-1] = merge(s+pos, i, cur, total);
        }
        else 
        {
            char* cur = merge(s+pos, i, cur, total);
            cur[total-2] = ' ';
            cur[total-1] = '\0';
            buildPath(breakable, s, pos+i, arr, returnSize, cur, wordDict, size, min, max);
        }
    }
}
char** wordBreak(char* s, char** wordDict, int size, int* returnSize)
{
    char** arr = (char**)malloc(sizeof(char*));
    *returnSize = 0;
    int min=INT_MAX, max=INT_MIN;
    int len = strlen(s);
    bool* breakable = (bool*)malloc(sizeof(bool)*(len+1));
    memset(breakable, 0, sizeof(bool)*(len+1));
    breakable[len] = true;
    for(int i = 0; i < size; i++)
    {
        min = MIN(min, strlen(wordDict[i]));
        max = MAX(max, strlen(wordDict[i]));
    }
    for(int i = len-min; i >= 0; i--)
        for(int j = min; j <= MIN(max, len-i); j++)
            if(breakable[i+j] && exist(s+i, j, wordDict, size))
            {
                breakable[i] = true;
                break;
            }
    if(breakable[0]) buildPath(breakable, s, 0, arr, returnSize, "", wordDict, size, min, max);
    return arr;
}
