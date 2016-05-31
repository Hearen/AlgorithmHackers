/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : Tue, 31 May 2016 08:54 CST
Description : Given a non-empty array of integers, return the k most frequent elements.
For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
Source      : https://leetcode.com/problems/top-k-frequent-elements/
*******************************************/
void swap(int* p, int* q)
{
    int t=*p; *p=*q; *q=t;
}

//Sort the array nums and keep its indexes along with it;
void sort(int* nums, int* indexes, int begin, int end)
{
    int l=begin, r=end;
    int v = nums[l+(r-l)/2];
    while(l <= r)
    {
        while(nums[l] < v) l++;
        while(nums[r] > v) r--;
        if(l <= r) 
        {
            swap(indexes+l, indexes+r);
            swap(nums+l++, nums+r--);
        }
    }
    if(begin < r)
        sort(nums, indexes, begin, r);
    if(l < end)
        sort(nums, indexes, l, end);
}

//AC - 24ms;
int* topKFrequent(int* nums, int size, int k, int* returnSize)
{
    int* indexes = (int*)malloc(sizeof(int)*size);
    int* arr = (int*)malloc(sizeof(int)*size); //used to count and also be used as return array;
    sort(nums, arr, 0, size-1); //arr here is used for parameter position-taker, nothing more;
    int top = -1;
    for(int i = 0; i < size; i++) //count elements, recording its first index and frequency;
    {
        if(top==-1 || nums[indexes[top]]!=nums[i])
        {
            indexes[++top] = i;
            arr[top] = 1;
        }
        else arr[top]++;
    }
    sort(arr, indexes, 0, top); //make the frequency array arr in ascending order;
    for(int i = 0; i < k; i++) //collect the first k most frequent elements;
        arr[i] = nums[indexes[top-i]];
    *returnSize = k;
    return arr;
}
