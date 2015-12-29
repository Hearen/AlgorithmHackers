/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-26 21:06
Description : 
Source      : https://leetcode.com/problems/h-index-ii/
*******************************************/

//Memory Limit Exceeded;
int hIndex0(int* s, int size)
{
    int* counter = (int*)malloc(sizeof(int)*(size+1));
    int i = 0;
    for(; i < size+1; i++)
        counter[i] = 0;
    for(i = 0; i < size; i++)
    {
        if(s[i] > size)
            counter[size]++;
        else
            counter[s[i]]++;
    }
    int t;
    for(i = size; i > 0; i--)
    {
        t = t + counter[i];
        if(t >= i)
            break;
    }
    return i;
}

//AC - 4ms;
int hIndex(int* s, int size)
{
    if(size == 0)
        return 0;
    int low = 0, high = size-1; 
    while(low <= high)
    {
        int mid = (low+high)>>1;
        if(s[mid] == size - mid)
            return s[mid];
        if(s[mid] < size - mid)
            low = mid+1;
        else
            high = mid-1;
    }
    return size-high-1;
}
