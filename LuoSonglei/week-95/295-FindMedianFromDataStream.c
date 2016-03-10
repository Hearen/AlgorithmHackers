/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-10 08:52
Description : Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2
Source      : https://leetcode.com/problems/find-median-from-data-stream/
*******************************************/
#include <stdio.h>
#include <stdlib.h>
struct MedianFinder
{
    int* arr;
    int size;
};

struct MedianFinder* MedianFinderCreate()
{
    struct MedianFinder *t = (struct MedianFinder*)malloc(sizeof(struct MedianFinder));
    t->arr = (int*)malloc(sizeof(int));
    t->size = 0;
    return t;
}

void addNum(struct MedianFinder *mf, int num)
{
    mf->size += 1;
    mf->arr = (int*)realloc(mf->arr, (sizeof(int)*mf->size));
    if(num > mf->arr[mf->size-2])
    {
        mf->arr[mf->size-1] = num;
        return ;
    }
    int j = mf->size-2;
    while(j>-1 && mf->arr[j]>num)
    {
        mf->arr[j+1] = mf->arr[j];
        j--;
    }
    mf->arr[j+1] = num;
}

//AC - 656ms;
double findMedian(struct MedianFinder* mf)
{
    if(mf->size%2)
        return mf->arr[mf->size/2];
    return (mf->arr[mf->size/2-1]+mf->arr[mf->size/2])/2.0;
}

void MedianFinderFree(struct MedianFinder* mf)
{
    
}

int main(int argc, char *argv[])
{
    struct MedianFinder *t = MedianFinderCreate();
    addNum(t, 2);
    printf("%f\n", findMedian(t));
    addNum(t, 3);
    printf("%f\n", findMedian(t));
    return 0;
}
