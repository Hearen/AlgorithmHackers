/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-25 11:15
Description : 
Source      : https://leetcode.com/problems/rotate-array/
*******************************************/
void rotate0(int* nums, int size)
{
    for(int i = 0; i < size/2; i++)
    {
        int t = nums[i];
        nums[i] = nums[size-i-1];
        nums[size-i-1] = t;
    }
}
//AC - 8ms;
void rotate(int* nums, int size, int k)
{
    k %= size;
    rotate0(nums, size);
    rotate0(nums, k);
    rotate0(nums+k, size-k);
}
