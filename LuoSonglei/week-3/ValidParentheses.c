/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-21 08:37
Description : 
Source      : https://leetcode.com/problems/valid-parentheses/
*******************************************/
#include <stdbool.h>
bool isValid(char* s)
{
    int size = strlen(s);
    if(size < 2)
        return false;
    char* stack = (char*)malloc(sizeof(char) * (size+1));
    int top = -1;
    char c;
    for(int i = 0; i < size; i++)
    {
        if(*(s+i) == '(' || *(s+i) == '{' || *(s+i) == '[')
        {
            stack[++top] = *(s+i);
        }
        else
        {
            switch(*(s+i))
            {
                case ')': c = '('; break;
                case '}': c = '{'; break;
                case ']': c = '['; break;
                default: break;
            }
            if(stack[top--] != c)
                return false;
        }
    }
    return top == -1;
}
