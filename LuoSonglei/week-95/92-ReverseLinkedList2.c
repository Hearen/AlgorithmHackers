/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-07 14:43
Description : Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
Source      : https://leetcode.com/problems/reverse-linked-list-ii/
*******************************************/
#include <stdlib.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};

//AC - 0ms;
struct ListNode* reverseBetween(struct ListNode* head, int m, int n)
{
    if(!head || !head->next || n==m) return head;
    int count = 0;
    struct ListNode *newHead = (struct ListNode*)malloc(sizeof(struct ListNode));
    newHead->next = head;
    struct ListNode *start=NULL, *pre=NULL, *next=NULL,*p = newHead;
    while(p)
    {
        if(count == m-1)
        {
            start = p;
            break;
        }
        p = p->next;
        count++;
    }
    pre = start->next;
    p = pre->next;
    while(p)
    {
        if(count == n-1)
            break;
        next = p->next;
        p->next = pre;
        pre = p;
        p = next;
        count++;
    }
    start->next->next = next;
    start->next = pre;
    return newHead->next;
}
