/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-22 16:18
Description : 
Source      : https://leetcode.com/problems/ugly-number-ii/
*******************************************/
//AC - 4ms;
int nthUglyNumber(int n)
{
    if(n < 1) return 0;
    if(n == 1) return 1;
    int *arr = (int*)malloc(sizeof(int)*n);
    int i2=0, i3=0, i5=0;
    arr[0] = 1;
    for(int i = 1; i < n; i++)
    {
        int t2 = arr[i2]*2;
        int t3 = arr[i3]*3;
        int t5 = arr[i5]*5;
        int min = t2;
        if(min > t3)
            min = t3;
        if(min > t5)
            min = t5;
        arr[i] = min;
        if(min == t2)
            i2++;
        if(min == t3)
            i3++;
        if(min == t5)
            i5++;
    }
    return arr[n-1];
}
