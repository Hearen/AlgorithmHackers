/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-13 12:01
Description : 
Source      : https://leetcode.com/problems/longest-increasing-subsequence/
*******************************************/
//AC - 28ms;
int lengthOfLIS(int* nums, int size)
{
    if(size < 2) return size;
    int *lens = (int*)malloc(sizeof(int)*(size+1));
    lens[0] = 0, lens[1] = 1;
    int max = 1;
    for(int i = 0; i < size; i++)
    {
        int t = 0;
        for(int j = i-1; j >= 0; j--)
            if(nums[i] > nums[j] && lens[j+1] > t)
                t = lens[j+1];
        lens[i+1] = t+1;
        if(lens[i+1] > max)
            max = lens[i+1];
    }
    return max;
}
