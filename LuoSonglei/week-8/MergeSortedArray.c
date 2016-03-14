/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 13:57
Description : 
Source      : https://leetcode.com/problems/merge-sorted-array/
*******************************************/
//AC - 0ms;
void merge(int* nums1, int m, int* nums2, int n)
{
    int index = m+n-1;
    int i = m-1, j = n-1;
    while(i > -1 && j > -1)
    {
        if(nums1[i] > nums2[j]) nums1[index--] = nums1[i--];
        else nums1[index--] = nums2[j--];
    }
    while(i > -1)
        nums1[index--] = nums1[i--];
    while(j > -1)
        nums1[index--] = nums2[j--];
}
