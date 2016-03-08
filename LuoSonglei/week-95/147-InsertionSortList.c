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
struct ListNode* insertionSortList(struct ListNode* head)
{
    struct ListNode* newHead = (struct ListNode*)malloc(sizeof(struct ListNode));
    newHead->next = NULL;
    struct ListNode *p=head, *next, *pre=newHead;
    while(p)
    {
        next = p->next;
        p->next = NULL;
        while(pre->next && pre->next->val<p->val)
            pre = pre->next;
        p->next = pre->next;
        pre->next = p;
        p = next;
        pre = newHead;
    }
    return newHead->next;
}
