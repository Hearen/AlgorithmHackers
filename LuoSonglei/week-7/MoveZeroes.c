/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-12 08:48
Description : 
Source      : https://leetcode.com/problems/move-zeroes/
*******************************************/
//AC - 0ms;
void moveZeroes(int* nums, int size)
{
    int index = 0;
    for(int i = 0; i < size; i++)
        if(nums[i] != 0)
            nums[index++] = nums[i];
    while(index < size)
        nums[index++] = 0;
}
