/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-22 08:59
Description : 
Source      : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*******************************************/
#include <stdlib.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};

//AC - 0ms;
struct ListNode* removeNthFromEnd( struct ListNode* head, int n )
{
    struct ListNode *t0 = head, *t1 = head;
    while(n)
        t0 = t0->next, n--;
    if(!t0)
    {
        if(head->next == NULL)
            return NULL;
        else
            return head->next;
    }
    while(t0->next)
    {
        t0 = t0->next;
        t1 = t1->next;
    }
    if(t1->next->next)
        t1->next = t1->next->next;
    else
        t1->next = NULL;
    return head;
}
