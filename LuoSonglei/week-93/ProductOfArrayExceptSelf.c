/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-26 15:34
Description : 
Source      : https://leetcode.com/problems/product-of-array-except-self/
*******************************************/
int* productExceptSelf(int* nums, int size, int* returnSize)
{
    int* arr = (int*)malloc(sizeof(int)*size);
    arr[0] = arr[size-1] = 1;
    for(int i = 1; i < size; i++)
        arr[i] = arr[i-1] * nums[i-1];
    int t = nums[size-1];
    for(int i = size-2; i > -1; i--)
    {
        arr[i] *= t;
        t *= nums[i];
    }
    *returnSize = size;
    return arr;
}
