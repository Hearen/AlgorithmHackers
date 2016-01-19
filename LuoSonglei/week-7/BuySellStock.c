/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-18 17:17
Description : 
Source      : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*******************************************/
#include <limits.h>
//Time Limit Exceeded;
int maxProfit(int* prices, int size)
{
    int max = INT_MIN;
    for(int i = 0; i < size; i++)
    {
        for(int j = i+1; j < size; j++)
        {
            int gain = prices[j] - prices[i];
            if(gain > max)
                max = gain;
        }
    }
    return max;
}
