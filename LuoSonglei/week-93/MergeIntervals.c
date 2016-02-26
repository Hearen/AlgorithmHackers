/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-26 16:27
Description : 
Source      : https://leetcode.com/problems/merge-intervals/
*******************************************/
struct Interval
{
    int start, end;
};

void sort(struct Interval* intervals, int begin, int end)
{
    int l=begin, r=end;
    int v = intervals[l+(r-l)/2].start;
    while(l <= r)
    {
        while(intervals[l].start < v) l++;
        while(intervals[r].start > v) r--;
        if(l <= r)
        {
            struct Interval t = intervals[l];
            intervals[l] = intervals[r];
            intervals[r] = t;
            l++; r--;
        }
    }
    if(begin < r)
        sort(intervals, begin, r);
    if(l < end)
        sort(intervals, l, end);
}

//AC - 576ms;
struct Interval* merge(struct Interval* intervals, int size, int* returnSize)
{
    struct Interval *arr = (struct Interval*)malloc(sizeof(struct Interval));
    *returnSize = 0;
    sort(intervals, 0, size-1);
    int i = 0;
    while(i < size)
    {
        struct Interval t;
        t.start = intervals[i].start;
        int max = intervals[i].end;
        int j = i+1;
        for(; j<size && intervals[j].start<=max; j++)
            max = max > intervals[j].end? max : intervals[j].end;
        t.end = max;
        i = j;
        *returnSize += 1;
        arr = (struct Interval*)realloc(arr, sizeof(struct Interval)*(*returnSize));
        arr[*returnSize-1] = t;
    }
    return arr;
}
