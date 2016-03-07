/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-07 21:51
Description : Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
Source      : https://leetcode.com/problems/swap-nodes-in-pairs/
*******************************************/
struct ListNode
{
    int val;
    struct ListNode *next;
};

//AC - 0ms;
struct ListNode* swapPairs(struct ListNode* head)
{
    if(!head || !head->next) return head;
    struct ListNode *t = (struct ListNode*)malloc(sizeof(struct ListNode));
    t->next = head;
    struct ListNode *pre=t, *cur=head, *next=head->next;
    while(cur && cur->next)
    {
        next = cur->next->next;
        pre->next = cur->next;
        cur->next->next = cur;
        cur->next = next;
        pre = pre->next->next;
        cur = next;

    }
    return t->next;
}
