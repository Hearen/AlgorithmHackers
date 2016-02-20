/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 20:42
Description : 
Source      : https://leetcode.com/problems/gas-station/
*******************************************/
int canCompleteCircuit(int* gas, int gSize, int* cost, int cSize)
{
    int left = 0;
    for(int i = 0; i < gSize; i++)
    {
        int j, count;
        for(j=0, count=i; j < cSize; j++, count++)
        {
            left += gas[count%gSize];
            left -= cost[j];
            if(left < 0)
                break;
        }
        if(j == cSize)
            return 1;
    }
    return -1;
}
