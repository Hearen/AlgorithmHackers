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
    if(!head || !head->next || n==m) return head; //corner cases;
    int count = 0;
    struct ListNode *newHead = (struct ListNode*)malloc(sizeof(struct ListNode)); //allocate a new node as the 'head';
    newHead->next = head;
    struct ListNode *start=NULL, *pre=NULL, *next=NULL,*p = newHead;
    while(p) //till the (m-1)th node of the list;
    {
        if(count == m-1)
        {
            start = p; //record the (m-1)th node;
            break;
        }
        p = p->next;
        count++;
    }
    pre = start->next; //start to reverse, record the pre for being pointed to by p;
    p = pre->next; //record the next node of p in case of losing it;
    while(p)
    {
        if(count == n-1) //till the nth node of the list;
            break;
        next = p->next; //record the next of the p;
        p->next = pre; //reverse -> connect the p to its previous node;
        pre = p; //update pre and p;
        p = next;
        count++;
    }
    start->next->next = next; //connect the mth to the (n+1)th node;
    start->next = pre; //connect (m-1)th to the nth;
    return newHead->next; //return the m-to-n-reversed list;
}
