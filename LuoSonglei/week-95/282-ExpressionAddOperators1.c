/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-12 08:00
Description : Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
Source      : https://leetcode.com/problems/expression-add-operators/
*******************************************/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
void helper(char* num, int len, int start, int target, long long sum, long long pre, char* stack, int top, char*** arr, int* returnSize)
{
    if(start == len) //end of the string;
    {
        if(target == sum+pre) //add sum and pre to check whether it's valid, since pre is not added so far;
        {
            stack[++top] = '\0'; //terminate the string;
            *returnSize += 1; 
            *arr = (char**)realloc(*arr, sizeof(char*)*(*returnSize));
            (*arr)[*returnSize-1] = (char*)malloc(sizeof(char)*(top+1));
            for(int i = 0; i <= top; i++)
                (*arr)[*returnSize-1][i] = stack[i];
        }
        return ; 
    }
    long long val = 0; //in case of INT_MAX or INT_MIN;
    int index = top+1; //record the index for the operator;
    for(int i = start; i < len; i++)
    {
        val = 10*val + num[i] - '0'; //collect the number;
        if(start == 0) //if it's the first number, no operator should be added;
        {
            stack[top+1] = num[i];
            helper(num, len, i+1, target, 0, val, stack, top+1, arr, returnSize);
        }
        else
        {
            stack[top+2] = num[i];
            stack[index] = '-'; //get the sum directly by sum+val since we will store -1*val for subtraction and record -1*val as pre in case the next operator is '*';
            helper(num, len, i+1, target, sum+pre, -1*val, stack, top+2, arr, returnSize);
            stack[index] = '+'; //store val as pre in case the next operator is '*';
            helper(num, len, i+1, target, sum+pre, val, stack, top+2, arr, returnSize);
            stack[index] = '*'; //save the product of pre and val for next round;
            helper(num, len, i+1, target, sum, pre*val, stack, top+2, arr, returnSize);
        }
        if(num[start] == '0') break; //no number starts with 0;
        top++;
    }
}
char** addOperators(char* num, int target, int* returnSize)
{
    char** arr = (char**)malloc(sizeof(char*));
    *returnSize = 0;
    int len = strlen(num);
    if(len == 0) return arr;
    char* stack = (char*)malloc(sizeof(char)*2*len);
    int top = -1;
    helper(num, len, 0, target, 0, 0, stack, top, &arr, returnSize);
    return arr;
}

int main(int argc, char *argv[])
{
    char *s = "123";
    int target = 6;
    int size = 0;
    char** arr = addOperators(s, target, &size);
    for(int i = 0; i < size; i++)
        printf("%s\n", arr[i]);
    return 0;
}
