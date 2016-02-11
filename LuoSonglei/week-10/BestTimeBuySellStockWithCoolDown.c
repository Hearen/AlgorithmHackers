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
    int buy0 = INT_MIN, buy1 = INT_MIN;
    int sell0 = 0, sell1 = 0;
    for(int i = 0; i < size; i++)
    {
        buy0 = buy1;
        buy1 = MAX(sell0-prices[i], buy1);
        sell0 = sell1;
        sell1 = MAX(buy0+prices[i], sell1);
    }
    return sell1;
}
