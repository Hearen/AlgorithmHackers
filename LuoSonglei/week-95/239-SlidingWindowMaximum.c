/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-11 22:47
Description : Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
Source      : https://leetcode.com/problems/sliding-window-maximum/
*******************************************/
//AC - 40ms;
int* maxSlidingWindow(int* nums, int size, int k, int* returnSize)
{
    *returnSize = 0;
    int* arr = (int*)malloc(sizeof(int)*(size-k+1));
    int* queue = (int*)malloc(sizeof(int)*size);
    int begin=0, end=-1;
    for(int i = 0; i < size; i++)
    {
        if(end-begin>-1 && queue[begin]==i-k)
            begin++;
        while(end-begin>-1 && nums[queue[end]]<nums[i])
            end--;
        queue[++end] = i;
        if(i >= k-1)
        {
            *returnSize += 1;
            arr[*returnSize-1] = nums[queue[begin]];
        }
    }
    return arr;
}
