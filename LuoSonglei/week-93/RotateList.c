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
    k %= len;
    if(!k) return head;
    struct ListNode *cur=head, *kth=head;
    while(k)
        kth=kth->next, k--;
    while(kth->next)
    {
        cur = cur->next;
        kth = kth->next;
    }
    kth = cur->next;
    cur->next = NULL;
    cur = kth;
    while(kth->next)
        kth = kth->next;
    kth->next = head;
    return cur;
}
