/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 15:49
Description : 
Source      : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*******************************************/
//AC - 4ms;
int maxProfit0(int *prices, int size)
{
    if(size == 0)
        return 0;
    int min = prices[0];
    int profit = 0;
    for(int i = 0; i < size; i++)
    {
        if(prices[i] < min)
            min = prices[i];
        int t = prices[i] - min;
        if(t > profit)
            profit = t;
    }
    return profit;
}

//AC - 4ms;
int maxProfit(int *prices, int size)
{
    if(size <= 1)
        return 0;
    int *profits = (int)malloc(sizeof(int)*size);
    profits[0] = 0;
    int min = prices[0];
    for(int i = 1; i < size; i++)
    {
        if(prices[i] < min)
            min = prices[i];
        int t = prices[i] - min;
        profits[i] = (t < profits[i-1] ? profits[i-1] : t);
    }
    return profits[size-1];
}
