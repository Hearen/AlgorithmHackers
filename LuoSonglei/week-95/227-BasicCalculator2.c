/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-10 14:01
Description : Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Source      : https://leetcode.com/problems/basic-calculator-ii/
*******************************************/
int helper(char* s, int len, int sign) //sign is used to record the previous sign before the current operator -> 1:positive, -1:negative;
{
    int num = 0;
    for(int i = 0; i < len; i++)
    {
        if(isdigit(s[i]))
            num = 10*num+s[i]-'0';
        else if(s[i]=='+') //'+' or '-' can be handled in the last round since there is no bracket;;
        {
            if(sign == 1) return num+helper(s+i+1, len-i-1, 1);
            else return num-helper(s+i+1, len-i-1, 1);
        }
        else if(s[i] == '-')
        {
            if(sign == 1) return num-helper(s+i+1, len-i-1, -1);
            else return num+helper(s+i+1, len-i-1, -1);
        }
        else if(s[i]=='*' || s[i]=='/')
        {
            char *t = (char*)malloc(sizeof(char)*len);  //used to store the result string for next round;
            int num1 = 0;
            int j = 1;
            for(; isdigit(s[i+j]); j++) //collect the second operand;
                num1 = 10*num1+s[i+j]-'0';
            long long ret = 0; //store the result of the operation '*' or '/';
            if(s[i] == '*')
                ret = num*num1;
            else if(s[i] == '/')
            {
                if(num1 == 0) ret = 0;
                else ret = num/num1;
            }
            if(s[i+j] == '\0') return ret; //nothing left just return;
            int index = 0; //turn the integer to string in reverse order;
            while(ret)
            {
                t[index++] = ret%10+'0';
                ret /= 10;
            }
            int k = 0;
            while(k < index) //
                s[i+j---1] = t[k++];
            free(t);
            s += i+j;
            return helper(s, strlen(s), 1);
        }
    }
    return num; //there is no operator just number;
}
int calculate(char* s)
{
    int index = 0;
    for(int i = 0; s[i]; i++) //remove all white spaces;
        if(s[i] != ' ')
            s[index++] = s[i];
    s[index] = '\0';
    printf("without space: %s\n", s);
    return helper(s, index, 1);
}
