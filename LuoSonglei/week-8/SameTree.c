/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 08:20
Description : 
Source      : https://leetcode.com/problems/same-tree/
*******************************************/
#include <stdbool.h>
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
//AC - 0ms;
bool isSameTree( struct TreeNode* p, struct TreeNode* q )
{
    if(!p && !q)
        return true;
    if(p && q && p->val == q->val && isSameTree(p->left, q->left) 
                && isSameTree(p->right, q->right))
        return true;
    return false;
}
