/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-27 12:36
Description : 
Source      : https://leetcode.com/problems/insert-interval/
*******************************************/
struct Interval
{
    int start;
    int end;
};

struct Interval* insert(struct Interval* intervals, int size, struct Interval newInterval, int* returnSize)
{
    size++;
    struct Interval *arr = (struct Interval*)malloc(sizeof(struct Interval)*size);
    int j = 0;
    int i = 0;
    int count=0;
    while(i < size-1) //inserting newInterval into arr with all in ascending order;
    {
        if(intervals[i].start < newInterval.start || count) // newInterval already inserted then we need to collect the remained intervals or it's bigger then we need to collect the intervals first;
            arr[i+count] = intervals[i++];
        else
            arr[i] = newInterval, count++; //inserting newInterval and counter it as a flag;
    }
    if(count == 0) arr[i] = newInterval; //make sure newInterval is not missed at the end of the intervals;
    *returnSize = 0;
    int max = 0;
    i = 0;
    while(i < size)
    {
        struct Interval t;
        t.start = arr[i].start;
        int j = i+1;
        max = arr[i].end;
        while(j<size && arr[j].start<=max) //merging intervals in arr now;
        {
            if(arr[j].end > max) max = arr[j].end;
            j++;
        }
        i = j; //update the next start index;
        t.end = max;
        *returnSize += 1;
        arr[*returnSize-1] = t; //since we are merging, arr then can be reused;
    }
    return arr;
}

