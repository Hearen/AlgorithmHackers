/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-14 21:58
Description: 
Source: https://leetcode.com/problems/implement-strstr/
*******************************************/

int strStr(char* haystack, char* needle)
{
    int needleSize = 0;
    while(*(needle+needleSize) != '\0')
        needleSize++;
    int haySize = 0;
    while(*(haystack+haySize) != '\0')
        haySize++;
    if(haySize < needleSize)
        return -1;
    for(int i = 0; i <= haySize - needleSize; i++)
    {
        if(strncmp(haystack+i, needle, needleSize) == 0)
            return i;
    }
    return -1;
}
