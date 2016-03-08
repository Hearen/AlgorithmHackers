/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-08 07:55
Description : Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
Source      : https://leetcode.com/problems/implement-queue-using-stacks/
*******************************************/
#include <stdbool.h>
typedef struct //using deque to imitate the two stacks operation avoid extra O(N) space wasting;
{
    int *stack;
    int begin; //begin -> point to the exact first front element;
    int end; //end -> point to the next element of the last element to be easily indicate the empty case;
    int maxSize;
} Queue;

void queueCreate(Queue *queue, int maxSize)
{
    queue->stack = (int*)malloc(sizeof(int)*maxSize);
    queue->begin = 0;
    queue->end = 0;
    queue->maxSize = maxSize; //record the maxSize for checking;
}

void queuePush(Queue *queue, int element)
{
    if(queue->end == queue->maxSize) //reach its valid end, we have to rearrange the stack;
    {
        for(int i = queue->begin; i < queue->end; i++)
            queue->stack[i-queue->begin] = queue->stack[i];
        queue->begin = 0;
        queue->end -= queue->begin;
    }
    queue->stack[queue->end++] = element;
}

void queuePop(Queue *queue)
{
    queue->begin++;
}

int queuePeek(Queue *queue)
{
    return queue->stack[queue->begin];
}

bool queueEmpty(Queue *queue)
{
    return queue->begin == queue->end;
}

void queueDestroy(Queue *queue)
{
    free(queue->stack);
    /*free(queue); this part cannot be executed*/
}
