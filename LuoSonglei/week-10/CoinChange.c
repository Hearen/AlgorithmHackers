/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-13 15:05
Description : 
Source      : https://leetcode.com/problems/coin-change/
*******************************************/
//AC - 44ms;
int coinChange(int* coins, int size, int amount)
{
    int *mins = (int*)malloc(sizeof(int)*(amount+1));
    mins[0] = 0;
    for(int i = 1; i <= amount; i++)
    {
        int min = -1;
        for(int j = 0; j < size; j++)
        {
            int t =  i-coins[j];
            if(t >= 0 && mins[t] != -1)
            {
                if(min == -1)
                    min = mins[t]+1;
                else if(mins[t]+1 < min)
                    min = mins[t]+1;
            }
        }
        mins[i] = min;
    }
    return mins[amount];
}
