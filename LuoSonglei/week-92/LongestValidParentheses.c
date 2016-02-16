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

//AC - 0ms - DP solution;
int longestValidParentheses2(char* s)
{
    int len = strlen(s);
    if(len < 2) return 0;
    int max = 0;
    int *maxs = (int*)malloc(sizeof(int)*len); //record the max viable length ending with the current;
    memset(maxs, 0, sizeof(int)*len);
    for(int i = 1; i < len; i++)
    {
        if(s[i] == ')')
        {
            if(s[i-1] == '(')
            {
                maxs[i] = 2;
                if(i > 1)
                    maxs[i] = 2+maxs[i-2];
            }
            else if(i-maxs[i-1] > 0 && s[i-maxs[i-1]-1] == '(')
                    maxs[i] = maxs[i-1] + maxs[i-maxs[i-1]-2] + 2; 
            if(maxs[i] > max)
                max = maxs[i];
        }
    }
    return max;
}

//AC - 0ms;
int longestValidParentheses(char* s)
{
    int len = strlen(s);
    int max = 0;
    int *maxs = (int*)malloc(sizeof(int)*len); //record the max viable length ending with the current;
    memset(maxs, 0, sizeof(int)*len);
    for(int i = 1; i < len; i++)
        if(s[i] == ')')
        {
            int t = i-maxs[i-1];
            if(s[t-1] == '(') maxs[i] = maxs[i-1] + maxs[t-2] + 2; 
            if(maxs[i] > max) max = maxs[i];
        }
    return max;
}
