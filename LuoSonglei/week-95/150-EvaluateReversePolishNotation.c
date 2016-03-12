/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-12 20:30
Description : Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
Source      : https://leetcode.com/problems/evaluate-reverse-polish-notation/
*******************************************/
#include <cstdbool.h>
bool isOperator(char c)
{
    return c=='+' || c=='-' || c=='*' || c=='/';
}
int evalRPN(char** tokens, int size)
{
    int *stack = (int*)malloc(sizeof(int)*size);
    int top = -1;
    int num = 0;
    for(int i = 0; i < size; i++)
    {
        num = 0;
        if(tokens[i][1]=='\0' && isOperator(tokens[i][0])) //ensure its length is 1 and the only one letter is operator;
        {
            int b = stack[top--]; //pop out the second operand;
            int a = stack[top--]; //pop out the first operand;
            if(tokens[i][0] == '+') num = a+b;
            else if(tokens[i][0] == '-') num = a-b;
            else if(tokens[i][0] == '*') num = a*b;
            else if(tokens[i][0] == '/') num = a/b;
        }
        else
        {
            int j = 0;
            if(isOperator(tokens[i][0])) j++; //there is leading sign;
            int sign = tokens[i][0]=='-'? -1 : 1; //take the sign;
            for(; tokens[i][j]; j++)
                num = 10*num + tokens[i][j] - '0';
            num *= sign;
        }
        stack[++top] = num;
    }
    return stack[0];
}
