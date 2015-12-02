#include<stdio.h>
#include"utils.h"
/*
 *Author: LHearen 
 *E-mail: LHearen@126.com 
 *Time: Tue Dec  1 08:26:45 CST 2015
 *Source: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
#define Size 10
bool search0(int *nums, int numsSize, target)
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
   bool resutl = search0(nums, sizeof(nums) / sizeof(int));
   printf("result %d", result);
}
