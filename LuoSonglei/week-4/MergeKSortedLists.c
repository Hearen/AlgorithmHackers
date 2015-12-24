/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-24 21:20
Description : 
Source      : https://leetcode.com/problems/merge-k-sorted-lists/
*******************************************/

struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode* merge(struct ListNode* l, struct ListNode* r)
{
    struct ListNode head;
    struct ListNode *p = &head;
    while(l && r)
    {
        if(l->val <= r->val)
        {
            p->next = l;
            l = l->next;
        }
        else
        {
            p->next = r;
            r = r->next;
        }
        p = p->next;
    }
    p->next = (l? l : r);
    return head.next;
}

//AC - 392ms;
//multi-thread programming might be helpful in this case;
struct ListNode* mergeKLists(struct ListNode** lists, int listsSize)
{
    struct ListNode** stack0 = (struct ListNode**)malloc(sizeof(struct ListNode*) * listsSize);
    struct ListNode** stack1 = (struct ListNode**)malloc(sizeof(struct ListNode*) * listsSize);
    int top0 = -1, top1 = -1;
    for(int i = 0; i < listsSize; i++)
        stack0[++top0] = lists[i];
    while(top0 > 0)
    {
        while(top0 > -1)
        {
            if(top0 > 0)
                stack1[++top1] = merge(stack0[top0--], stack0[top0--]);
            else
                stack1[++top1] = stack0[top0--];
        }
        top0 = top1;
        top1 = -1;
        struct ListNode** tmp = stack0;
        stack0 = stack1;
        stack1 = tmp;
    }
    return stack0[top0];
}
