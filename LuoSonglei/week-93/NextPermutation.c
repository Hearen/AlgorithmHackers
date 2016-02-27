/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-27 10:03
Description : 
Source      : https://leetcode.com/problems/next-permutation/
*******************************************/
void swap(int* p, int* q)
{
    int t = *p;
    *p = *q;
    *q = t;
}
void reverse(int* nums, int begin, int end)
{
    for(int i = begin; i < (begin+end+1)/2; i++)
        swap(nums+i, nums+end+begin-i);
}
void nextPermutation(int* nums, int size)
{
    int i=size-1, j=size-1;
    while(i>0 && nums[i]<=nums[i-1]) i--;
    if(i==0)
    {
        reverse(nums, 0, size-1);
        return ;
    }
    while(nums[j] <= nums[i-1]) j--;
    swap(nums+j, nums+i-1);
    reverse(nums, i, size-1);
}
