/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-07 08:24
Description : Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
Source      : https://leetcode.com/problems/kth-largest-element-in-an-array/
*******************************************/
#include <stdbool.h>
#include <stdio.h>
void swap(int* p, int* q)
{
    int t=*p; *p=*q; *q=t;
}

int partition(int* nums, int begin, int end)
{
    int l=begin, r=end;
    int m = (l+r)/2;
    int mid = nums[m];
    swap(nums+m, nums+l);
    l++;
    while(l <= r)
    {
        while(nums[r] > mid) r--;
        while(l<=r && nums[l]<mid) l++;
        if(l <= r)
        {
            swap(nums+l, nums+r);
            l++; r--;
        }
    }
    swap(nums+begin, nums+r);
    return r;
}

//AC - 4ms;
int findKthLargest(int* nums, int size, int k)
{
    k = size-k;
    int begin = 0; 
    int end = size-1;
    while(true)
    {
        int position = partition(nums, begin, end);
        if(position == k) return nums[k];
        if(position > k) end = position-1;
        else begin = position+1;
    }
}

int main(void)
{
    int nums[] = { 3,2,1,5,6,4 };
    int k;
    scanf("%d", &k);
    int ret = findKthLargest(nums, sizeof(nums)/sizeof(int), k);
    printf("result: %d\n", ret);
    return 0;
}
