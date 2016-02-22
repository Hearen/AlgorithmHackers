/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-22 20:00
Description : 
Source      : https://leetcode.com/problems/patching-array/
*******************************************/
//AC - 4ms;
int minPatches(int* nums, int size, int n)
{
    int count=0, index=0;
    long long top = 0;
    while(top < n)
    {
        if(index<size && nums[index]<=(top+1))
            top += nums[index++];
        else
        {
            count++;
            top = 2*top+1;
        }
    }
    return count;
}
