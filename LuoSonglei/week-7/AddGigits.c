/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-14 16:00
Description : 
Source      : https://leetcode.com/problems/add-digits/
*******************************************/
#define LEN 30
char* int2Str(int a, int* size)
{
    char* s = (char*)malloc(sizeof(char)*LEN);
    char t[LEN];
    int index = 0;
    if(a == 0)
        s[index++] = '0';
    while(a)
    {
        t[index++] = a%10 + '0';
        a /= 10;
    }
    for(int i = 0; i < index; i++)
        s[index-i-1] = t[i];
    s[index] = '\0';
    *size = index;
    return s;
}
//AC - 8ms;
//iterative calculation;
int addDigits0(int num)
{
    int len;
    char *s = int2Str(num, &len);
    while(len > 1)
    {
        num = 0;
        while(*s)
          num += *(s++) - '0';
        s = int2Str(num, &len);
    }
    return num;
}

//AC - 8ms - quite weird, the same with the complicated previous solution;
//using formula - either 9 or the result within 9;
int addDigits(int num)
{
    return (num && !(num %= 9))? 9 : num;
}
