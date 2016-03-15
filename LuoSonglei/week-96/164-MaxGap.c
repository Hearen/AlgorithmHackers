/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-13 09:39
Description : Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Try to solve it in linear time/space.
Return 0 if the array contains less than 2 elements.
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Source      : https://leetcode.com/problems/maximum-gap/
*******************************************/
#define MIN(a, b) ((a) < (b) ? (a) : (b))
#define MAX(a, b) ((a) > (b) ? (a) : (b))
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

//AC - 8ms;
int maximumGap0(int* nums, int size) 
{
    sort(nums, 0, size-1);
    int max = 0;
    for(int i = 1; i < size; i++)
        if(nums[i]-nums[i-1] > max)
            max = nums[i]-nums[i-1];
    return max;

}

#include <limits.h>

int maximumGap(int* nums, int size)
{
    if(size < 2) return 0;
    int min=INT_MAX, max=0;
    for(int i = 0; i < size; i++)
    {
        if(nums[i] < min) min = nums[i];
        if(nums[i] > max) max = nums[i];
    }
    if(min == max) return 0; //some corner cases;
    if(min+1 == max) return 1;
    if(size == 2) return max-min;
    int gap = (max-min)/(size-1)+1; //make later index searching process easier but actually there will be also (max-min)/(size-1) numbers in each bucket;
    int** buckets = (int**)malloc(sizeof(int*)*size); //only store the min and max in the bucket;
    for(int i = 0; i < size; i++)
    {
        buckets[i] = (int*)malloc(sizeof(int)*2);
        buckets[i][0] = -1;
        buckets[i][1] = 0;
    }
    for(int i = 0; i < size; i++) //[min+k*gap, min+(k+1)*gap);
    {
        int k = (nums[i]-min)/gap; //get the index of the bucket;
        if(nums[i] > buckets[k][1]) //the greatest in the bucket;
            buckets[k][1] = nums[i];
        if(buckets[k][0]==-1 || nums[i]<buckets[k][0]) //store the minimal in the kth gap;
            buckets[k][0] = nums[i];
    }
    int start = buckets[0][1];
    int end = buckets[0][0];
    int maxGap = 1;
    for(int i = 0; i < size; i++)
    {
        if(buckets[i][0] > end) //move to the next bucket that has numbers since we initialize bucket with -1 and 0;
        {
            end = buckets[i][0]; //the end of the gap;
            if(end-start > maxGap)
                maxGap = end-start;
            start = buckets[i][1]; //move to the next start;
        }
    }
    return maxGap;
}
