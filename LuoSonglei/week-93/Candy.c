/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-22 09:43
Description : 
Source      : https://leetcode.com/problems/candy/
*******************************************/
#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a) : (b))
//AC - 16ms;
int candy(int* ratings, int size)
{
    if(!size) return 0;
    int* limits = (int*)malloc(sizeof(int)*size);
    limits[size-1] = 1;
    for(int i = size-2; i >-1; i--) //from right to left;
        if(ratings[i] > ratings[i+1]) limits[i] = limits[i+1]+1;
        else limits[i] = 1;
    int sum = limits[0];
    for(int i = 1; i < size; i++) //from left to right and collect the results;
    {
        if(ratings[i] > ratings[i-1]) limits[i] = MAX(limits[i], limits[i-1]+1);
        else limits[i] = MIN(limits[i-1]-1, limits[i]);
        sum += limits[i];
    }
    return sum;
}
