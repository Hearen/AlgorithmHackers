/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-21 08:32
Description : 
Source      : https://leetcode.com/problems/path-sum/
*******************************************/
#include <stdbool.h>
#include <stdlib.h>
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
bool traverse(struct TreeNode** stack, int top, int sum )
{
    struct TreeNode *root = stack[top];
    if(root->left==NULL && root->right==NULL)
    {
        int t = 0;
        for(int i = 0; i <= top; i++)
            t += stack[i]->val;
        return t == sum;
    }
    else
    {
        int t = top;
        bool left=false, right=false;
        if(root->left)
        {
            stack[++t] = root->left;
            left = traverse(stack, t, sum);
        }
        if(root->right)
        {
            stack[++top] = root->right;
            right = traverse(stack, top, sum);
        }
        return left || right;
    }
}

//the testing results are weird;
//the leaf node is that node without any child;
//AC - 8ms;
bool hasPathSum0( struct TreeNode* root, int sum )
{
    if(root == NULL)
        return false;
    int len = 100;
    struct TreeNode** stack = ( struct TreeNode** )malloc(sizeof( struct TreeNode* )*len);
    int top = -1;
    stack[++top] = root;
    return traverse(stack, top, sum);
}



//AC - 8ms;
bool hasPathSum1( struct TreeNode* root, int sum )
{
    if(!root)
        return false;
    if(root->left==NULL && root->right==NULL && root->val==sum)
        return true;
    int newSum = sum-root->val;
    return hasPathSum(root->left, newSum) || hasPathSum(root->right, newSum);
}

//AC - 4ms;
bool hasPathSum2( struct TreeNode* root, int sum )
{
    if(!root)
        return false;
    int newSum = sum-root->val;
    if(newSum==0 && root->left==NULL && root->right==NULL)
        return true;
    return hasPathSum(root->left, newSum) || hasPathSum(root->right, newSum);
}
