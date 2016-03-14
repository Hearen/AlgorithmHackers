/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-08 16:38
Description : Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
Source      : https://leetcode.com/problems/increasing-triplet-subsequence/
*******************************************/
#include <cstdbool.h>
//AC - 4ms;
bool increasingTriplet(int* nums, int size)
{
    int first = INT_MAX;
    int second = INT_MAX;
    for(int i = 0; i < size; i++)
    {
        if(nums[i] <= first)
            first = nums[i];
        else if(nums[i] <= second)
            second = nums[i];
        else return true;
    }
    return false;
}
