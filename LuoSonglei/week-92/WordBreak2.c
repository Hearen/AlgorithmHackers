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
    {
        if(strlen(wordDict[i]) == len && !strncmp(wordDict[i], s, len))
            return true;
    }
    return false;
}

char* merge(char* s, int len, const char* cur, int total, int space)
{
    printf("inside merge -- cur: %s\t len: %d\n", cur, strlen(cur));
    char* t = (char*)malloc(sizeof(char)*(total+space));
    *t = '\0';
    printf("len: %d\t%s\n", strlen(t), t);
    strcat(t, cur);
    printf("len: %d\t%s\n", strlen(t), t);
    strncat(t, s, len);
    if(space) strcat(t, " ");
    printf("len: %d\t%s\n", strlen(t), t);
    return t;
}

void buildPath(bool* breakable, char* s, int pos, char** arr, int* returnSize, char* cur, char** wordDict, int size, int min, int max)
{
    printf("begin inside buildPath -- cur: %s\t len: %d\n", cur, strlen(cur));
    printf("current size: %d\n", *returnSize);
    for(int i = 0; i < *returnSize; i++)
        printf("%s\n", arr[i]);
    int len = strlen(s);
    for(int i = min; i <= MIN(max, len-pos); i++)
    {
        int total = i+strlen(cur)+1;
        printf("checking len: %d\tmax: %d\tend: %d\n", i, max, len-pos);
        if(breakable[i+pos] && exist(s+pos, i, wordDict, size))
        {
            printf("pre: %s\n", cur);
            printf("exists in wordDict\n");
            for(int j = 0; j < i; j++)
                printf("%c", s[pos+j]);
            printf("\n");
            if( pos+i == len)
            {
                (*returnSize)++;
                arr = (char**)realloc(arr, sizeof(char*)*(*returnSize));
                arr[*returnSize-1] = merge(s+pos, i, cur, total, 0);
                printf("---------ends here a new string: new size: %d\n", *returnSize);
                for(int i = 0; i < *returnSize; i++)
                    printf("%s\n", arr[i]);
                printf("\n\n");
            }
            else 
            {
                printf("processing inside buildPath -- cur: %s\t len: %d\n", cur, strlen(cur));
                buildPath(breakable, s, pos+i, arr, returnSize, merge(s+pos, i, cur, total, 1), wordDict, size, min, max);
            }
        }
    }
}

//RE - when hitting size - 5; 
//"aaaaaaa" ["aaaa","aa","a"]
char** wordBreak(char* s, char** wordDict, int size, int* returnSize)
{
    char** arr = (char**)malloc(sizeof(char*));
    *returnSize = 0;
    int min=INT_MAX, max=0; //get the min and max length of the word in wordDict;
    int len = strlen(s);
    bool* breakable = (bool*)malloc(sizeof(bool)*(len+1));
    memset(breakable, 0, sizeof(bool)*(len+1));
    breakable[len] = true;
    for(int i = 0; i < size; i++)
    {
        min = MIN(min, strlen(wordDict[i]));
        max = MAX(max, strlen(wordDict[i]));
    }
    printf("min: %d\tmax: %d\n", min, max);
    for(int i = len-min; i >= 0; i--)
        for(int j = min; j <= MIN(max, len-i); j++)
            if(breakable[i+j] && exist(s+i, j, wordDict, size))
            {
                breakable[i] = true;
                break;
            }
    for(int i = 0; i <= len; i++)
        printf("breakable: %d\t", breakable[i]);
    printf("\n");
    char *cur = (char*)malloc(sizeof(char)*2*len);
    *cur = '\0';
    if(breakable[0]) buildPath(breakable, s, 0, arr, returnSize, cur, wordDict, size, min, max);
    return arr;
}
