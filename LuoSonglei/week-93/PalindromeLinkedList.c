/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-23 08:46
Description : 
Source      : https://leetcode.com/problems/palindrome-linked-list/
*******************************************/
#include <stdbool.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};
//AC - 12ms;
bool isPalindrome0(struct ListNode* head)
{
    int* arr = (int*)malloc(sizeof(int));
    int size = 0;
    struct ListNode* p = head;
    while(p) //collect all values;
    {
        size++;
        arr = (int*)realloc(arr, sizeof(int)*size);
        arr[size-1] = p->val;
        p = p->next;
    }
    for(int i = 0; i < size/2; i++) //symmetric;
        if(arr[i] != arr[size-i-1])
            return false;
    return true;
}

#include <stdlib.h>
//AC - 12ms;
bool isPalindrome(struct ListNode* head)
{
    if(!head || !head->next) return true;
    struct ListNode *slow=head, *fast=head->next->next;
    while(fast && fast->next) //split into two halves while the right part might longer by 1 if the length of the link is odd;
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    fast = slow->next;
    slow->next = NULL;
    struct ListNode *cur, *pre, *next; //reverse the left linked and slow will become the head;
    cur = head->next;
    pre = head;
    pre->next = NULL;
    while(cur)
    {
        next = cur->next;
        cur->next = pre;
        pre = cur;
        cur = next;
    }
    if(fast->val != slow->val) fast = fast->next; //if the first node is unequal, move fast forward to the next;
    while(fast)
    {
        if(fast->val != slow->val)
            return false;
        fast = fast->next;
        slow = slow->next;
    }
    if(!fast || !slow) return false; //not all nodes have been compared - not symmetric;
    return true;
}
