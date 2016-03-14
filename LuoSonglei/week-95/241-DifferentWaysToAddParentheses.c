/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-08 14:45
Description : Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
Hint: there are just valid strings will be provided.
Source      : https://leetcode.com/problems/different-ways-to-add-parentheses/
*******************************************/
#include <cstdbool.h>
int* compute(char* s, int len, int* size)
{
    int *arr = (int*)malloc(sizeof(int));
    *size = 0;
    int *arr0, *arr1; //prepared for storing the array of different results from left and right side of a operator;
    int size0=0, size1=0; //used to cooperate with arr0 and arr1 respectively;
    for(int i = 0; i < len; i++)
    {
        if(!isdigit(s[i]))
        {
            arr0 = compute(s, i, &size0); //compute the left part of the string and store it in arr0;
            arr1 = compute(s+i+1, len-i-1, &size1); //compute the right part;
            for(int j = 0; j < size0; j++)
            {
                for(int k = 0; k < size1; k++)
                {
                    switch(s[i])
                    {
                        case '-': arr[*size] = arr0[j]-arr1[k]; break;
                        case '+': arr[*size] = arr0[j]+arr1[k]; break;
                        case '*': arr[*size] = arr0[j]*arr1[k]; break;
                        default: break;
                    }
                    *size += 1;
                    arr = (int*)realloc(arr, sizeof(int)*(*size+1)); //dynamically allocate space for arr;
                }//end of arr1
            }//end of arr0;
        }
    }
    if(*size == 0) //there is no operator in s[0] - s[len-1], so just collect the number;
    {
        int t = 0;
        for(int i = 0; i < len; i++)
            t = 10*t + (s[i]-'0');
        arr[*size] = t;
        *size += 1;
    }
    return arr;
}
int* diffWaysToCompute(char* s, int* returnSize)
{
    return compute(s, strlen(s), returnSize);
}
