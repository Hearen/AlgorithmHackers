/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-24 11:42
Description : 
Source      : https://leetcode.com/problems/distinct-subsequences/
*******************************************/
//AC - 4ms;
int numDistinct(char* s, char* t)
{
    int sLen = strlen(s), tLen = strlen(t);
    int *pre = (int*)malloc(sizeof(int)*(sLen+1));
    int *cur = (int*)malloc(sizeof(int)*(sLen+1));
    for(int i = 0; i <= sLen; i++)
        pre[i] = 1;
    for(int i = 0; i <= tLen; i++)
    {
        for(int j = 1; j <= sLen; j++)
        {
            if(t[i-1] != s[j-1])
                cur[j] = cur[j-1];
            else
                cur[j] = cur[j-1]+pre[j-1];
        }
        for(int i=0; i <= sLen; i++)
            pre[i] = cur[i];
    }
    return pre[sLen];
}
