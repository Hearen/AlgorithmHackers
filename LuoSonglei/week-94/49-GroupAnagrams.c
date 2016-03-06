/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-06 21:32
Description : Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
[
["ate", "eat","tea"],
["nat","tan"],
["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
Source      : https://leetcode.com/problems/anagrams/
*******************************************/
#include <stdlib.h>
void sort(char* s, int begin, int end)
{
    int l=begin, r=end;
    char c = s[(r+l)/2];
    while(l <= r)
    {
        while(s[l] < c) l++;
        while(s[r] > c) r--;
        if(l <= r)
        {
            char t=s[l]; s[l]=s[r]; s[r]=t;
            l++; r--;
        }
    }
    if(begin < r)
        sort(s, begin, r);
    if(l < end)
        sort(s, l, end);
}

char*** groupAnagrams(char** strs, int size, int** colSizes, int* returnSize)
{
    if(!size) return NULL;
    *returnSize = 0;
    *colSizes = (int*)malloc(sizeof(int)*size);
    char*** arr = (char***)malloc(sizeof(char**));
    int *bits = (int*)malloc(sizeof(int)*size);
    memset(bits, 0, sizeof(int)*size);
    for(int i = 0; i < size; i++)
    {
        for(int j = 0; strs[i][j]; j++)
            bits[i] |= 1<<(strs[i][j]-'a');
    }

    for(int i = 0; i < size; i++)
    {
        int j = 0; 
        while(j < *returnSize)
        {
        }
    }
}
