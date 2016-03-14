/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-29 15:58
Description : 
Source      : https://leetcode.com/problems/count-of-range-sum/
*******************************************/
int countWhileMergeSort0(long* sums, int begin, int end, int lower, int upper)
{
    if(end-begin <= 1) return 0;
    int mid = begin + (end-begin)/2;
    int count = countWhileMergeSort(sums, begin, mid, lower, upper)+countWhileMergeSort(sums, mid, end, lower, upper);
    int l = mid, h = mid, r = mid;
    int size = end - begin;
    long* cache = (long*)malloc(sizeof(long)*size);
    for(int i = begin, index=0; i < mid;)
    {
        long newLower = sums[i]+lower;
        long newUpper = sums[i]+upper;
        while(l<end && sums[l]<newLower) l++;
        while(h<end && sums[h]<=newUpper) h++;
        count += h-l;
        while(r<end && sums[r]<sums[i]) cache[index++]=sums[r++];
        cache[index++] = sums[i++];
    }
    for(int i = 0; i < r-begin; i++)
        sums[begin+i]=cache[i];
    return count;
}

//AC - 20ms;
int countRangeSum0(int* nums, int size, int lower, int upper)
{
    long *sums = (long*)malloc(sizeof(long)*(size+1));
    memset(sums, 0, sizeof(long)*(size+1));
    for(int i = 0; i < size; i++)
        sums[i+1] = sums[i] + nums[i];
    return countWhileMergeSort(sums, 0, size+1, lower, upper);
}

int countWhileMergeSort1(long *sums, int begin, int end, int lower, int upper)
{
    if(end < begin) return 0;
    if(begin == end) return (sums[begin] >= lower && sums[begin] <= upper)? 1 : 0;
    int mid = begin + (end-begin)/2;
    int count = countWhileMergeSort1(sums, begin, mid, lower, upper) + countWhileMergeSort1(sums, mid+1, end, lower, begin);
    int l, h, r;
    l = h = r = mid+1;
    int size = end-begin+1;
    long *cache = (long*)malloc(sizeof(long)*size);
    for(int i = begin, index=0; i <= mid; )
    {
        long newLower = sums[i]+lower;
        long newUpper = sums[i]+upper;
        while(l<=end && sums[l]<newLower) l++;
        while(h<=end && sums[h]<=newUpper) h++;
        count += h-l;
        while(r<=end && sums[r] < sums[i]) cache[index++] = sums[r++];
        cache[index++] = sums[i++];
    }
    for(int i = begin; i < r; i++) 
        sums[i] = cache[i-begin];
    return count;
}


int countRangeSum1(int* nums, int size, int lower, int upper)
{
    size++;
    long *sums = (long*)malloc(sizeof(long)*size);
    memset(sums, 0, sizeof(long)*size);
    for(int i = 1; i < size; i++)
        sums[i] = sums[i-1] + nums[i-1];
    return countWhileMergeSort1(sums, 1, size-1, lower, upper);
}
