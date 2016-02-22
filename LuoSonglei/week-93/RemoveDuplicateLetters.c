/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-22 10:41
Description : 
Source      : https://leetcode.com/problems/remove-duplicate-letters/
*******************************************/
#include <stdbool.h>
#include <stdlib.h>
//AC - 0ms;
char* removeDuplicateLetters0(char* s)
{
    int count[26] = {0};
    bool visited[26] = {0};
    int len = strlen(s);
    for(int i = 0; i < len ;i++) count[s[i]-'a']++; //count the frequency of each character;
    char *t = (char*)malloc(sizeof(char)*27);
    int size = 0;
    for(int i = 0; i < len; i++)
    {
        int index = s[i]-'a';
        count[index]--;
        if(visited[index]) continue; //stored already, needless to backtrack the rest will backtrack and remove it if necessary;
        int j = size-1; //encounter this character the first time backtrack to find a suitable position;
        for(; j > -1; j--)
        {
            int index = t[j]-'a';
            if(s[i] < t[j] && count[index]) visited[index] = false; //if the previous character is bigger and its counter is also above zero which means there is still such character in the remaining substring, to keep lexicographical order, we have to remove it from the final string and visited records;
            else break;
        }
        size = j+1; //new size of the final string;
        t[size++] = s[i];
        visited[index] = true;
    }
    t[size] = '\0';
    return t;
}

void helper(char* s, char* t, int* returnSize)
{
    int len = strlen(s);
    if(!len) return ;
    int count[26] = {0};
    int index = 0;
    for(int i = 0; i < len; i++) count[s[i]-'a']++;
    for(int i = 0; i < len; i++)
    {
        if(s[i] < s[index]) //search for the smallest;
            index = i;
        if(!(--count[s[i]-'a'])) //ensure every letter appears at least once, do not exclude any letter;
            break;
    }
    char c = s[index];
    *returnSize += 1;
    t[*returnSize-1] = c;
    int newIndex = 0;
    for(int i = index+1; i < len; i++) //reconstructing the left substring by removing the collected character and the letters before the selected;
        if(s[i] != c)
            s[newIndex++] = s[i];
    s[newIndex] = '\0';
    helper(s, t, returnSize);
}

//AC - 4ms;
char* removeDuplicateLetters(char* s)
{
    char* t = (char*)malloc(sizeof(char)*27);
    int size = 0;
    helper(s, t, &size);
    t[size] = '\0';
    return t;
}
