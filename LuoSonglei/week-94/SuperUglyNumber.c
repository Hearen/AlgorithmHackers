/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-01 19:06
Description : 
Source      : https://leetcode.com/problems/super-ugly-number/
*******************************************/
#include <stdlib.h>
#define MIN(a, b) ((a) < (b) ? (a) : (b))
int nthSuperUglyNumber(int n, int* primes, int size)
{
    int *indexes = (int*)malloc(sizeof(int)*size);
    memset(indexes, 0, sizeof(int)*size);
    int *uglies = (int*)malloc(sizeof(int)*n);
    uglies[0] = 1;
    for(int i = 1; i < n; i++)
        uglies[i] = INT_MAX;
    for(int i = 1; i < n; i++)
    {
        for(int j = 0; j < size; j++)
            uglies[i] = MIN(uglies[i], uglies[indexes[j]]*primes[j]);
        for(int j = 0; j < size; j++)
            indexes[j] += (uglies[i]==uglies[indexes[j]]*primes[j]);
    }
    return uglies[n-1];
}
