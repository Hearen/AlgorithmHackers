/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 20:56
Description : 
Source      : https://leetcode.com/problems/jump-game/
*******************************************/
#include <stdbool.h>
bool canJump(int* nums, int size)
{
    bool* jumpable = (bool*)malloc(sizeof(bool)*size);
    memset(jumpable, 0, sizeof(bool)*size);
    for(int i = size-1; i > -1; i--)
    {
        int len = nums[i];
        for(int j = 1; j <= len; j++)
        {
            if(i+j >= size) jumpable[i] = true;
            else if(jumpable[i+j]) jumpable[i] = true;
        }
    }
    return jumpable[0];
}
