/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 20:16
Description : 
Source      : https://leetcode.com/problems/single-number/
*******************************************/
//AC - 8ms;
int singleNumber(int* nums, int size)
{
    if(size == 0)
        return 0;
    int ret = nums[0];
    for(int i=1; i < size; i++)
        ret ^= nums[i];
    return ret;
}
