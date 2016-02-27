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

//AC - 576ms;
struct Interval* insert(struct Interval* intervals, int size, struct Interval newInterval, int* returnSize)
{
    struct Interval *arr = (struct Interval*)malloc(sizeof(struct Interval));
    size++;
    struct Interval *arr0 = (struct Interval*)malloc(sizeof(struct Interval)*size);
    int j = 0;
    int i = 0;
    int count=0;
    while(i < size-1)
    {
        if(intervals[i].start < newInterval.start || count)
            arr0[i+count] = intervals[i++];
        else
            arr0[i] = newInterval, count++;
    }
    if(count == 0) arr0[i] = newInterval;
    *returnSize = 0;
    int max = 0;
    i = 0;
    while(i < size)
    {
        struct Interval t;
        t.start = arr0[i].start;
        int j = i+1;
        max = arr0[i].end;
        while(j<size && arr0[j].start<=max)
        {
            if(arr0[j].end > max) max = arr0[j].end;
            j++;
        }
        i = j;
        t.end = max;
        *returnSize += 1;
        arr = (struct Interval*)realloc(arr, sizeof(struct Interval)*(*returnSize));
        arr[*returnSize-1] = t;
    }
    return arr;
}
