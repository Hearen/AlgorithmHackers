/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-13 08:32
Description : 
Source      : https://leetcode.com/problems/reverse-linked-list/
*******************************************/
#include <stdlib.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};

//AC - 0ms;
struct ListNode* reverseList(struct ListNode *head)
{
    struct ListNode *t0 = head;
    struct ListNode *t1 = (struct ListNode*)malloc(sizeof(struct ListNode));
    t1->next = NULL; //this initialization is essential;
    while(head != NULL)
    {
        t0 = head;
        head = head->next;
        t0->next = t1->next;
        t1->next = t0;
    }
    return t1->next;
}
