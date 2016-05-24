/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : Tue, 24 May 2016 19:24 CST
Description : Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
Example:
Given num = 16, return true. Given num = 5, return false.
Follow up: Could you solve it without loops/recursion?
Source      : https://leetcode.com/problems/power-of-four/
*******************************************/
#include <cstdbool.h>
//AC - 4ms - using loop to check;
bool isPowerOfFour0(int n)
{
    int arr[] = {1, 4,16,64,256,1024,4096,16384,65536,262144,1048576,4194304,
        16777216,67108864,268435456,1073741824}; //using the OJ to get the array;
    for(int i = 0; i < sizeof(arr)/sizeof(int); i++) //check whether it's one of them;
        if(num == arr[i]) return true;
    return false;
}

//AC - 4ms - recursive;
bool isPowerOfFour1(int n)
{
    if(n < 1) return false;
    if(n == 1) return true;
    return (n&3)==0 && isPowerOfFour(n>>2); //n&3 -> n%4;
}

//AC - 4ms - using loop;
bool isPowerOfFour2(int n)
{
    if(n < 1) return false;
    if(n == 1) return true;
    while(n > 1)
    {
        if(n%4) return false;
        n /= 4;
    }
    return true;
}

//AC - 4ms - adopting bit manipulation;
bool isPowerOfFour(int n)
{
    return n==1 || (n>1 && (n&-n)==n && (n&0x2aaaaaab)==0); //n&-n used to get the last bit of n -> used here to check whether it only has one 1-bit; 
    //n&0x2aaaaaab used to make sure the 1-bit lies in the right position - power of four;
}
