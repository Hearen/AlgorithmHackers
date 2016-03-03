/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-03 20:40
Description : 
Source      : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*******************************************/
#include <stdlib.h>
const char *map[] = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
void traverse(char* digits, int size, char* stack, int top, char*** arr, int *returnSize)
{
    if(!*digits)
    {
        *returnSize += 1;
        *arr = (char**)realloc(*arr, sizeof(char*)*(*returnSize));
        (*arr)[*returnSize-1] = (char*)malloc(sizeof(char)*(size+1));
        for(int i = 0; i < size; i++)
            (*arr)[*returnSize-1][i] = stack[i];
        (*arr)[*returnSize-1][size] = '\0';
        return ;
    }
    int index = *digits-'1';
    for(int i = 0; i < strlen(map[index]); i++)
    {
        stack[top+1] = map[index][i];
        traverse(digits+1, size, stack, top+1, arr, returnSize);
    }
}
//AC - 0ms;
char** letterCombinations(char* digits, int* returnSize)
{
    if(!*digits) return NULL;
    char **arr = (char**)malloc(sizeof(char*));
    *returnSize = 0;
    int len = strlen(digits);
    char *stack = (char*)malloc(sizeof(char)*len);
    int top = -1;
    int index = *digits-'1';
    for(int i = 0; i < strlen(map[index]); i++)
    {
        stack[top+1] = map[index][i];
        traverse(digits+1, len, stack, top+1, &arr, returnSize);
    }
    return arr;
}
