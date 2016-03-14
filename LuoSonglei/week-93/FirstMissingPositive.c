/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-27 16:43
Description : 
Source      : https://leetcode.com/problems/first-missing-positive/
*******************************************/
void swap(int* p, int* q)
{
    int t=*p; *p=*q; *q=t;
}

//AC - 0ms;
int firstMissingPositive(int* nums, int size)
{
    for(int i = 0; i < size; i++)
        while(nums[i]>0 && nums[i]<=size && nums[nums[i]-1]!=nums[i])
            swap(nums+i, nums+nums[i]-1);
    for(int i = 0; i < size; i++)
        if(nums[i] != i+1)
            return i+1;
    return size+1;
}
