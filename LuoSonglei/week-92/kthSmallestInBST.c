/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 14:22
Description : 
Source      : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};
#include <stdlib.h>

//AC - 12ms - an inorder solution;
int helper(struct TreeNode* root, int* k)
{
    if(root)
    {
        int ret = helper(root->left, k);
        if(!(*k)) return ret;
        if(!(*k-=1)) return root->val;
        return helper(root->right, k);
    }
}
int kthSmallest0(struct TreeNode* root, int k)
{
    return helper(root, &k);
}

//the test cases might not be modified;
int kthSmallest(struct TreeNode* root, int k)
{
    while(root)
    {
        if(!root->left)
        {
            k--;
            if(!k) return root->val;
            root = root->right;
        }
        else
        {
            struct TreeNode* pre = root->left;
            while(pre->right && pre->right!=root)
                pre = pre->right;
            if(!pre->right)
            {
                pre->right = root;
                root = root->left;
            }
            else
            {
                k--;
                if(!k) return root->val;
                pre->right = NULL;
                root = root->right;
            }
        }
    }
}
