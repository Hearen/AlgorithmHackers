/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-29 12:23
Description : 
Source      : https://leetcode.com/problems/integer-to-roman/
*******************************************/
#include <stdlib.h>
//AC - 28ms;
char* intToRoman(int num)
{
    if(num<1 || num>3999) return NULL;
    int index = 0;
    char* s = (char*)malloc(sizeof(char)*100);
    while(num >= 1000)
    {
        s[index++] = 'M';
        num -= 1000;
    }
    if(num >= 900)
    {
        s[index++] = 'C';
        s[index++] = 'M';
        num -= 900;
    }
    if(num >= 500)
    {
        s[index++] = 'D';
        num -= 500;
    }
    if(num >= 400)
    {
        s[index++] = 'C';
        s[index++] = 'D';
        num -= 400;
    }
    while(num >= 100)
    {
        s[index++] = 'C';
        num -= 100;
    }
    if(num >= 90)
    {
        s[index++] = 'X';
        s[index++] = 'C';
        num -= 90;
    }
    if(num >= 50)
    {
        s[index++] = 'L';
        num -= 50;
    }
    if(num >= 40)
    {
        s[index++] = 'X';
        s[index++] = 'L';
        num -= 40;
    }
    while(num >= 10)
    {
        s[index++] = 'X';
        num -= 10;
    }
    if(num >= 9)
    {
        s[index++] = 'I';
        s[index++] = 'X';
        num -= 9;
    }
    if(num >= 5)
    {
        s[index++] = 'V';
        num -= 5;
    }
    if(num >= 4)
    {
        s[index++] = 'I';
        s[index++] = 'V';
        num -= 4;
    }
    while(num)
    {
        s[index++] = 'I';
        num--;
    }
    s[index] = '\0';
    return s;
}
