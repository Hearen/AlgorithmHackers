/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-09 14:52
Description : Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
Source      : https://leetcode.com/problems/wiggle-sort-ii/
*******************************************/
void swap(int* p, int* q)
{
    int t=*p; *p=*q; *q=t;
}

void sort(int* nums, int begin, int end)
{
    int l=begin, r=end;
    int v = nums[l+(r-l)/2];
    while(l <= r)
    {
        while(nums[l] < v) l++;
        while(nums[r] > v) r--;
        if(l <= r)
        {
            swap(nums+l, nums+r);
            l++; r--;
        }
    }
    if(begin < r)
        sort(nums, begin, r);
    if(l < end)
        sort(nums, l, end);
}

//AC - 40ms;
void wiggleSort(int* nums, int size)
{
    sort(nums, 0, size-1);
    int *arr = (int*)malloc(sizeof(int)*size);
    for(int i = 0; i < size; i++)
        arr[i] = nums[i];
    int small=(size-1)/2;
    int big = size-1;
    int index = size-1;
    if(size%2 == 0)
        nums[index--] = arr[big--];
    while(index > -1)
    {
        nums[index--] = arr[small--];
        if(index > -1)
            nums[index--] = arr[big--];
    }
}
