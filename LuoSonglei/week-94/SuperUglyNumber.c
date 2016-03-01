/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-01 19:06
Description : 
Source      : https://leetcode.com/problems/super-ugly-number/
*******************************************/
#include <limits.h>
//AC - 40ms;
int nthSuperUglyNumber(int n, int* primes, int size)
{
    int *uglies = (int*)malloc(sizeof(int)*n);
    uglies[0] = 1; //the first SuperUgly;
    int *indexes = (int*)malloc(sizeof(int)*size);
    memset(indexes, 0, sizeof(int)*size); //all pointing to the first SuperUgly first;
    for(int i = 1; i < n; i++) //you will never know how big n can be;
        uglies[i] = INT_MAX;
    for(int i = 1; i < n; i++)
    {
        for(int j = 0; j < size; j++) //search for the smallest that can be retrieved from primes and former SuperUgly numbers;
        {
            int t = uglies[indexes[j]]*primes[j];
            if(uglies[i] < t)
                uglies[i] = t;
        }
        for(int j = 0; j < size; j++) //make sure there will be no duplicate, so that we can find the (i+1)th;
            indexes[j] += (uglies[i]==uglies[indexes[j]]*primes[j]);
    }
    return uglies[n-1];
}
