/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-22 09:12
Description : 
Source      : https://leetcode.com/problems/remove-linked-list-elements/
*******************************************/
#include <stdlib.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};
//AC - 12ms;
struct ListNode* removeElements( struct ListNode* head, int val )
{
    struct ListNode *t = ( struct ListNode* )malloc(sizeof( struct ListNode ));
    struct ListNode *pre = t, *cur = head;
    t->next = NULL;
    while(cur)
    {
        if(cur->val != val)
        {
            pre->next = cur;
            pre = pre->next;
        }
        cur = cur->next;
    }
    pre->next = NULL;
    return t->next;
}
