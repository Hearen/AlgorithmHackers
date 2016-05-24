/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : Tue, 24 May 2016 19:58 CST
Description : Write a function that takes a string as input and reverse only the vowels of a string.
Example 1:
Given s = "hello", return "holle".
Example 2:
Given s = "leetcode", return "leotcede".
Source      : https://leetcode.com/problems/reverse-vowels-of-a-string/
*******************************************/
#include <cstdbool.h>
//AC - 4ms;
bool isVowel(char a)
{
    char c = tolower(a);
    return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
}
char* reverseVowels(char* s) {
    int len = strlen(s);
    int l=0, r=len-1;
    while(l < r)
    {
        while(l<len && !isVowel(s[l])) l++;
        while(r>-1 && !isVowel(s[r])) r--;
        if(l<len && r>-1 && l < r)
        {
            char t=s[l]; s[l]=s[r]; s[r]=t;
            l++, r--;
        }
    }
    return s;
}
