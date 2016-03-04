/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-04 08:25
Description : 
Source      : https://leetcode.com/problems/palindrome-partitioning/
*******************************************/
#include <stdlib.h>
void traverse(char* s, int len, int begin, char** stack, int top, char**** arrs, int** colSizes, int* returnSize)
{
    if(begin == len)
    {
        *returnSize += 1;
        *colSizes = (int*)realloc(*colSizes, sizeof(int)*(*returnSize));
        (*colSizes)[*returnSize-1] = top+1;
        *arrs = (char***)realloc(*arrs, sizeof(char**)*(*returnSize));
        (*arrs)[*returnSize-1] = (char**)malloc(sizeof(char*)*(top+1));
        for(int i = 0; i <= top; i++)
            (*arrs)[*returnSize-1][i] = stack[i];
        return ;
    }
    for(int i = begin; i < len; i++)
    {
        int l=begin, r=i;
        while(l<r && s[l]==s[r]) l++, r--;
        if(l >= r)
        {
            int size = i-begin+1;
            char *t = (char*)malloc(sizeof(char)*(size+1));
            *t = '\0';
            strncat(t, s+begin, size);
            stack[top+1] = t;
            traverse(s, len, i+1, stack, top+1, arrs, colSizes, returnSize);
        }
    }
}
char*** partition(char* s, int** colSizes, int* returnSize)
{
    if(!*s) return NULL;
    int len = strlen(s);
    *returnSize = 0;
    *colSizes = (char*)malloc(sizeof(char));
    char*** arrs = (char***)malloc(sizeof(char**));
    char** stack = (char**)malloc(sizeof(char*)*len);
    int top = -1;
    traverse(s, strlen(s), 0, stack, top, &arrs, colSizes, returnSize);
    return arrs;
}
