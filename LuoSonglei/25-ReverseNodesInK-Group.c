/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-14 11:03
Description : Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
Source      : https://leetcode.com/problems/reverse-nodes-in-k-group/
*******************************************/
#include <stdlib.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};
struct ListNode* reverseList(struct ListNode* head) //reverse a linked list by insertion mode;
{
    struct ListNode *newHead = (struct ListNode*)malloc(sizeof(struct ListNode));
    newHead->next = NULL;
    struct ListNode *t = newHead;
    struct ListNode *p=head, *next;
    while(p)
    {
        next = p->next; //store the next pointer;
        p->next = t->next; //insert p just after the head pointer;
        t->next = p; //connect p;
        p = next; //move to the next;
    }
    return newHead->next;
}


//AC - 8ms;
struct ListNode* reverseKGroup(struct ListNode* head, int k)
{
    struct ListNode *newHead = (struct ListNode*)malloc(sizeof(struct ListNode));
    newHead->next = NULL;
    struct ListNode *t=newHead, *last;
    struct ListNode *p = head, *next, *start;
    while(p)
    {
        start = p; //store the start for reversal;
        last = start; //after reversal, the start will be the last;
        int count = k-1; //move forward k-1 times to get the group of length k;
        while(count && p)
        {
            p = p->next;
            count--;
        }
        if(!p) //reached the end before the end of the group, directly connect it without reversal;
        {
            t->next = start;
            break;
        }
        next = p->next; //store the next;
        p->next = NULL; //terminate the current group;
        t->next = reverseList(start); //reverse the group;
        p = next;
        t = last; //move t to the last of the collecting list;
    }
    return newHead->next; //using a head node will always make the list operations much simpler;
}
