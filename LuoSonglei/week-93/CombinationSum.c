/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-25 11:31
Description : 
Source      : https://leetcode.com/problems/combination-sum/
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
            l++;
            r--;
        }
    }
    if(begin < r)
        sort(nums, begin, r);
    if(l < end)
        sort(nums, l, end);
}

void helper(int* nums, int size, int target, int* stack, int top, int*** arr, int** colSizes, int* returnSize)
{
    if(target < 0) return ;
    if(target == 0)
    {
        *returnSize += 1;
        *colSizes = (int*)realloc(*colSizes, sizeof(int)*(*returnSize));
        (*colSizes)[*returnSize-1] = top+1;
        *arr = (int**)realloc(*arr, sizeof(int*)*(*returnSize));
        (*arr)[*returnSize-1] = (int*)malloc(sizeof(int)*(top+1));
        for(int i = 0; i <= top; i++)
            (*arr)[*returnSize-1][i] = stack[i];
        return ;
    }
    for(int i = 0; i < size; i++)
    {
        if(nums[i]>=stack[top])
        {
            stack[top+1] = nums[i];
            helper(nums, size, target-nums[i], stack, top+1, arr, colSizes, returnSize);
        }
    }
}

//AC - 8ms;
int** combinationSum(int* nums, int size, int target, int** colSizes, int* returnSize)
{
    sort(nums, 0, size-1);
    int** arr = (int**)malloc(sizeof(int*));
    *returnSize = 0;
    int* stack = (int*)malloc(sizeof(int)*(target/nums[0]+1));
    int top = -1;
    for(int i = 0; i < size; i++)
    {
        stack[top+1] = nums[i];
        helper(nums, size, target-nums[i], stack, top+1, &arr, colSizes, returnSize);
    }
    return arr;
}
