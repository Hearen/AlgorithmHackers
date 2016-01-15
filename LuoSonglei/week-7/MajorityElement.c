/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-15 08:24
Description : 
Source      : https://leetcode.com/problems/majority-element/ 
*******************************************/
void swap(int* p, int* q)
{
    int t = *p;
    *p = *q;
    *q = t;
}

void swiftSort(int* nums, int low, int high)
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
            l++, h--;
        }
    }
    if(h > low)
        swiftSort(nums, low, h);
    if(l < high)
        swiftSort(nums, l, high);
}
//AC - 16ms;
int majorityElement0(int* nums, int size)
{
    swiftSort(nums, 0, size-1);
    return nums[size/2];
}

//AC - 8ms;
//Boyer-Moore majority vote algorithm;
int majorityElement1(int* nums, int size)
{
    int majority = nums[0], count = 1;
    for(int i = 1; i < size; i++)
    {
        if(nums[i] == majority)
            count++;
        else if(nums[i] != majority && count > 0)
            count--;
        else
        {
            majority = nums[i];
            count = 1;
        }
    }
    return majority;
}
