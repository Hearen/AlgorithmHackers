/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 21:07
Description : 
Source      : https://leetcode.com/problems/single-number-ii/
*******************************************/
//AC - 8ms;
//direct method - calculate each bit and find the single one;
int singleNumber0(int* nums, int size)
{
    int b, ret = 0;
    int len = sizeof(int)*8;
    for(int i = 0; i < len; i++)
    {
        b = 1 << i;
        int count = 0;
        for(int j = 0; j < size; j++)
            if(b & nums[j])
                count++;
        if(count%3)
            ret |= b;
    }
    return ret;
}
//AC - 4ms;
//inspired by logical circuit design and boolean algebra;
//counter - unit of 3;
int singleNumber(int* nums, int size)
{
    int one = 0, two = 0;
    for(int i = 0; i < size; i++)
    {
        one = (one ^ nums[i]) & ~two;
        two = (two ^ nums[i]) & ~one;
    }
    return one;
}
