/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 14:14
Description : 
Source      : https://leetcode.com/problems/intersection-of-two-linked-lists/
*******************************************/
#include <stdlib.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};
//Time Limit Exceeded;
struct ListNode* getIntersectionNode0( struct ListNode* headA, struct ListNode* headB )
{
    struct ListNode *t = headB;
    while(headA)
    {
        t = headB;
        while(t)
        {
            if(t==headA)
                return t;
            t = t->next;
        }
        headA = headA->next;
    }
    return NULL;
}

//AC - 32ms;
struct ListNode* getIntersectionNode( struct ListNode* headA, struct ListNode* headB )
{
    int lenA = 0;
    int lenB = 0;
    struct ListNode *t0 = headA;
    struct ListNode *t1 = headB;
    while(t0)
        lenA++, t0 = t0->next;
    while(t1)
        lenB++, t1 = t1->next;
    int difference = 0;
    if(lenA > lenB)
    {
        difference = lenA - lenB;
        t0 = headA;
        t1 = headB;
    }
    else
    {
        difference = lenB - lenA;
        t0 = headB;
        t1 = headA;
    }
    while(difference)
        t0 = t0->next, difference--;
    while(t0)
    {
        if(t0 == t1)
            return t0;
        t0 = t0->next;
        t1 = t1->next;
    }
    return NULL;
}
