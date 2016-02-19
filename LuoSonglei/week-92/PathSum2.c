/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 14:21
Description : 
Source      : https://leetcode.com/problems/path-sum-ii/
*******************************************/
#include <stdlib.h>
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};
void traverse(struct TreeNode* root, int sum, struct TreeNode** stack, int top, int*** arr, int** colSize, int* returnSize)
{
    if(!root->left && !root->right) 
    {
        if(root->val == sum)
        {
            *returnSize += 1;
            *arr = (int**)realloc(*arr, sizeof(int*)*(*returnSize));
            *colSize = (int*)realloc(*colSize, sizeof(int)*(*returnSize));
            int size = top+1;
            (*colSize)[*returnSize-1] = size;
            (*arr)[*returnSize-1] = (int*)malloc(sizeof(int)*size);
            for(int i = 0; i < size; i++)
                (*arr)[*returnSize-1][i] = (*stack)[i].val;
        }
        return ;
    }
    sum -= root->val;
    *stack = (struct TreeNode*)realloc(*stack, sizeof(struct TreeNode)*(top+2));
    if(root->left)
    {
        (*stack)[1+top] = *(root->left);
        traverse(root->left, sum, stack, top+1, arr, colSize, returnSize);
    }
    if(root->right)
    {
        (*stack)[1+top] = *(root->right);
        traverse(root->right, sum, stack, top+1, arr, colSize, returnSize);
    }
}

//AC - 8ms - to realloc an array, we have to provide the address of the array like colSize and arr in this solution;
int** pathSum(struct TreeNode* root, int sum, int** colSize, int* returnSize)
{
    if(!root) return NULL;
    int **arr = (int**)malloc(sizeof(int*));
    *colSize = (int*)malloc(sizeof(int*));
    *returnSize = 0;
    struct TreeNode* stack = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    int top = -1;
    stack[++top] = *root;
    traverse(root, sum, &stack, top,  &arr, colSize, returnSize);
    return arr;
}

