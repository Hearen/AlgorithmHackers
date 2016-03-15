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
    int *nums, *sums;
    int size;
};

void updateElement(struct NumArray* numArray, int i, int val)
{
    i++;
    while(i <= numArray->size)
    {
        numArray->sums[i] += val;
        i += (i & -i);
    }
}

struct NumArray* NumArrayCreate(int *nums, int size)
{
    struct NumArray *t = (struct NumArray*)malloc(sizeof(struct NumArray));
    t->nums = (int*)malloc(sizeof(int)*size);
    memcpy(t->nums, nums, sizeof(int)*size);
    t->size = size;
    t->sums = (int*)malloc(sizeof(int)*(size+1));
    memset(t->sums, 0, sizeof(int)*(size+1));
    for(int i = 0; i <= size; i++)
        updateElement(t, i, nums[i]);
    return t;
}

void update(struct NumArray* numArray, int i, int val)
{
    int d = val-numArray->nums[i];
    numArray->nums[i] = val;
    updateElement(numArray, i, d);
}

int getSum(struct NumArray* numArray, int i)
{
    int sum = 0;
    i++;
    while(i > 0)
    {
        sum += numArray->sums[i];
        i -= (i & -i);
    }
    return sum;
}
int sumRange(struct NumArray* numArray, int i, int j)
{
    return getSum(numArray, j)-getSum(numArray, i-1);
}

void NumArrayFree(struct NumArray* numArray)
{
    free(numArray->nums);
    free(numArray->sums);
    free(numArray);
}
