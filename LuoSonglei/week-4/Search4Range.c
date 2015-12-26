/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-24 08:05
Description : 
Source      : https://leetcode.com/problems/search-for-a-range/
*******************************************/
//AC - 8ms;
int* searchRange0(int* nums, int numsSize, int target, int* returnSize)
{
    int l = -1, r = -1;
    int *indexes = (int*)malloc(sizeof(int) * 2);
    *returnSize = 2;
    for(int i = 0; i < numsSize; i++)
        if(nums[i] == target)
        {
            l = i;
            break;
        }
    for(int i = numsSize - 1; i > -1; i--)
        if(nums[i] == target)
        {
            r = i;
            break;
        }
    indexes[0] = l;
    indexes[1] = r;
    return indexes;
}

//AC - 4ms;
int* searchRange(int* nums, int numsSize, int target, int* returnSize)
{
    int l = -1, r = -1;
    int *indexes = (int*)malloc(sizeof(int) * 2);
    *returnSize = 2;
    int low = 0, high = numsSize - 1;
    int mid = 0;
    while(low <= high)
    {
        mid = (low + high) / 2;
        if(nums[mid] >= target)
        {
            high = mid - 1;
            if(nums[mid] == target)
                l = mid;
        }
        else 
            low = mid + 1;
    }
    low = 0, high = numsSize - 1;
    while(low <= high)
    {
        mid = (low + high) / 2;
        if(nums[mid] <= target)
        {
            low = mid + 1;
            if(nums[mid] == target)
                r = mid;
        }
        else 
            high = mid - 1;
    }
    indexes[0] = l;
    indexes[1] = r;
    return indexes;
}
