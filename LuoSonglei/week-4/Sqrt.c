/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-22 20:53
Description : 
Source      : https://leetcode.com/problems/sqrtx/
*******************************************/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
//Newton method - 8ms;
int intSqrt(int x)
{
    long g = x;
    while(g*g > x)
        g = (g + x/g) / 2;
    return g; 
}

//bit manipulation - 4ms or 8ms due to format;
int bitSqrt(int x)
{
    if(x == 0 || x == 1)
        return x;
    int h = 0;
    while((long)(1 << h) * (long)(1 << h) <= x)
        h++;
    h--;
    int d = h - 1;
    int res = (1 << h);
    while(d >= 0)
    {
        if((long)(res | 1 << d)*(long)(res | 1 << d) <= x)
            res |= (1 << d);
        d--;
    }
    return res;
}

//Used to get the square root in a certain precision rather quickly
//quicker than system sqrt method about by twice;
float floatSqrt(float x)
{
    float xhalf = 0.5f*x;
    int i = *(int*)&x; // get bits for floating VALUE 
    i = 0x5f375a86- (i>>1); // gives initial guess y0
    x = *(float*)&i; // convert bits BACK to float
    x = x*(1.5f-xhalf*x*x); // Newton step, repeating increases accuracy
    x = x*(1.5f-xhalf*x*x); // Newton step, repeating increases accuracy
    x = x*(1.5f-xhalf*x*x); // Newton step, repeating increases accuracy
    return 1/x;
}
void main()
{
    printf("Faster:  %f\n", mySqrt(2147395599));
    printf("System:  %f\n", sqrt(2147395599));
    for(int i = 0; i < 10000; i++)
    {
        printf("Faster:  %d\n", mySqrt(i));
        printf("System:  %f\n", sqrt((double)i));
    }
}
