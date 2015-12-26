/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-25 15:17
Description : 
Source      : https://leetcode.com/problems/search-a-2d-matrix-ii/
*******************************************/
#include <stdbool.h>
bool search(int* a, int size, int target)
{
    if(target > a[size-1])
        return false;
    if(target < a[0])
        return false;
    int low = 0, high = size - 1;
    int mid = 0;
    while(low != high)
    {
        mid = (low+high) >> 1;
        if(a[mid] < target)
            low = mid+1;
        else 
            high = mid;
    }
    return a[low] == target;
}

//AC - 168ms;
bool searchMatrix(int** matrix, int rSize, int cSize, int target)
{
    for(int i = 0; i < rSize; i++)
    {
        if(search(matrix[i], cSize, target))
            return true;
    }
    return false;
}
