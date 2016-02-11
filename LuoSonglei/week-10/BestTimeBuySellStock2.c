/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 15:52
Description : 
Source      : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*******************************************/
//AC - 4ms;
int maxProfit0(int* prices, int size)
{
    if(size == 0)
        return 0;
    int min = prices[0];
    int profit = 0;
    for(int i = 1; i < size; i++)
    {
        if(min > prices[i])
            min = prices[i];
        //Searching for the local min and max;
        if((i < size-1 && prices[i] > prices[i-1] && prices[i] >= prices[i+1])
                || (i==size-1 && prices[i] > prices[i-1]))
        {
            profit += prices[i]-min;
            if(i < size-1)//update the min searching for the next range;
                min = prices[i+1];
        }
    }
    return profit;
}

//AC - 4ms;
int maxProfit1(int* prices, int size)
{
    if(size <= 1)
        return 0;
    int profit = 0;
    for(int i = 1; i < size; i++)
    {
        if(prices[i] > prices[i-1])
            profit += prices[i]-prices[i-1];
    }
    return profit;
}

//AC - 4ms;
#include <limits.h>
#define MAX(a, b) (a)>(b)? (a):(b)
int maxProfit(int* prices, int size)
{
    int k = 2;
    int *holds = (int*)malloc(sizeof(int)*(k+1));
    int *solds = (int*)malloc(sizeof(int)*(k+1));
    memset(solds, 0, sizeof(int)*(k+1));
    for(int i = 0; i <= k; i++)
        holds[i] = INT_MIN;
    int cur = 0;
    for(int i=0; i < size; i++)
    {
        cur = prices[i];
        for(int j = k; j > 0; j--)
        {
            solds[j] = MAX(solds[j], holds[j]+cur);
            holds[j] = MAX(holds[j], solds[j-1]-cur);
        }
    }
    return solds[k];
}
