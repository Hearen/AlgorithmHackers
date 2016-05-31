/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : Tue, 24 May 2016 20:49 CST
Description : Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note:
Each element in the result must be unique.
The result can be in any order.
Source      : https://leetcode.com/problems/intersection-of-two-arrays/
*******************************************/
//AC - 12ms;
#define MIN(a, b) ((a) < (b) ? (a) : (b))
int* intersection0(int* nums1, int size1, int* nums2, int size2, int* returnSize)
{
    int size = MIN(size1, size2);
    int *arr = (int*)malloc(sizeof(int)*(size));
    int top = -1;
    for(int i = 0; i < size1; i++) //check each element in nums1;
    {
        int j = 0;
        for(; j < size2; j++) //check whether the nums[i] in array nums2;
            if(nums1[i] == nums2[j]) break;
        if(j < size2)
        {
            j = 0;
            for(; j <= top; j++) //avoid duplicate;
                if(arr[j] == arr[i]) break;
            if(j > top)
                arr[++top] = arr[i];
        }
    }
    *returnSize = top+1;
    return arr;
}

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

//AC - 4ms - using two pointers;
int* intersection(int* nums1, int size1, int* nums2, int size2, int* returnSize)
{
    sort(nums1, 0, size1-1);
    sort(nums2, 0, size2-1);
    int size = MIN(size1, size2);
    int* arr = (int*)malloc(sizeof(int)*size); //the size of the result will at most be size;
    int top = -1;
    int p1=0, p2=0;
    while(p1<size1 && p2<size2)
    {
        if(nums1[p1] > nums2[p2]) p2++;
        else if(nums1[p1] < nums2[p2]) p1++;
        else //only collect the equal one;
        {
            if(top==-1 || arr[top]!=nums1[p1])  //avoid duplicates;
                arr[++top] = nums1[p1];
            p1++, p2++;
        }
    }
    *returnSize = top+1;
    return arr;
}
