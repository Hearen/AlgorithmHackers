/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-09 16:38
Description : Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
Source      : https://leetcode.com/problems/range-sum-query-mutable/
*******************************************/
#include <stdlib.h>
struct NumArray
{
    int **arrs;
    int *sums;
    int unitSize;
    int unitAmount;
};

struct NumArray* NumArrayCreate(int *nums, int size)
{
    if(!size) return NULL;
    /*printf("creating\n");*/
    struct NumArray *t = (struct NumArray*)malloc(sizeof(struct NumArray));
    int unitSize = sqrt(size);
    int unitAmount = size/unitSize+1;
    t->unitSize = unitSize;
    t->unitAmount = unitAmount;
    t->arrs = (int**)malloc(sizeof(int*)*unitAmount);
    for(int i = 0; i < unitAmount; i++)
        t->arrs[i] = (int*)malloc(sizeof(int)*unitSize);
    t->sums = (int*)malloc(sizeof(int)*unitAmount);
    memset(t->sums, 0, sizeof(int)*unitAmount);
    int index = 0;
    for(int i = 0; i < size; i++)
    {
        t->arrs[i/unitSize][i%unitSize] = nums[i];
        t->sums[i/unitSize] += nums[i];
    }
    /*printf("return \n");*/
    return t;
}

void update(struct NumArray* numArray, int i, int val)
{
    /*printf("updating: %d -> %d\n", i, val);*/
    int unitSize = numArray->unitSize;
    int unitAmount = numArray->unitAmount;
    numArray->sums[i/unitSize] += val - numArray->arrs[i/unitSize][i%unitSize];
    numArray->arrs[i/numArray->unitSize][i%numArray->unitSize] = val;
}

int sumRange(struct NumArray* numArray, int i, int j)
{
    /*printf("retrieving %d to %d\n", i, j);*/
    int sum = 0;
    int unitSize = numArray->unitSize;
    int** arrs = numArray->arrs;
    int* sums = numArray->sums;
    int r0 = i/unitSize;
    int r1 = j/unitSize;
    int c0 = i%unitSize;
    int c1 = j%unitSize;
    if(r0 == r1) //in the same row;
    {
        for(int k = c0; k <= c1; k++)
            sum += arrs[r0][k];
        return sum;
    }
    for(int k = c0; k < unitSize; k++)
        sum += arrs[i/unitSize][k];
    for(int k = r0+1; k < r1; k++)
        sum += sums[k];
    for(int k = c1; j > -1; j--)
        sum += arrs[r1][k];
    return sum;
}

void NumArrayFree(struct NumArray* numArray)
{
    /*printf("deallocating\n");*/
    for(int i = 0; i < numArray->unitAmount; i++)
        free(numArray->arrs[i]);
    free(numArray->arrs);
    free(numArray->sums);
}
