/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-27 20:33
Description : 
Source      : https://leetcode.com/problems/divide-two-integers/
*******************************************/
#include <limits.h>
int getResult(int a, int b)
{
    int d = 0;
    int sum = 0;
    while(b)
    {
        if(b&1)
            sum = sum + (a)<<d;
        d++;
        b >>= 1;
    }
    return sum;
}

//the range is not controlled well;
//Time Limit Exceeded;
int divide0(int dividend, int divisor)
{
    int sign = 1;
    long low = 0, high = dividend;
    long divisor0 = divisor;
    if(high < 0)
        sign *= -1, high = abs(high);
    if(divisor0 < 0)
        sign *= -1, divisor0 = abs(divisor0);
    long mid, sum;
    while(low < high)
    {
        mid = (low+high)>>1;
        sum = getResult(mid, divisor0);
        if(sum > dividend)
            high = mid-1;
        else 
            low = mid+1;
    }
    if(getResult(low, divisor0) > dividend)
        low--;
    return low*sign;
}

//Time Limit Exceeded;
int divide1(int dividend, int divisor)
{
    int i = 0;
    int sign = 1;
    if(divisor < 0)
        sign = -1, divisor *= -1;
    while(getResult(i++, divisor) > dividend);
    if(getResult(i, divisor) > dividend)
        i--;
    return i*sign;
}

//AC - 8ms;
int divide(int dividend, int divisor)
{
    if(divisor == 0 || (dividend == INT_MIN && divisor == -1))
        return INT_MAX;
    int sign = (dividend < 0 ^ divisor < 0)? -1 : 1;
    printf("%d\n", sign);
    long dd = fabs(dividend), dv = fabs(divisor);
    int tmp, factor;
    int res = 0;
    while(dd >= dv)
    {
        tmp = dv, factor = 1;
        while(dd >= tmp)
            factor<<=1, tmp<<=1;
        tmp >>= 1, factor >>= 1;
        dd -= tmp;
        res += factor;
    }
    return sign*factor;
}
