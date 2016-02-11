/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 17:15
Description : 
Source      : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
*******************************************/
//AC - 4ms;
#include <limits.h>
#define MAX(a, b) (a)>(b)? (a):(b)
int maxProfit(int k, int* prices, int size)
{
    if(size < 2)
        return 0;
    if(k > size/2)
    {
        int profit = 0;
        for(int i=1; i < size; i++)
            if(prices[i] > prices[i-1])
                profit += prices[i]-prices[i-1];
        return profit;
    }
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
