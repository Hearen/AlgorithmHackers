/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-27 22:19
Description : 
Source      : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
*******************************************/
//AC - 4ms;
int findMin(int* nums, int size)
{
    if(size == 1) return nums[0];
    int mid = size/2;
    if(nums[mid] > nums[size-1]) return findMin(nums+mid+1, size-mid-1); //the condition itself can ensure the nums+mid+1 will be valid and as a result the size-mid-1 will be bigger than 1;
    else if(nums[mid] < nums[size-1]) return findMin(nums, mid+1); //the second parameter is size, so to cover nums+mid the size will be mid+1;
    else
    {
        int l = findMin(nums, mid);
        int r = findMin(nums+mid, size-mid); //there is no condition like above situation;
        return l > r? r : l;
    }
}
