#include<stdio.h>
/*
 *Author: LHearen 
 *E-mail: LHearen@126.com 
 *Time: Tue Dec  1 08:26:45 CST 2015
 *Source: https://leetcode.com/problems/trapping-rain-water/
 */
//regular tests: [0,5,6,4,6,1,0,0,2,7]
//[2,0,2], [0,2,0], [4,2,1,4,3,2,4]
int trap(int *hArray, int size)
{
    int lUnitSum = 0;
    int rUnitSum = 0;
    int sum = 0;
    int i = 0;
    int j = size - 1;
    int ltop = i;
    int rtop = j;
    while(1)
    {
        for(; i < size; i++)
        {
            if(hArray[ltop] < hArray[i])
            {
                ltop = i;
                sum += lUnitSum;
                lUnitSum = 0;
                break;
            }
            else
            {
                lUnitSum += hArray[ltop] - hArray[i];
            }
        }
        for(; j >= i; j--)
        {
            if(hArray[rtop] <= hArray[j] && rtop != j)
            {
                rtop = j;
                sum += rUnitSum;
                rUnitSum = 0;
                break;
            }
            else
            {
                rUnitSum += hArray[rtop] - hArray[j];
            }
        }
        if(ltop >= rtop)
            break;
    }
}
