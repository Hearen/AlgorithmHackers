/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-27 11:07
Description : 
Source      : https://leetcode.com/problems/find-peak-element/
*******************************************/
#include <limits.h>
//AC - 0ms;
int findPeakElement(int* nums, int numsSize)
{
    int pre = INT_MIN, post = INT_MIN;
    for(int i = 0; i < numsSize; i++)
    {
        if(i == 0)
            pre = INT_MIN;
        else
            pre = nums[i-1];
        if(i == numsSize-1)
            post = INT_MIN;
        else
            post = nums[i+1];
        if(nums[i] > pre && nums[i] > post)
            return i;
    }
    return 0;
}
