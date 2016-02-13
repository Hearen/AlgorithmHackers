/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-12 14:49
Description : 
Source      : https://leetcode.com/problems/maximum-subarray/
*******************************************/
#include <limits.h>
//AC - 4ms;
int maxSubArray(int* nums, int size)
{
    int sum = 0;
    int max = INT_MIN;
    for(int i = 0; i < size; i++)
    {
        if(sum >= 0)
            sum += nums[i];
        else
            sum = nums[i];
        if(sum > max)
            max = sum;
    }
    return max;
}
