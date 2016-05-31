/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : Tue, 31 May 2016 07:55 CST
Description : Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Source      : https://leetcode.com/problems/intersection-of-two-arrays-ii/
*******************************************/
void swap(int* p, int* q)
{
    int t=*p; *p=*q; *q=t;
}

//Quick sort;
void sort(int* nums, int begin, int end)
{
    int l = begin, r = end;
    int v = nums[l+(r-l)/2];
    while(l <= r)
    {
        while(nums[l] < v) l++;
        while(nums[r] > v) r--;
        if(l <= r)
        {
            swap(nums+l, nums+r);
            l++, r--;
        }
    }
    if(begin < r)
        sort(nums, begin, r);
    if(l < end)
        sort(nums, l, end);
}

//AC - 4ms;
int* intersect(int* nums1, int size1, int* nums2, int size2, int* returnSize)
{
    int size = size1>size2? size2:size1;
    int* arr = (int*)malloc(sizeof(int)*size);
    int top = -1;
    int i=0, j=0;
    while(i<size1 && j<size2)
    {
        if(nums1[i] < nums2[j]) i++;
        else if(nums1[i] > nums2[j]) j++;
        else
        {
            arr[++top] = nums1[i];
            i++, j++;
        }
    }
    *returnSize = top+1;
    return arr;
}
