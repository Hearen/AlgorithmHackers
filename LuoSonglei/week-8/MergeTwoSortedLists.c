/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 16:38
Description : 
Source      : https://leetcode.com/problems/merge-two-sorted-lists/
*******************************************/
struct ListNode
{
    int val;
    struct ListNode *next;
};
//AC - 4ms;
struct ListNode* mergeTwoLists( struct ListNode* l1, struct ListNode* l2 )
{
    struct ListNode *t = ( struct ListNode* )malloc(sizeof( struct ListNode ));
    struct ListNode *t0 = t;
    while(l1 && l2)
    {
        if(l1->val > l2->val)
        {
            t0->next = l2;
            l2 = l2->next;
        }
        else
        {
            t0->next = l1;
            l1 = l1->next;
        }
        t0 = t0->next;
    }
    if(l1)
        t0->next = l1;
    if(l2)
        t0->next = l2;
    return t->next;
}
