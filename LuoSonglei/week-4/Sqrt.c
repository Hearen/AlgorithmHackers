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
    double a = 10e-5;
    double g = rand()%x;
    while((g*g - x) > a)
    {
        g = (g+x/g)/2;
    }
    return g; 
}

//bit manipulation - 4ms;
int bitSqrt(int x)
{
    if(x == 0)
        return 0;
    int h = 0;
    while((long)(1<<h)*(long)(1<<h) <= x)
        h++;
    h--;
    int res = 1<<h;
    int b = h-1;
    while(b >= 0) //find the rest bits status;
    {
        if((long)(res | (1<<b))*(long)(res | (1<<b)) <= x)
            res |= (1<<b);
        b--;
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
