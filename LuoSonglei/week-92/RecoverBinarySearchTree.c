/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 19:19
Description : 
Source      : https://leetcode.com/problems/recover-binary-search-tree/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};
#include <stdlib.h>
void traverse(struct TreeNode* root, struct TreeNode** pre, struct TreeNode** first, struct TreeNode** second)
{
    if(!root) return ;
    traverse(root->left, pre, first, second);
    if((*pre) && (*pre)->val>root->val) //check whether the previous node is abnormal in in-order traversal;
    {
        if(!(*first)) //if *first is never used then it should be used to store the bigger; 
            *first=*pre; 
        *second = root; //the two swapped nodes can be adjacent and distant;
    }
    *pre = root; //store the previous node in in-order traversal;
    traverse(root->right, pre, first, second);
}
//AC - 20ms;
void recoverTree(struct TreeNode* root)
{
    struct TreeNode *first=NULL, *second=NULL, *pre=NULL;
    traverse(root, &pre, &first, &second);
    if(first&&second)
    {
        int t = first->val;
        first->val = second->val;
        second->val = t;
    }
}
