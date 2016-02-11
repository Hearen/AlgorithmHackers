/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 21:07
Description : 
Source      : https://leetcode.com/problems/single-number-ii/
*******************************************/
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
