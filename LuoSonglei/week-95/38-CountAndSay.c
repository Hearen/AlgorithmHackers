/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-07 14:19
Description : The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
Source      : https://leetcode.com/problems/count-and-say/
*******************************************/
//AC - 0ms;
char* countAndSay(int n)
{
    if(n < 2) return "1";
    n--;
    char *s = (char*)malloc(sizeof(char)*2);
    s[0] = '1';
    s[1] = '\0';
    char *t = (char*)malloc(sizeof(char));
    while(n)
    {
        char cur = s[0];
        int count = 0;
        int tSize = 0;
        for(int i = 0; i < strlen(s)+1; i++)
        {
            if(cur != s[i])
            {
                tSize += 2;
                t = (char*)realloc(t, sizeof(char)*(tSize+1));
                t[tSize-2] = count+'0';
                t[tSize-1] = cur;
                t[tSize] = '\0';
                cur = s[i];
                count = 1;
            }
            else
            {
                count++;
            }
        }
        char *t0=t; t=s; s=t0;
        n--;
    }
    return s;
}
