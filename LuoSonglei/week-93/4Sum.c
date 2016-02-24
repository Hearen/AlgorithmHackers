/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-24 09:45
Description : 
Source      : https://leetcode.com/problems/4sum/
*******************************************/
void sort(int* nums, int begin, int end)
{
    int l = begin;
    int r = end;
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

//AC - 28ms;
int** fourSum(int* nums, int size, int target, int* returnSize)
{
    sort(nums, 0, size-1);
    int** arr = (int**)malloc(sizeof(int*));
    *returnSize = 0;
    for(int i = 0; i < size-3; i++)
    {
        if(i && nums[i]==nums[i-1]) continue;
        int t0 = target-nums[i]; //target for 3Sum;
        for(int j = i+1; j < size-2; j++)
        {
            if(j!=i+1 && nums[j]==nums[j-1]) continue; //the start position should be handled carefully, it's i+1 while removing redundancy;
            int t1 = t0-nums[j]; //target for 2Sum;
            if(nums[j+1]+nums[j+2] > t1) break;
            if(nums[size-1]+nums[size-2] < t1) continue;
            int l = j+1;
            int r = size-1;
            while(l < r) //2Sum problem;
            {
                int t2 = nums[l]+nums[r];
                if(t1 > t2) l++;
                else if(t1 < t2) r--;
                else
                {
                    if(!*returnSize || (*returnSize && (nums[i]!=arr[*returnSize-1][0]
                                    || nums[j]!=arr[*returnSize-1][1]
                                    || nums[l]!=arr[*returnSize-1][2])))
                    {
                        *returnSize += 1;
                        arr = (int**)realloc(arr, sizeof(int*)*(*returnSize));
                        arr[*returnSize-1] = (int*)malloc(sizeof(int)*4);
                        arr[*returnSize-1][0] = nums[i];
                        arr[*returnSize-1][1] = nums[j];
                        arr[*returnSize-1][2] = nums[l];
                        arr[*returnSize-1][3] = nums[r];
                    }
                    l++;
                }
            }
        }
    }
    return arr;
}
