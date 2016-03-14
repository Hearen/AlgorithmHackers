/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-29 14:41
Description : 
Source      : https://leetcode.com/problems/basic-calculator/
*******************************************/
#include <bool.h>
//AC - 4ms;
int calculate(char* s)
{
    int* signs = (int*)malloc(sizeof(int)); //used to store the signs before opening bracket;
    int top = -1;
    signs[++top] = 1;
    int sign = 1;
    int num = 0;
    int ret = 0; //used to store the result;
    while(*s)
    {
        if(*s>='0' && *s<='9')  //collect the number between non-digits;
        {
            num = 10*num + *s - '0';
        }
        else if(*s=='+' || *s=='-') //add the previous number and reset sign;
        {
            ret += signs[top]*sign*num;
            num = 0;
            sign = (*s=='+'? 1 : -1);
        }
        else if(*s == '(') //store the sign before opening bracket;
        {
            signs = (int*)realloc(signs, sizeof(int)*(top+2));
            signs[top+1] = sign*signs[top]; //to avoid evaluation sequence problem, moving top++ to another statement;
            top++;
            sign = 1;
        }
        else if(*s == ')') //add the previous number and delete a sign for this pair of brackets;
        {
            ret += signs[top--]*sign*num;
            num = 0;
        }
        s++;
    }
    if(num) //if there is still number left;
        ret += signs[top]*sign*num;
    return ret;
}
