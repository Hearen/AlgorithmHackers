/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 16:17
Description : 
Source      : https://leetcode.com/problems/binary-tree-preorder-traversal/
*******************************************/
#include <stdlib.h>
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};

void traverse(struct TreeNode* root, int** arr, int* returnSize)
{
    *returnSize += 1;
    *arr = (int*)realloc(*arr, sizeof(int)*(*returnSize));
    (*arr)[*returnSize-1] = root->val;
    if(root->left)
        traverse(root->left, arr, returnSize);
    if(root->right)
        traverse(root->right, arr, returnSize);
}
//AC - 0ms;
int* preorderTraversal0(struct TreeNode* root, int* returnSize)
{
    if(!root) return NULL;
    int* arr = (int*)malloc(sizeof(int));
    *returnSize = 0;
    traverse(root, &arr, returnSize);
    return arr;
}

void storeAndCollectLeftNodes(struct TreeNode* root, struct TreeNode*** stack, int* size, int** arr, int* returnSize)
{
    while(root)
    {
        *returnSize += 1;
        *arr = (int*)realloc(*arr, sizeof(int)*(*returnSize));
        (*arr)[*returnSize-1] = root->val;
        *stack = (struct TreeNode**)realloc(*stack, sizeof(struct TreeNode*)*(*size+1));
        *size += 1;
        (*stack)[*size-1] = root;
        root = root->left;
    }
}

//AC - 0ms;
int* preorderTraversal(struct TreeNode* root, int* returnSize)
{
    if(!root) return NULL;
    int* arr = (int*)malloc(sizeof(int));
    *returnSize = 0;
    struct TreeNode** stack = (struct TreeNode**)malloc(sizeof(struct TreeNode*));
    int size = 0;
    storeAndCollectLeftNodes(root, &stack, &size, &arr, returnSize);
    while(size)
    {
        root = stack[size-1];
        size--;
        if(root->right) //handle the right children of leftmost nodes;
            storeAndCollectLeftNodes(root->right, &stack, &size, &arr, returnSize);
    }
    return arr;
}
