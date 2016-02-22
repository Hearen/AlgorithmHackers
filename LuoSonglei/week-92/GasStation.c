/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 20:42
Description : 
Source      : https://leetcode.com/problems/gas-station/
*******************************************/
//AC - 0ms;
//https://leetcode.com/discuss/87765/clean-simple-solution-well-explained-accepted-submission
int canCompleteCircuit(int* gas, int gSize, int* cost, int cSize)
{
    int index=-1, total=0, max=-1;
    for(int i = cSize-1; i > -1; i--)
    {
        total += gas[i]-cost[i];
        if(total > max)
        {
            index=i;
            max=total;
        }
    }
    return total < 0? -1 : index;
}

