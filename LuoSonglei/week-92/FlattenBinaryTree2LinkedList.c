/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 19:20
Description : 
Source      : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};

#include <stdlib.h>
struct TreeNode* traverseLeft(struct TreeNode* root)
{
    if(!root->left &&!root->right) return root;
    struct TreeNode* t = root->right;
    root->right = root->left;
    struct TreeNode *leftmost = root; //in case of NULL left;
    if(root->left)
        leftmost = traverseLeft(root->left);
    root->left = NULL;
    leftmost->right = t;
    if(t)
        traverseLeft(t); 
}

//AC - 4ms;
void flatten(struct TreeNode* root)
{
    if(!root) return ;
    traverseLeft(root);
}
