/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 16:07
Description : 
Source      : https://leetcode.com/problems/happy-number/
*******************************************/
#include <stdbool.h>
//AC - 0ms;
//https://www.kidscodecs.com/happy-numbers/
int isHappy(int n)
{
    int sum = 0;
    for(; n; n/=10)
        sum += (n%10)*(n%10);
    if(sum == 1)
        return true;
    int arr[] = {4, 16, 37, 58, 89, 145, 42, 20};
    for(int i = 0; i < sizeof(arr)/sizeof(int); i++)
        if(sum == arr[i])
            return false;
    return isHappy(sum);
}
