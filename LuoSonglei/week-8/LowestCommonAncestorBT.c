/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 14:32
Description : 
Source      : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};

//AC - 16ms;
struct TreeNode* lowestCommonAncestor0( struct TreeNode* root, struct TreeNode *p, struct TreeNode* q )
{
    if(!root || root == p || root == q) return root;
    struct TreeNode *left = lowestCommonAncestor(root->left, p, q);
    struct TreeNode *right = lowestCommonAncestor(root->right, p, q);
    if(left&&right) return root;
    if(!left) return right;
    if(!right) return left;
}

//AC - 12ms;
struct TreeNode* lowestCommonAncestor1( struct TreeNode* root, struct TreeNode *p, struct TreeNode* q )
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

