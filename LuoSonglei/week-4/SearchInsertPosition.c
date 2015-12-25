/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-25 07:52
Description : 
Source      : https://leetcode.com/problems/search-insert-position/
*******************************************/
//AC - 4ms;
int searchInsert0(int* nums, int numsSize, int target)
{
    int i = 0;
    while(i < numsSize)
    {
        if(nums[i++] >= target)
            break;
    }
    return (target > nums[i])? i : i-1;
}

//AC - 4ms;
int searchInsert1(int* nums, int numsSize, int target)
{
    int low = 0, high = numsSize - 1;
    int mid;
    while(low <= high)
    {
        mid = (low+high)/2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target)
            high = mid - 1;
        else 
            low = mid + 1;
    }
    return low;
}

