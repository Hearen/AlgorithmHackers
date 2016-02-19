/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 15:39
Description : 
Source      :https://leetcode.com/problems/binary-tree-inorder-traversal/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};
#include <stdlib.h>
void traverse(struct TreeNode* root, int** arr, int* returnSize)
{
    if(!root) return ;
    if(root->left)
        traverse(root->left, arr, returnSize);
    *returnSize += 1;
    *arr = (int*)realloc(*arr, sizeof(int)*(*returnSize));
    (*arr)[*returnSize-1] = root->val;
    if(root->right)
        traverse(root->right, arr, returnSize);
}

//AC - 0ms;
int* inorderTraversal0(struct TreeNode* root, int* returnSize)
{
    if(!root) return NULL;
    *returnSize = 0;
    int* arr = (int*)malloc(sizeof(int));
    traverse(root, &arr, returnSize);
    return arr;
}


void collectLeftNodes(struct TreeNode* root, struct TreeNode*** stack, int* size)
{
    while(root)
    {
        *stack = (struct TreeNode**)realloc(*stack, sizeof(struct TreeNode*)*(*size+1));
        (*stack)[(*size)++] = root;
        root = root->left;
    }
}
//AC - 0ms;
int* inorderTraversal(struct TreeNode* root, int* returnSize)
{
    if(!root) return NULL;
    int* arr = (int*)malloc(sizeof(int));
    *returnSize = 0;
    struct TreeNode** stack = (struct TreeNode**)malloc(sizeof(struct TreeNode*));
    int size = 0; //the size of the stack index of top=size-1;
    collectLeftNodes(root, &stack, &size);
    while(size)
    {
        root = stack[size-1];
        size--;
        *returnSize += 1;
        arr = (int*)realloc(arr, sizeof(int)*(*returnSize));
        arr[*returnSize-1] = root->val; //collecting the leftmost;
        root = root->right; //preparing to collect the right children of the leftmost node;
        collectLeftNodes(root, &stack, &size);
    }
    return arr;
}
