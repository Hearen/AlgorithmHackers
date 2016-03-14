/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-13 20:55
Description : Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
Source      : https://leetcode.com/problems/reorder-list/
*******************************************/
struct ListNode
{
    int val;
    struct ListNode *next;
};

#include <stdlib.h>
void reorderList(struct ListNode* head)
{
    if(!head || !head->next) return ;
    struct ListNode *slow=head, *fast=head->next;
    while(fast && fast->next) //split the list into two halves left part >= right part;
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    struct ListNode *right = slow->next; //get the right part;
    slow->next = NULL; //terminate the left part;

    struct ListNode *p, *next; 
    struct ListNode *rightHead = (struct ListNode*)malloc(sizeof(struct ListNode));
    rightHead->next = NULL;
    struct ListNode *t = rightHead;
    p = right;
    while(p) //reverse the right part;
    {
        next = p->next;
        p->next = t->next;
        t->next = p;
        p = next;
    }

    struct ListNode *newHead = (struct ListNode*)malloc(sizeof(struct ListNode));
    newHead->next = NULL;
    t = newHead;
    struct ListNode *left = head;
    right = rightHead->next;
    while(left || right) //connect the left and right one by one;
    {
        t->next = left;
        left = left->next; //before resetting in t->next=NULL, move left to the next;
        t = t->next;
        t->next = NULL;
        if(right)  //in case of odd length;
        {
            t->next = right;
            right = right->next;
            t = t->next;
            t->next = NULL;
        }
    }
    return ;
}
