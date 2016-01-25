/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-22 16:47
Description : 
Source      : https://leetcode.com/problems/house-robber/
*******************************************/
//AC - 0ms;
int rob(int* nums, int size)
{
    if(size == 0)
        return 0;
    if(size == 1)
        return nums[0];
    int *arr = (int*)malloc(sizeof(int)*size);
    arr[0] = nums[0];
    if(nums[1] > nums[0])
        arr[1] = nums[1];
    else
        arr[1] = nums[0];
    for(int i = 2; i < size; i++)
    {
        int count = arr[i-2]+nums[i];
        if(count < arr[i-1])
            count = arr[i-1];
        arr[i] = count;
    }
    return arr[size-1];
}
