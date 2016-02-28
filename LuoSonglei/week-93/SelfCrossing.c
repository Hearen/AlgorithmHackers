/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-28 15:51
Description : 
Source      : https://leetcode.com/problems/self-crossing/
*******************************************/
#include <bool.h>
//AC - 0ms;
bool isSelfCrossing(int* x, int size)
{
    for(int i = 3; i < size; i++)
    {
        if(x[i]>=x[i-2] && x[i-1]<=x[i-3]) return true;
        if(i>=4 && x[i-1]==x[i-3] && x[i]+x[i-4]>=x[i-2]) return true;
        if(i>=5 && x[i-2]-x[i-4]>=0 && x[i]>=x[i-2]-x[i-4] && x[i-1]>=x[i-3]-x[i-5] && x[i-1]<=x[i-3]) return true;
    }
    return false;
}
