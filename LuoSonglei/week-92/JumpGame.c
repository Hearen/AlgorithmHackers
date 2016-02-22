/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 20:56
Description : 
Source      : https://leetcode.com/problems/jump-game/
*******************************************/
#include <stdbool.h>
//TLE;
bool canJump0(int* nums, int size)
{
    bool* jumpable = (bool*)malloc(sizeof(bool)*size);
    memset(jumpable, 0, sizeof(bool)*size);
    for(int i = size-1; i > -1; i--)
    {
        int len = nums[i];
        for(int j = 1; j <= len; j++)
        {
            if(i+j >= size) jumpable[i] = true;
            else if(jumpable[i+j]) 
            {
                jumpable[i] = true;    
                break;
            }
        }
    }
    return jumpable[0];
}

//AC - 4ms;
bool canJump1(int* nums, int size)
{
    if(size < 2) return true;
    for(int cur=size-2; cur > -1; cur--)
    {
        if(nums[cur] == 0)
        {
            int len = 1;
            while(len > nums[cur])
            {
                len++;
                cur--;
                if(cur < 0) return false;
            }
        }
    }
    return true;
}

//AC - 4ms;
bool canJump(int* nums, int size)
{
    int max = 0;
    for(int i = 0; i < size; i++, max--)
    {
        max = max > nums[i]? max : nums[i];
        if(max<1 && i!=size-1) return false;
    }
    return true;
}
