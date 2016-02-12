/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-11 21:39
Description : 
Source      : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
*******************************************/
#include <limits.h>
//AC - 4ms;
//https://leetcode.com/discuss/71354/share-my-thinking-process
#define MAX(a, b) (a)>(b)? (a):(b)
int maxProfit(int* prices, int size)
{
    int preBuy = INT_MIN, curBuy = INT_MIN;
    int preSell = 0, curSell = 0;
    for(int i = 0; i < size; i++)
    {
        curBuy = MAX(preBuy, preSell-prices[i]);
        preBuy = curBuy;
        preSell = curSell;
        curSell = MAX(curSell, preBuy+prices[i]);
    }
    return curSell;
}
