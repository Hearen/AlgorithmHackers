/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-14 16:09
Description : 
Source      : https://leetcode.com/problems/regular-expression-matching/
*******************************************/
#include <stdbool.h>
//AC - 4ms;
bool isMatch(char* s, char* p)
{
    int sLen = strlen(s), pLen = strlen(p);
    sLen++, pLen++;
    bool *pre = (bool*)malloc(sizeof(bool)*pLen);
    bool *cur = (bool*)malloc(sizeof(bool)*pLen);
    memset(pre, 0, sizeof(bool)*pLen);
    memset(cur, 0, sizeof(bool)*pLen);
    pre[0] = cur[0] = true;
    for(int i=0; i < sLen; i++)//i and j here represent length instead of index;
    {
        if(i) cur[0]=false;
        for(int j=1; j < pLen; j++)
        {
            char c=*(p+j-1);
            if(c != '*')
                cur[j] = i>0 && pre[j-1] && (c=='.' || c==*(s+i-1));
            else
                cur[j] = (j>1 && cur[j-2]) || //two different situations: match zero or not zero;
                    (i>0 && pre[j] && (*(p+j-2)=='.' || *(p+j-2) == *(s+i-1)));
        }
        bool *t = pre; pre = cur, cur = t;
    }
    return pre[pLen-1];
}
