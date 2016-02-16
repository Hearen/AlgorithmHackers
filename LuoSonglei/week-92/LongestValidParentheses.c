/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-16 09:59
Description : 
Source      : https://leetcode.com/problems/longest-valid-parentheses/
*******************************************/
//TLE;
int longestValidParentheses0(char* s)
{
    int len = strlen(s);
    if(len < 2) return 0;
    int max = 0;
    for(int i = 0; i < len; i++)
    {
        if(s[i] == '(')
        {
            int leftCount = 0;
            int count = 0;
            for(int j = i; j < len; j++)
            {
                if(s[j] == '(')
                    leftCount++;
                else
                {
                    if(leftCount)
                        count += 2;
                    leftCount--;
                }
                if(count > max)
                    max = count;
                if(leftCount < 0)
                    break;
            }
        }
    }
    return max;
}

//AC - 4ms;
int longestValidParentheses1(char* s)
{
    int len = strlen(s);
    int *stack = (int*)malloc(sizeof(int)*len);
    int top = -1;
    stack[++top] = -1;
    int max = 0;
    for(int i = 0; i < len; i++)
    {
        int t = stack[top];
        if(t!=-1 && s[i]==')' && s[t]=='(')
        {
            top--;
            if(i-stack[top] > max)
                max = i-stack[top];
        }
        else
            stack[++top] = i;
    }
    return max;
}
