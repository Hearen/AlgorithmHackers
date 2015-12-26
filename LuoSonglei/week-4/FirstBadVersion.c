/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-25 16:33
Description : 
Source      : https://leetcode.com/problems/first-bad-version/
*******************************************/
#include <stdbool.h>

bool isBadVersion(int version);

//AC - 0ms;
int firstBadVersion0(int n)
{
    int low = 1, high = n;
    int min = n;
    while(low <= high)
    {
        int mid = low + (high - low) / 2;  // this part should be handled carefully - overflow -> timeout;
        if(isBadVersion(mid))
        {
            high = mid - 1;
            if(mid < min)
                min = mid;
        }
        else
            low = mid + 1;
    }
    return min;
}

//AC - 0ms;
int firstBadVersion(int n)
{
    int low = 1, high = n;
    int mid;
    while(low < high)
        isBadVersion(mid = low+(high-low)/2) ? (high = mid) : (low = mid+1);
    return high;
}
