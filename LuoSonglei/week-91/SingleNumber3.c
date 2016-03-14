/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-12 08:10
Description : 
Source      : https://leetcode.com/problems/single-number-iii/
*******************************************/
//AC - 4ms;
int* singleNumber(int* nums, int size, int* returnSize)
{
    *returnSize = 2;
    int *arr = (int*)malloc(sizeof(int)*2);
    memset(arr, 0, sizeof(int)*2);
    int ret = 0;
    for(int i = 0; i < size; i++) //get the xor-ed result of the two distincts;
        ret ^= nums[i];
    int splitter = ret & -ret; //find the first 'true' bit;
    for(int i = 0; i < size; i++)
    {
        if(splitter & nums[i])
            arr[0] ^= nums[i];
        else
            arr[1] ^= nums[i];
    }
    return arr;
}
