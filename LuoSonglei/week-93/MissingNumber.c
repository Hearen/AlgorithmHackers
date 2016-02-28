/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-27 21:35
Description : 
Source      : https://leetcode.com/problems/missing-number/
*******************************************/
#include <bool.h>
//AC - 12ms - using O(n) space;
int missingNumber0(int* nums, int size)
{
    bool *arr = (int*)malloc(sizeof(bool)*(size+1));
    memset(arr, 0, sizeof(bool)*(size+1));
    for(int i = 0; i < size; i++)
        arr[nums[i]] = true;
    for(int i = 0; i <= size; i++)
        if(!arr[i])
            return i;
}

//AC - 12ms;
//a^a=0 and 0^b=b;
int missingNumber(int* nums, int size)
{
    int t = size;
    for(int i = 0; i < size; i++)
        t ^= nums[i]^i;
    return t;
}
