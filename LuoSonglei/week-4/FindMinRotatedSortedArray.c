/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-27 09:34
Description : 
Source      : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*******************************************/
#include <limits.h>
//AC - 0ms;
int findMin0(int* nums, int size)
{
    int min = INT_MAX;
    for(int i = 0; i < size; i++)
    {
        if(nums[i] < min)
            min = nums[i];
    }
    return min;
}

//AC - 0ms;
int findMin1(int* nums, int size)
{
    int low = 0, high = size-1;
    int mid;
    while(low <= high)
    {
        mid = (low+high) >> 1;
        if(nums[mid] > nums[high])
            low = mid+1;
        else
            high = mid;
    }
    return low;
}
