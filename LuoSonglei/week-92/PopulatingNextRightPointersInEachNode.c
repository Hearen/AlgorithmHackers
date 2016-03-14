/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 11:18
Description : 
Source      : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
*******************************************/
struct TreeLinkNode
{
    int val;
    struct TreeLinkNode *left, *right, *next;
};
#include <stdlib.h>
//AC - 4ms;
void connect(struct TreeLinkNode* root)
{
    if(!root || !root->left) return ;
    struct TreeLinkNode *p = root, *nextFirst;
    root->next = NULL;
    while(p && p->left)
    {
        nextFirst = p->left;
        while(p && p->left)
        {
            p->left->next = p->right;
            p->right->next = NULL;
            if(p->next)
                p->right->next = p->next->left;
            p = p->next;
        }
        p = nextFirst;
    }
}
