/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 12:21
Description : 
Source      : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
*******************************************/
struct TreeLinkNode
{
    int val;
    struct TreeLinkNode *left, *right, *next;
};
#include <stdlib.h>
//AC - 8ms;
void connect(struct TreeLinkNode* root)
{
    if(!root) return ;
    struct TreeLinkNode *p = root, *nextFirst;
    while(p)
    {
        nextFirst = NULL;
        while(p)
        {
            if(p->left)
            {
                nextFirst = p->left;
                break;
            }
            if(p->right)
            {
                nextFirst = p->right;
                break;
            }
            p = p->next;
        }
        struct TreeLinkNode *cur=nextFirst, *next;
        while(p)
        {
            next = p->left;
            if(next && cur!=next)
            {
                cur->next = next;
                cur = next;
            }
            next = p->right;
            if(next && cur!=next)
            {
                cur->next = next;
                cur = next;
            }
            p = p->next;
        }
        p = nextFirst;
    }
}
