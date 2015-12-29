/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-26 19:52
Description : 
Source      : https://leetcode.com/problems/h-index/
*******************************************/
//AC - 88ms;
int hIndex0(int* s, int size)
{
    int i = size;
    for(; i > 0; i--)
    {
        int count = 0;
        int extra = 0;
        for(int j = 0; j < size; j++)
        {
            if(s[j] > i)
                count++;
            if(s[j] == i)
                extra++;
        }
        if(count <= i && count+extra >= i)
            break;
    }
    return i;
}

//AC - 0ms;
int hIndex(int* s, int size)
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
