/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 08:24
Description : 
Source      : https://leetcode.com/problems/excel-sheet-column-number/
*******************************************/
//AC - 4ms;
int titleToNumber(char* s)
{
    int sum = 0;
    while(*s)
        sum += 26*sum+(*(s++)-'A'+1);
    return sum;
}
