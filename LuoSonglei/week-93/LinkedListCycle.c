/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-24 16:02
Description : 
Source      : https://leetcode.com/problems/linked-list-cycle/
*******************************************/
#include <stdbool.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};
bool hasCycle(struct ListNode* head)
{
    if(!head || !head->next) return false;
    struct ListNode *slow=head, *fast=head->next;
    while(fast && fast->next)
    {
        slow = slow->next;
        fast = fast->next->next;
        if(slow == fast)
            return true;
    }
    return false;
}
