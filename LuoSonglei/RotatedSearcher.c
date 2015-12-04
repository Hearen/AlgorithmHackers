/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-02 21:30
Description: 
Source: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
*******************************************/
#include"utils.h"
//before finding a robust enough and terse solution
//I think this naive but robust one is good enough;
#define Size 10
bool search0(int *nums, int numsSize, int target)
{
    for(int i = 0; i < numsSize; i++)
    {
        if(target == nums[i])
            return true;
    }
    return false;
}

void main()
{
   int nums[] = {4, 5, 6, 7, 0, 1, 2};
   bool result = search0(nums, sizeof(nums) / sizeof(int), 9);
   printf("result %d", result);
}
