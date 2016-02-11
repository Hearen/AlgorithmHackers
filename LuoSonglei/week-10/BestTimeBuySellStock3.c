/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 16:21
Description : 
Source      : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
*******************************************/
//AC - 4ms;
int maxProfit0(int* prices, int size)
{
    if(size <= 1)
        return 0;
    int *lProfits = (int*)malloc(sizeof(int)*size);
    int *rProfits = (int*)malloc(sizeof(int)*size);
    int min = prices[0];
    lProfits[0] = 0;
    for(int i = 1; i < size; i++)
    {
        if(prices[i] < min)
            min = prices[i];
        int t = prices[i] - min;
        lProfits[i] = (t < lProfits[i-1] ? lProfits[i-1] : t);
    }
    int max = prices[size-1];
    rProfits[size-1] = 0;
    for(int i = size-2; i > -1; i--)
    {
        if(prices[i] > max)
            max = prices[i];
        int t = max - prices[i];
        rProfits[i] = (t < rProfits[i+1]? rProfits[i+1] : t);
    }
    int profit = 0;
    for(int i = 0; i < size; i++)
    {
        int t = lProfits[i] + rProfits[i];
        if(t > profit)
            profit = t;
    }
    return lProfits[size-1] > profit ? lProfits[size-1] : profit;
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
