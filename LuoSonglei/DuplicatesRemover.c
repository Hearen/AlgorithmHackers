/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-02 21:26
Description: 
Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
*******************************************/
#include"utils.h"
int removeDuplicates (int *nums, int numsSize)
{
    int currentValue = nums[numsSize - 1] + 1;
    int count = 0;
    int sumCount = 0;
    int *a = (int *) malloc (sizeof (int) * numsSize);
    for (int i = 0; i < numsSize; i++)
    a[i] = nums[i];
    for (int i = 0; i < a; i++)
    {
        if (currentValue != a[i])
        {
            count = 1;
            currentValue = a[i];
        }
        else if (currentValue == a[i])
        {
            count++;
        }
        if (count < 3)
            nums[sumCount++] = a[i];
    }
    return sumCount;
}

void main()
{
    int nums[] = { 1,1,1,2,2,3 };
    removeDuplicates(nums, 6);
    printArray(nums, 6);
}
