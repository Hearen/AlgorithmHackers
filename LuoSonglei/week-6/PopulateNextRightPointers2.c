/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-06 21:36
Description : 
Source      : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
*******************************************/
#include <stdlib.h>
struct TreeLinkNode
{
    int val;
    struct TreeLinkNode *left, *right, *next;
};

#define FOO
void traverse(struct TreeLinkNode** stack0, struct TreeLinkNode** stack1, int top)
{
    if(top < 0)
        return;
    int index = -1;
    for(int i = 0; i <= top; i++)
    {
        if(i+1<=top)
            stack0[i]->next = stack0[i+1];
        if(stack0[i]->left != NULL)
            stack1[++index] = stack0[i]->left;
        if(stack0[i]->right != NULL)
            stack1[++index] = stack0[i]->right;
    }
    top = index;
    traverse(stack1, stack0, top);
}
//AC - 8ms;
void connect(struct TreeLinkNode *root)
{
    if(root == NULL)
        return NULL;
    int len = 1000;
    struct TreeLinkNode** stack0 = (struct TreeLinkNode**)malloc(sizeof(struct TreeLinkNode*)*len);
    struct TreeLinkNode** stack1 = (struct TreeLinkNode**)malloc(sizeof(struct TreeLinkNode*)*len);
    int top = -1;
    stack0[++top] = root;
    traverse(stack0, stack1, top);
}
