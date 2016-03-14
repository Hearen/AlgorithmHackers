/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-08 08:50
Description : Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

Source      : https://leetcode.com/problems/implement-stack-using-queues/
*******************************************/
#include <cstdbool.h>
typedef struct
{
    int  *queue0; //the major queue where all elements being stored;
    int  *queue1; //assistant queue for imitation;
    int size; //used to record the size of queue0;
    int maxSize;
} Stack;

void stackCreate(Stack *stack, int maxSize)
{
    stack->maxSize = maxSize;
    stack->size = 0;
    stack->queue0 = (int*)malloc(sizeof(int)*maxSize);
    stack->queue1 = (int*)malloc(sizeof(int)*maxSize);
}

void stackPush(Stack *stack, int element)
{
    stack->queue0[stack->size++] = element;
}

void stackPop(Stack *stack)
{
    int size = stack->size;
    for(int i = 0; i < size-1; i++) //popping queue0 to queue1 all elements except for the last;
        stack->queue1[i] = stack->queue0[i];
    stack->size--; //delete the last element in queue0;
    for(int i = 0; i < size-1; i++) //popping queue1 back to queue0 and update stack->size;
        stack->queue0[i] = stack->queue1[i];
}

int stackTop(Stack *stack)
{
    int size = stack->size;
    for(int i = 0; i < size-1; i++) //popping queue0 to queue1 all elements except for the last;
        stack->queue1[i] = stack->queue0[i];
    int ret = stack->queue0[size-1]; //pop the last from queue0;
    for(int i = 0; i < size-1; i++) //popping queue1 back to queue0;
        stack->queue0[i] = stack->queue1[i];
    return ret;
}

bool stackEmpty(Stack *stack)
{
    return stack->size == 0;
}

void stackDestroy(Stack *stack)
{
    free(stack->queue0);
    free(stack->queue1);
}
