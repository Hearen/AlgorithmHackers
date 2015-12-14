/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-14 22:15
Description: 
Source: https://leetcode.com/problems/valid-palindrome/
*******************************************/
#include<ctype.h>
#include<stdbool.h>
bool isPalindrome(char* s)
{
    int size = 0;
    while(*(s+size) != '\0')
        size++;
    int i = 0, j = size - 1;
    while(i <= j)
    {
        while(i <= j && !isalnum(*(s+i)))
            i++;
        while(i <= j && !isalnum(*(s+j)))
            j--;
        if(i <= j && tolower(*(s+i)) != tolower(*(s+j)))
            return false;
        else
        {
            i++;
            j--;
        }
    }
    return true;
}
