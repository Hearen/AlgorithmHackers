/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-03 20:55
Description : 
Source      : https://leetcode.com/problems/generate-parentheses/
*******************************************/
#include <stdlib.h>
void traverse(char*** arr, int* returnSize, char* stack, int top, int leftCount, int rightCount)
{
    if(!leftCount && !rightCount)
    {
        *returnSize += 1;
        *arr = (char**)realloc(*arr, sizeof(char*)*(*returnSize));
        (*arr)[*returnSize-1] = (char*)malloc(sizeof(char)*(top+2));
        for(int i = 0; i <= top; i++)
            (*arr)[*returnSize-1][i] = stack[i];
        (*arr)[*returnSize-1][top+1] = '\0';
        return ;
    }
    if(leftCount)
    {
        stack[top+1] = '(';
        traverse(arr, returnSize, stack, top+1, leftCount-1, rightCount);
    }
    if(rightCount > leftCount) //always close the opening brackets;
    {
        stack[top+1] = ')';
        traverse(arr, returnSize, stack, top+1, leftCount, rightCount-1);
    }
}

//AC - 0ms;
char** generateParenthesis(int n, int* returnSize)
{
    if(!n) return NULL;
    char **arr = (char**)malloc(sizeof(char*));
    *returnSize = 0;
    char* stack = (char*)malloc(sizeof(char)*2*n);
    int top = -1;
    int leftCount = n; 
    int rightCount = n;
    traverse(&arr, returnSize, stack, top, leftCount, rightCount);
    return arr;
}
