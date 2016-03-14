/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 08:08
Description : 
Source      : https://leetcode.com/problems/remove-element/
*******************************************/
//AC - 0ms;
int removeElement(int* nums, int size, int val)
{
    int l = 0, r = size-1;
    while(l <= r)
    {
        while(l <= r && nums[l] != val) l++;
        while(nums[r] == val) r--;
        if(l < r)
        {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            r--;
        }
    }
    return l;
}
