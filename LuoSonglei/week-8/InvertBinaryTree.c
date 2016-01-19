/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-19 08:12
Description : 
Source      : https://leetcode.com/problems/invert-binary-tree/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
//AC - 0ms;
struct TreeNode* invertTree( struct TreeNode* root )
{
    if(root)
    {
        struct TreeNode *t = root->left;
        root->left = root->right;
        root->right = t;
        invertTree(root->left);
        invertTree(root->right);
    }
    return root;
}
