/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-14 16:29
Description : 
Source      : https://leetcode.com/problems/delete-node-in-a-linked-list/
*******************************************/

struct ListNode
{
    int val;
    struct ListNode *next;
};

//AC - 4ms;
void deleteNode( struct ListNode* node )
{
    node->val = node->next->val;
    node->next = node->next->next;
}
