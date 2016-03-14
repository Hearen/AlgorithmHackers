/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-25 08:42
Description : 
Source      : https://leetcode.com/problems/container-with-most-water/
*******************************************/
//AC - 12ms;
int maxArea1(int* heights, int size)
{
    int l = 0;
    int r = size-1;
    int max = 0;
    while(l < r)
    {
        int len = r-l;
        int area = 0;
        if(heights[l] < heights[r])
        {
            area = len*heights[l];
            max = max > area? max : area;
            l++;
        }
        else
        {
            area = len*heights[r];
            max = max > area? max : area;
            r--;
        }
    }
    return max;
}

//AC - 8ms;
int maxArea(int* heights, int size)
{
    int l=0, r=size-1;
    int max = 0;
    while(l < r)
    {
        int area = (r-l)*(heights[l] < heights[r]? heights[l++] : heights[r--]);
        max = max > area? max : area;
    }
    return max;
}
