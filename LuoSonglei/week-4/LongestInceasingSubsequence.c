/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-26 19:34
Description : 
Source      : https://leetcode.com/problems/longest-increasing-subsequence/
*******************************************/
#include <stdbool.h>
//Handling the adjacent case - not inconsistent situation;
int lengthOfLIS0(int* nums, int numsSize)
{
    if(numsSize < 2)
        return numsSize;
    bool* flags = (bool*)malloc(sizeof(bool)*numsSize);
    int count = 0, max = 0;
    flags[0] = false;
    for(int i = 1; i < numsSize; i++)
        if(nums[i] > nums[i-1])
            flags[i] = true;
        else
            flags[i] = false;
    for(int i = 0; i < numsSize; i++)
    {
        if(flags[i])
            count++;
        else
            count = 0;
        if(count > max)
            max = count;
    }
    return max+1;
}

int lengOfLIS1(int* nums, int numsSize)
{
    
}
