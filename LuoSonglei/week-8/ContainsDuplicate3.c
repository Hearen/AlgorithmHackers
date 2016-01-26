/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-21 09:09
Description : 
Source      : https://leetcode.com/problems/contains-duplicate-iii/
*******************************************/
#include <math.h>
#include <stdbool.h>
//Timi Limit Exceeded;
bool containsNearbyAlmostDuplicate0(int* nums, int size, int k, int t)
{
    for(int i = 0; i < size; i++)
        for(int j = i+1; j < i+k+1 && j < size; j++)
        {
            long d = (long)nums[i]-(long)nums[j];
            if(d <= t && d >= -1*t)
                return true;
        }
    return false;
}

void swap(int *p, int *q)
{
    int t = *p; 
    *p = *q;
    *q = t;
}

void sort(int* nums, int* indexes, int low, int high)
{
    int l = low, h = high;
    int v = nums[l+(h-l)/2];
    while(l <= h)
    {
        while(nums[l] < v) l++;
        while(nums[h] > v) h--;
        if(l <= h)
        {
            swap(nums+l, nums+h);
            swap(indexes+l, indexes+h);
            l++, h--;
        }
    }
    if(h > low)
        sort(nums, indexes, low, h);
    if(l < high)
        sort(nums, indexes, l, high);
}

//AC - 8ms;
bool containsNearbyAlmostDuplicate1(int* nums, int size, int k, int t)
{
    int *indexes = (int*)malloc(sizeof(int)*size);
    for(int i = 0; i < size; i++)
        indexes[i] = i;
    sort(nums, indexes, 0, size-1);
    for(int i = 0; i < size; i++)
    {
        int top = nums[i]+t;
        for(int j = i+1; j < size && nums[j] <= top; j++)
            if(abs(indexes[i] - indexes[j]) <= k)
                return true;
    }
    return false;
}
