/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-28 09:48
Description : 
Source      : https://leetcode.com/problems/add-two-numbers/
*******************************************/
struct ListNode
{
    int val;
    struct ListNode *next;
};
#include <stdlib.h>
//AC - 20ms;
struct ListNode* addTwoNumbers(struct ListNode* link1, struct ListNode* link2)
{
    struct ListNode *head = (struct ListNode*)malloc(sizeof(struct ListNode));
    head->next = NULL;
    struct ListNode *tmp = head;
    struct ListNode *l1=link1, *l2=link2;
    int val = 0;
    int C = 0;
    while(l1 || l2)
    {
        struct ListNode *t = (struct ListNode*)malloc(sizeof(struct ListNode));
        if(!l1 || !l2)
            val = !l1? l2->val : l1->val;
        else
            val = l1->val+l2->val;
        t->val = (val+C)%10;
        t->next = NULL;
        tmp->next = t;
        tmp = tmp->next;
        if((val+C)>=10)
            C = 1;
        else
            C = 0;
        if(l1) l1 = l1->next;
        if(l2) l2 = l2->next;
    }
    if(C)
    {
        struct ListNode *t = (struct ListNode*)malloc(sizeof(struct ListNode));
        t->val = 1;
        t->next = NULL;
        tmp->next = t;
    }
    return head->next;
}
