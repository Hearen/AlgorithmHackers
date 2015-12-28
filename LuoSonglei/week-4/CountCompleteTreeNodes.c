/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-28 09:07
Description : 
Source      : https://leetcode.com/problems/count-complete-tree-nodes/
*******************************************/
#include <stdio.h>
struct TreeNode
{
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

//Time Limit Exceeded;
int countNodes(struct TreeNode* root)
{
    if(root == NULL)
        return 0;
    return 1+countNodes(root->left)+countNodes(root->right);
}
