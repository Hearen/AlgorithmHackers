/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-14 11:27
Description : 
Source      : https://leetcode.com/problems/word-pattern/
*******************************************/
#include <stdbool.h>
#include <string.h>
#define LEN 26
//AC - 0ms;
bool wordPattern(char* pattern, char* str)
{
    char** map = (char**)malloc(sizeof(char*)*LEN);
    for(int i = 0; i < LEN; i++)
        map[i] = "";
    char* cur;
    cur = strtok(str, " "); //handle the first substring;
    if(strlen(pattern) == 0 && cur) //when str is not empty but pattern is empty;
        return false;
    map[*pattern-'a'] = cur;
    while(*pattern)
    {
        pattern++;
        if(*pattern == '\0')//ensure the key will be valid;
            break;
        int key = *pattern - 'a';
        cur = strtok(NULL, " ");//get next substring;
        if(!cur)//less than letter array;
            return false;
       if(map[key] == "")
        {
            for(int i = 0; i < LEN; i++) //make sure one letter to just one unique string;
                if(strcmp(map[i], cur) == 0)
                    return false;
            map[key] = cur;
        }
        if(strcmp(map[key], cur) != 0)
            return false;
    }
    cur = strtok(NULL, " ");//might be longer than letter array;
    return !cur;
}
