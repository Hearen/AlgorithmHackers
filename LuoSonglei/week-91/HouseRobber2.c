/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-13 16:21
Description : 
Source      : https://leetcode.com/problems/house-robber-ii/
*******************************************/
int rob0(int* nums, int size)
{
    int *profits = (int*)malloc(sizeof(int)*(size+1));
    profits[0] = 0;
    for(int i = 0; i < size; i++)
    {
        int t;
        if(i)
        {
            t = profits[i];
            int profit = nums[i];
            if(i == 1 && profit > t)
                t = profit;
            else
            {
                profit += profits[i-1];
                if(profit > t)
                    t = profit;
            }
        }
        else
            t = nums[i];
        profits[i+1] = t;
    }
    return profits[size];
}

int rob1(int* nums, int size)
{
    if(size == 0)
        return 0;
    if(size == 1)
        return nums[0];
    int *profits = (int*)malloc(sizeof(int)*size);
    profits[0] = nums[0];
    profits[1] = nums[1] > nums[0] ? nums[1] : nums[0];
    for(int i = 2; i < size; i++)
    {
        int profit = profits[i-2] + nums[i];
        if(profits[i-1] > profit)
            profit = profits[i-1];
        profits[i] = profit;
    }
    return profits[size-1];
}

//AC - 0ms;
int rob(int* nums, int size)
{
    if(size == 0)
        return 0;
    if(size == 1)
        return nums[0];
    int profit0 = rob0(nums, size-1);
    int profit1 = rob0(nums+1, size-1);
    return profit0 > profit1? profit0 : profit1;
}
