/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-24 08:45
Description : 
Source      : https://leetcode.com/problems/powx-n/
*******************************************/
//AC - 0ms;
double myPow0(double x, int n)
{
    if(n == 0)
        return 1;
    if(n < 0)
    {
        x = 1/x;
        n = -n;
    }
    return n%2 == 0? myPow(x*x, n/2) : myPow(x*x, n/2) * x;
}

//AC - 0ms;
double myPow1(double x, int n)
{
    if(n == 0)
        return 1;
    if(n < 0)
    {
        x = 1/x;
        n = -n;
    }
    long b = n;
    double res = 1;
    while(b > 0)
    {
        if(b & 1)
            res *= x;
        x *= x;
        b>>1;
    }
    return res;
}
