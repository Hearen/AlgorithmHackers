/*******************************************
    Author: LHearen
    E-mail: LHearen@126.com
    Time  :	2015-12-02 21:28
    Description: 
    Source: https://leetcode.com/problems/trapping-rain-water/
*******************************************/
#include<stdio.h>
//regular tests: [0,5,6,4,6,1,0,0,2,7]
//[2,0,2], [0,2,0], [4,2,1,4,3,2,4]
//60ms - traverse from the end - the left and right
//at the same time until tops meet in the middle;
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

//4ms - travesing from left to right and then
//reverse the direcition to collect the water;
int trap0(int *hArray, int size)
{
    int unitSum = 0;
    int sum = 0;
    int top = 0;
    for(int i = 0; i < size; i++)
    {
        //in case of re-calculating in the next section;
        if(top < hArray[i])
        {
            sum += unitSum;
            unitSum = 0;
            top = hArray[i];
        }
        else
            unitSum += top - hArray[i];
    }
    for(int j = size - 1; j > -1; j--)
    {
        if(top <= hArray[j])
        {
            sum += unitSum;
            unitSum = 0;
            top = hArray[j];
        }
        else
            unitSum += top - hArray[j];
    }
    return sum;
}
