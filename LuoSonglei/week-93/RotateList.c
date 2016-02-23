/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-23 11:01
Description : 
Source      : https://leetcode.com/problems/rotate-list/
*******************************************/
struct ListNode
{
    int val;
    struct ListNode *next;
};
#include <stdlib.h>
//AC - 4ms;
struct ListNode* rotateRight(struct ListNode* head, int k)
{
    if(!head) return NULL;
    int len = 0;
    struct ListNode* p = head;
    while(p)
        len++, p = p->next;
    k %= len; //after a circle of rotation, the chain will be the same;
    if(!k) return head;
    struct ListNode *cur=head, *kth=head;
    while(k) //move forward by k nodes;
        kth=kth->next, k--;
    while(kth->next) //there will be k nodes after cur - end of the loop;
    {
        cur = cur->next;
        kth = kth->next;
    }
    kth = cur->next; //the head of the right chain;
    cur->next = NULL;
    cur = kth; //the new head;
    while(kth->next)
        kth = kth->next; //move to the end of the right chain;
    kth->next = head; //connect the left to the end of the right;
    return cur;
}
