/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-11 08:41
Description : Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
Source      : https://leetcode.com/problems/additive-number/
*******************************************/
#include <cstdbool.h>
char* addString(char* s1, int len1, char* s2, int len2)
{
    int sum = 0;
    char* t = (char*)malloc(sizeof(char)*(len1+len2));
    int index = 0;
    int carry = 0;
    while(len1>0 || len2>0) //add them from the end to the begin, but the t will collect them in reverse direction;;
    {
        sum = carry + (len1>0? s1[len1---1]-'0':0) + (len2>0? s2[len2---1]-'0':0);
        t[index++] = sum%10+'0';
        carry = sum/10;
    }
   if(carry) //if there is a last carry, collect it;
        t[index++] = carry+'0';
    for(int i = 0; i < index/2; i++) //reverse t;
    {
        char c=t[i]; t[i]=t[index-i-1]; t[index-i-1]=c;
    }
    t[index] = '\0'; //terminate the string;
    return t;
}
bool isValid(char* s1, int len1, char* s2, int len2, char* s3, int len3)
{
    if(*s1=='0' && len1>1) return false; //handle corner cases;
    if(*s2=='0' && len2>1) return false;
    if(len3 == 0) return true; //nothing left to compare, so far so good just return true;
    char* t = addString(s1, len1, s2, len2);
    int len = strlen(t);
    return strncmp(t, s3, len)==0 && isValid(s2, len2, t, len, s3+len, len3-len); //if the current round is valid then check the next round till the end;
}

bool isAdditiveNumber(char* s)
{
    int len = strlen(s);
    for(int i = 1; i <= len/2; i++)
        for(int j = 1; j <= (len-i)/2; j++) //there should always be some left for the third part, the sum;
            if(isValid(s, i, s+i, j, s+i+j, len-i-j)) return true;
    return false; //no combination works;
}
