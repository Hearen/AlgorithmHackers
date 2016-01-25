/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 14:10
Description : 
Source      : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*******************************************/
#include <stdlib.h>
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};

//AC - 20ms;
struct TreeNode* lowestCommonAncestor( struct TreeNode* root, struct TreeNode *p, struct TreeNode* q )
{
    if(root == NULL || root == p || root == q ||
            (root->val > p->val && root->val < q->val) ||
            (root->val < p->val && root->val > q->val)) return root;
    if(root->val > p->val && root->val > q->val)
        return lowestCommonAncestor(root->left, p, q);
    else
        return lowestCommonAncestor(root->right, p, q);
}

//AC - 24ms;
struct TreeNode* lowestCommonAncestor1( struct TreeNode* root, struct TreeNode* p, struct TreeNode* q )
{
    if(root == NULL || root == p || root == q) 
        return root;
    int min = p->val > q->val? q->val : p->val;
    int max =  p->val < q->val? q->val : p->val;
    while(1)
    {
        if(root->val > max)
            root = root->left;
        else if(root->val < min)
            root = root->right;
        else 
            return root;
    }
}

//AC - 24ms;
struct TreeNode* lowestCommonAncestor2( struct TreeNode* root, struct TreeNode *p, struct TreeNode* q )
{
    if(!p) return q;
    if(!q) return p;
    if(!root || root == p || root == q) return root;
    struct TreeNode *left = lowestCommonAncestor(root->left, p, q);
    struct TreeNode *right = lowestCommonAncestor(root->right, p, q);
    if(left&&right) return root;
    if(!left) return right;
    if(!right) return left;
}

