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
    if(n < 2) return "1"; //both 0 and 1 will return "1";
    n--;
    char *s = (char*)malloc(sizeof(char)*2); //prepare the first "1" as a start-up;
    s[0] = '1';
    s[1] = '\0';
    char *t = (char*)malloc(sizeof(char)); //used to store the next;
    while(n)
    {
        char cur = s[0]; 
        int count = 0; //count the frequency for each consecutive digit;
        int tSize = 0; //record the index in t;
        for(int i = 0; i < strlen(s)+1; i++) //move till \0 of the string;
        {
            if(cur != s[i]) //if not equal, we collect the count and the digit in letter-format;
            {
                tSize += 2; //count + digit -> two positions will be taken;
                t = (char*)realloc(t, sizeof(char)*(tSize+1));
                t[tSize-2] = count+'0';
                t[tSize-1] = cur;
                t[tSize] = '\0';
                cur = s[i]; //update cur with the current new letter s[i];
                count = 1; //count the current letter once;
            }
            else
            {
                count++; //count the cur;
            }
        }
        char *t0=t; t=s; s=t0; //exchange the string for next;
        n--; //decrement the times left;
    }
    return s;
}
