/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-14 20:42
Description : 
Source      : https://leetcode.com/problems/count-of-range-sum/
*******************************************/
#include <limits.h>
void swap(long*p, long*q)
{
    long t = *p;
    *p = *q;
    *q = t;
}

void swiftSort(long* arr, int low, int high)
{
    int l = low, r = high;
    long v = arr[l+(r-l)/2];
    while(l <= r)
    {
        while(arr[l] < v) l++;
        while(arr[r] > v) r--;
        if(l <= r)
        {
            swap(arr+l, arr+r);
            l++, r--;
        }
    }
    if(r > low)
        swiftSort(arr, low, r);
    if(l < high)
        swiftSort(arr, l, high);
}

int indexOf(long* arr, int size, double a)
{
    int l = 0, r = size-1, m;
    while(l <= r)
    {
        m = l + (r-l)/2;
        arr[m] <= a? (l=m+1) : (r=m-1);
    }
    return l;
}

int counter(long* nums, int l, int h, int low, int high)
{
    if(h == l)
        return (nums[l] >= low && nums[l] <= high)? 1:0;
    int m = l + (h-l)/2;
    int count = 0;
    int tmpSize = h-m;
    long *arr = (long*)malloc(sizeof(long)*tmpSize);
    long sum = 0;
    for(int i = m+1; i <= h; i++)
    {
        sum += nums[i];
        arr[i-m-1] = sum;
    }
    swiftSort(arr, 0, tmpSize-1);
    sum = 0;
    for(int i = m; i >= l; i--)
    {
        sum += nums[i];
        count += indexOf(arr, tmpSize, high-sum+0.5) - indexOf(arr, tmpSize, low-sum-0.5);
    }
    return counter(nums, l, m, low, high) + counter(nums, m+1, h, low, high) + count;
}

//AC - 72ms;
int countRangeSum(int* nums, int size, int low, int high)
{
    if(size == 0)
        return 0;
    long *a = (long*)malloc(sizeof(long)*size);
    for(int i = 0; i < size; i++)
        nums[i] == INT_MIN? (a[i] = -1*INT_MIN) : (a[i] = nums[i]);
    return counter(a, 0, size-1, low, high);
}
