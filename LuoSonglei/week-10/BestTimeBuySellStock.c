/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 15:49
Description : 
Source      : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*******************************************/
//AC - 4ms;
int maxProfit(int *prices, int size)
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
