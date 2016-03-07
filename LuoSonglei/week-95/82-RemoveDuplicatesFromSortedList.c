/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-07 16:04
Description : Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.j
Source      : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
*******************************************/
#include <stdlib.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};

//AC - 4ms;
struct ListNode *deleteDuplicates(struct ListNode* head)
{
    if(!head || !head->next) return head; //needless to handle;
    struct ListNode *newHead = (struct ListNode*)malloc(sizeof(struct ListNode)); //we need a head node for more convenient handling needless to consider the first node separately now ^^;
    newHead->next = head;
    struct ListNode *pre=newHead, *cur=head;
    int preVal = head->val-1; //record the previous value of the current node, the default value should affect the first node collecting - so we set it different from head->val;
    while(cur)
    {
        if(cur->val!=preVal && (!cur->next||cur->next->val!=cur->val)) //only when both the previous value and the next are not equal to the current one - by the way, the next node is null will definitely considered unequal, we can then collect it;
        {
            pre->next = cur;
            pre = pre->next;
        }
        preVal = cur->val;
        cur = cur->next;
    }
    pre->next = NULL; //terminate the list;
    return newHead->next;
}
