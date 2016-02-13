/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-12 15:02
Description : 
Source      : https://leetcode.com/problems/maximum-product-subarray/
*******************************************/
//AC - 4ms;
#define MAX(a, b) (a)>(b)? (a):(b)
#define MIN(a, b) (a)<(b)? (a):(b)
int maxProduct(int* nums, int size)
{
    int max = nums[0];
    for(int i=1, imax=max, imin=max; i < size; i++)
    {
        int t;
        if(nums[i] < 0)
            t = imax, imax = imin, imin = t;
        t = imax*nums[i];
        imax = MAX(nums[i], t);
        t = imin*nums[i];
        imin = MIN(nums[i], t);
        max = MAX(imax, max);
    }
    return max;
}
