/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-08 12:31
Description : Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Source      : https://leetcode.com/problems/min-stack/
*******************************************/
#include <limits.h>
typedef struct
{
    int *arr;
    int count;
    int *mins;
    int minCount;
} MinStack;

void minStackCreate(MinStack *stack, int maxSize)
{
    stack->arr = (int*)malloc(sizeof(int)*maxSize);
    stack->mins = (int*)malloc(sizeof(int)*maxSize); //record the mins till the top of the arr;
    stack->count = 0;
    stack->minCount = 0;
}

void minStackPush(MinStack *stack, int element) //push it to arr normally, but meantime check whether we should push it to mins;
{
    stack->arr[stack->count++] = element;
    if(stack->minCount==0 || element<=stack->mins[stack->minCount-1])
        stack->mins[stack->minCount++] = element;
}

void minStackPop(MinStack *stack) //pop will always pop the top -> the top of mins and arr;
{
    int top = stack->arr[stack->count-1];
    if(stack->mins[stack->minCount-1] == top)
        stack->minCount--;
    stack->count--;
}

int minStackTop(MinStack *stack) //just return the top, needless to remove it;
{
    return stack->arr[stack->count-1];
}

int minStackGetMin(MinStack *stack) //just return the min, needless to remove it;
{
    return stack->mins[stack->minCount-1];
}

void minStackDestroy(MinStack *stack)
{
    free(stack->arr);
    free(stack->mins);
}
