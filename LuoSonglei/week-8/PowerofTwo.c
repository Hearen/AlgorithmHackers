/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 16:10
Description : 
Source      : https://leetcode.com/problems/power-of-two/
*******************************************/
#include <stdbool.h>
//AC - 8ms;
bool isPowerOfTwo0(int n)
{
    int arr[] = {1,
    2,4,8,16,32,64,128,256,512,1024,
    2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,
    2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824};
    for(int i = 0; i < sizeof(arr)/sizeof(int); i++)
        if(n == arr[i])
            return true;
    return false;
}

//AC - 4ms;
bool isPowerOfTwo1(int n)
{
    while(n)
    {
        if(n == 1)
            return true;
        if(n%2)
            return false;
        n /= 2;
    }
}

//AC - 4ms;
bool isPowerOfTwo2(int n)
{
    if(n < 1)
        return false;
    int count = 0;
    while(n)
    {
        if(n & 1)
            count++;
        n >>= 1;
    }
    if(count > 1)
        return false;
    else 
        return true;
}
