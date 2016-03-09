/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-08 21:34
Description : Sort a linked list using insertion sort.
Source      : https://leetcode.com/problems/insertion-sort-list/
*******************************************/
#include <cstdbool.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};

//AC - 68ms;
struct ListNode* insertionSortList0(struct ListNode* head)
{
    struct ListNode* newHead = (struct ListNode*)malloc(sizeof(struct ListNode));
    newHead->next = NULL; //in case of uncertainty;
    struct ListNode *p=head, *next, *pre=newHead;
    while(p)
    {
        next = p->next; //store the next node;
        p->next = NULL;
        while(pre->next && pre->next->val<p->val)
            pre = pre->next;
        p->next = pre->next; //point to the next node of the current inserting position;
        pre->next = p; 
        pre = newHead; //start over from the very beginning;
        p = next; //move to the next node;
    }
    return newHead->next;
}

//AC - 12ms;
struct ListNode* insertionSortList(struct ListNode* head)
{
    if(!head || !head->next) return head; //we have to handle the corner case now, since we adopted last and check head->val the first round;
    struct ListNode* newHead = (struct ListNode*)malloc(sizeof(struct ListNode));
    newHead->next = NULL; //in case of uncertainty;
    newHead->val = head->val-1; //to update the last for the first insertion;
    struct ListNode *p=head, *next, *pre=newHead, *last=newHead;
    while(p)
    {
        next = p->next;
        p->next = NULL;
        if(last->val < p->val)
        {
            last->next = p;
            last = p;
        }
        else
        {
            while(pre->next && pre->next->val<p->val)
                pre = pre->next;
            p->next = pre->next; //point to the next node of the current inserting position;
            pre->next = p; 
            pre = newHead; //start over from the very beginning;
        }
        p = next; //move to the next node;
    }
    return newHead->next;
}
