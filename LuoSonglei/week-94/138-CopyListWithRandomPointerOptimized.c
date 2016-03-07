/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-06 20:41
Description : A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
Source      : https://leetcode.com/problems/copy-list-with-random-pointer/
*******************************************/
#include <stdlib.h>
struct RandomListNode
{
    int label;
    struct RandomListNode *next;
    struct RandomListNode *random;
};

struct RandomListNode* copyRandomList0(struct RandomListNode *head)
{
    if(!head) return NULL;
    struct RandomListNode *newHead=NULL, *oldNode=head, *newNode=NULL, *preNewNode=NULL;
    while(oldNode) //copy the node and place the new node just after the original one;
    {
        newNode = (struct RandomListNode*)malloc(sizeof(struct RandomListNode));
        newNode->next = oldNode->next;
        newNode->label = oldNode->label;
        newNode->random = NULL;
        oldNode->next = newNode;
        oldNode = oldNode->next->next;
    }
    oldNode = head;
    while(oldNode) //using the adjacent attribute to find the random pointer;
    {
        if(oldNode->random)
            oldNode->next->random = oldNode->random->next;
        oldNode = oldNode->next->next;
    }
    
    newHead = head->next;
    oldNode = head;
    while(oldNode) //splitting the two merged list into two independent ones restoring the original list;
    {
        newNode = oldNode->next;
        oldNode->next = newNode->next;
        if(preNewNode)
            preNewNode->next = newNode;
        preNewNode = newNode;
        oldNode = oldNode->next;
    }
    return newHead;
}

struct RandomListNode* copyRandomList(struct RandomListNode *head)
{
    if(!head) return NULL;
    struct RandomListNode *newHead=NULL, *oldNode=head, *newNode=NULL;
    while(oldNode) //copy the node and place the new node just after the original one;
    {
        newNode = (struct RandomListNode*)malloc(sizeof(struct RandomListNode));
        newNode->next = oldNode->next;
        newNode->label = oldNode->label;
        newNode->random = NULL;
        oldNode->next = newNode;
        oldNode = oldNode->next->next;
    }
    oldNode = head;
    while(oldNode) //using the adjacent attribute to find the random pointer;
    {
        if(oldNode->random)
            oldNode->next->random = oldNode->random->next;
        oldNode = oldNode->next->next;
    }
    
    newHead = head->next;
    newNode = head->next;
    oldNode = head;
    while(oldNode) //splitting the two merged list into two independent ones restoring the original list;
    {
        oldNode->next = oldNode->next->next;
        if(oldNode->next == NULL)
        {
            newNode->next = NULL;
            break;
        }
        newNode = newNode->next->next;
        newNode = newNode->next;
        oldNode = oldNode->next;
    }
    return newHead;
}
