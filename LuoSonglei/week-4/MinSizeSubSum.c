/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-25 15:40
Description : 
Source      : https://leetcode.com/problems/minimum-size-subarray-sum/
*******************************************/
//AC - 136ms;
int minSubArrayLen(int s, int* nums, int numsSize)
{
    int* sums = (int*)malloc(sizeof(int) * (numsSize+1));
    sums[0] = 0;
    for(int i = 0; i < numsSize; i++)
        sums[i+1] = nums[i];
    for(int i = 0; i < numsSize; i++)
        sums[i+1] += sums[i];
    int len = 0, min = numsSize; 
    for(int i = 0; i < numsSize; i++)
    {
        for(int j = i+1; j < numsSize+1; j++)
        {
            if(j - i > min) // added will result in 104ms;
                break;
            if(sums[j] - sums[i] >= s)
            {
                len = j - i;
                break;
            }
        }
        if(len < min)
            min = len;
    }
    return min;
}
