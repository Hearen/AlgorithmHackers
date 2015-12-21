/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-20 21:15
Description : 
Source      : https://leetcode.com/problems/largest-rectangle-in-histogram/
*******************************************/
//AC - 8ms
//only calculate the stack - ascending order
//the width will be calculated by the stored indexes;
int largestRectangleArea(int* heights, int heightSize)
{
    heightSize++;
    int* tmp = (int*)malloc(sizeof(int) * heightSize);
    int i = 0;
    for(; i < heightSize - 1; i++)
        tmp[i] = heights[i];
    tmp[heightSize-1] = 0;
    heights = tmp;
    int current = 0, max = 0;
    int* stack = (int)malloc(sizeof(int) * heightSize);
    int top = 0;
    stack[top] = -1;
    for(i = 0; i < heightSize; i++)
    {
        while(top > 0 && heights[stack[top]] > heights[i])
        {
            current = (i - stack[top - 1] - 1) * heights[stack[top]];
            top--;
            if(current > max)
                max = current;
        }
        stack[++top] = i;
    }
    return max;
}
