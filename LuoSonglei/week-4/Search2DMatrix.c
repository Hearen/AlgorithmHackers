/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-25 08:45
Description : 
Source      : https://leetcode.com/problems/search-a-2d-matrix/
*******************************************/
#include<stdbool.h>
//AC - 8ms;
bool searchMatrix0(int** matrix, int rowSize, int colSize, int target)
{
    int rLow = 0, rHigh = rowSize-1, rMid = 0;
    while(rLow < rHigh)
    {
        rMid = (rLow + rHigh) / 2;
        if(matrix[rMid][0] > target)
            rHigh = rMid - 1;
        else if(matrix[rMid][colSize-1] < target)
            rLow = rMid+1;
        else
            break;
    }
    rMid = (rLow < rHigh)? rMid : rLow;
    int low = 0, high = colSize-1, mid;
    while(low <= high)
    {
        mid = (low+high)/2;
        if(matrix[rMid][mid] > target)
            high = mid-1;
        else if(matrix[rMid][mid] < target)
            low = mid+1;
        else
            return true;
    } 
    return false;
}

//AC - 8ms;
bool searchMatrix1(int** matrix, int rowSize, int colSize, int target)
{
    int low = 0, high = rowSize*colSize - 1, mid;
    int t = 0;
    while(low <= high)
    {
        mid = (low + high) >> 1;
        t = matrix[mid / colSize][mid % colSize];
        if(t > target)
            high = mid - 1;
        else if(t < target) 
            low = mid + 1;
        else
            return true;
    }
    return false;
    return matrix[mid / colSize][mid % colSize] == target;
}


bool searchMatrix2(int** matrix, int rowSize, int colSize, int target)
{
    int low = 0, high = rowSize*colSize - 1, mid;
    while(low != high)
    {
        mid = (low+high) >> 1;
        if(matrix[mid / colSize][mid % colSize] < target)
            low = mid + 1;
        else
            high = mid;
    } 
    return matrix[low / colSize][low % colSize] == target;
}
