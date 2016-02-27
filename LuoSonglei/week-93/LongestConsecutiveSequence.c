/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-27 11:03
Description : 
Source      : https://leetcode.com/problems/longest-consecutive-sequence/
*******************************************/
void sort(int* nums, int begin, int end)
{
    int l=begin, r=end;
    int v = nums[l+(r-l)/2];
    while(l <= r)
    {
        while(nums[l] < v) l++;
        while(nums[r] > v) r--;
        if(l <= r)
        {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++; r--;
        }
    }
    if(begin < r)
         sort(nums, begin, r);
    if(l < end)
        sort(nums, l, end);
}

//AC - 4ms;
int longestConsecutive(int* nums, int size)
{
    sort(nums, 0, size-1);
    int max = 1;
    int count = 1;
    for(int i = 1; i < size; i++)
    {
        if(nums[i] == nums[i-1]) continue; //just ignore the equivalent elements;
        if(nums[i] == nums[i-1]+1) count++;
        else  //there is a gap - nonconsecutive;
        {
            max = max > count? max : count;
            count = 1; //reset counter;
        }
    }
    max = max > count? max : count; //collect the last section;
    return max;
}
