/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-06 08:16
Description :     for()
Source      : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
*******************************************/
#include <stdlib.h>
#define FOO
struct ListNode{
    int val;
    struct ListNode* next;
};

struct TreeNode
{
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

//Currently the tested cases are all passed but the Runtime Error just came out from nowhere;
struct TreeNode* sortedListToBST(struct ListNode* head)
{
    if(head == NULL)
        return NULL;
    if(head->next == NULL)
    {
        struct TreeNode *t = (struct TreeNode*)malloc(sizeof(struct TreeNode));
        t->val = head->val;
        return t;
    }
    struct ListNode* slow = head;
    struct ListNode* fast = head->next->next;
    while(fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    struct ListNode *left=head, *right=slow->next;
    slow->next = NULL;
    #ifdef FOO
        struct ListNode *p = left, *q = right;
        printf("left part: \t");
        while(p != NULL)
        {
            printf("%d\t", p->val);
            p = p->next;
                                
        }
        printf("\n");
        printf("right part: \t");
        while(q != NULL)
        {
            printf("%d\t", q->val);
            q = q->next;
        }
        printf("\n");
        //printf("left: %d\tcenter: %d\tright: %d\n", left.next->val, right.next->val, right.next->next->val);
    #endif
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->val = right->val;
    root->left = sortedListToBST(left);
    root->right = sortedListToBST(right->next);
    return root;
}
