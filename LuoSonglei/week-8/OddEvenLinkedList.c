/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 10:54
Description : 
Source      : https://leetcode.com/problems/odd-even-linked-list/
*******************************************/
#include <stdlib.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};
//AC - 4ms;
struct ListNode* oddEvenList( struct ListNode* head )
{
    if(head == NULL || head->next == NULL)
        return head;
    struct ListNode *odd = head;
    struct ListNode *even = head->next;
    struct ListNode *eHead = even;
    while(odd && even && even->next)
    {
        odd->next = even->next;
        odd = odd->next;
        even->next = odd->next;
        even = even->next;
    }
    odd->next = eHead;
    return head;
}
