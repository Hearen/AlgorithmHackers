/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-25 16:09
Description : 
Source      : https://leetcode.com/problems/median-of-two-sorted-arrays/
*******************************************/
#include<limits.h>

//AC - 28ms;
double findMedianSortedArrays1(int* nums1, int size1, int* nums2, int size2)
{
    if(size1 > size2)
        return findMedianSortedArrays(nums2, size2, nums1, size1);
    int half = (size1+size2-1)/2;
    int mid1, mid2;
    int low = 0, high = half > size1? size1:half;
    while(low < high)
    {
        mid1 = (low+high)/2;
        mid2 = half - mid1;
        if(nums1[mid1] < nums2[mid2])
            low = mid1 + 1;
        else
            high = mid1;
    }

    double a, b, c, d;
    //get bigger one;
    c = half-low < size2? nums2[half-low] : INT_MIN;
    d = low > 0?  nums1[low-1] : INT_MIN;
    a = c > d? c:d;
    if((size1+size2)&1 == 1)
        return a;
    //get the smaller;
    c = half-low+1 < size2? nums2[half-low+1] : INT_MAX;
    d = low < size1? nums1[low] : INT_MAX;
    b = c < d? c:d;
    return (a+b)/2;
}

//AC - 20ms;
double findMedianSortedArrays2(int* nums1, int size1, int* nums2, int size2)
{
    if(size1 > size2)
        return findMedianSortedArrays(nums2, size2, nums1, size1);
    int half = (size1+size2-1)>>1;
    int mid1, mid2;
    int low = 0, high = half > size1? size1:half;
    while(low < high)
    {
        mid1 = (low+high)>>1;
        mid2 = half - mid1;
        if(nums1[mid1] < nums2[mid2])
            low = mid1 + 1;
        else
            high = mid1;
    }

    double a, b, c, d;
    //get bigger one;
    c = half-low < size2? nums2[half-low] : INT_MIN;
    d = low > 0?  nums1[low-1] : INT_MIN;
    a = c > d? c:d;
    if((size1+size2)&1 == 1)
        return a;
    //get the smaller;
    c = half-low+1 < size2? nums2[half-low+1] : INT_MAX;
    d = low < size1? nums1[low] : INT_MAX;
    b = c < d? c:d;
    return (a+b)/2;
}
