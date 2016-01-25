/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 10:03
Description : 
Source      : https://leetcode.com/problems/binary-tree-level-order-traversal/
*******************************************/
#include <stdlib.h>
#define LEN 1000
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
//AC - 4ms;
int** levelOrder( struct TreeNode* root, int** colSizes, int* returnSize )
{
    if(!root)
        return NULL;
    struct TreeNode** stack0 = ( struct TreeNode** )malloc(sizeof( struct TreeNode* )*LEN);
    struct TreeNode** stack1 = ( struct TreeNode** )malloc(sizeof( struct TreeNode* )*LEN);
    struct TreeNode** t;
    int top0 = -1; 
    int top1 = -1;
    *colSizes = (int*)malloc(sizeof(int)*LEN);
    int** arrs = (int**)malloc(sizeof(int*)*LEN);
    stack0[++top0] = root;
    *returnSize = 0;
    while(top0 > -1)
    {
        top1 = -1;
        (*colSizes)[*returnSize] = top0+1; //the brackets are quite essential here for colSizes;
        arrs[*returnSize] = (int*)malloc(sizeof(int)*(top0+1));
        for(int i = 0; i <= top0; i++)
        {
            arrs[*returnSize][i] = stack0[i]->val;
            if(stack0[i]->left)
                stack1[++top1] = stack0[i]->left;
            if(stack0[i]->right)
                stack1[++top1] = stack0[i]->right;
        }
        (*returnSize)++;
        top0 = top1;
        t = stack0;
        stack0 = stack1;
        stack1 = t; 
    }
    return arrs;
}
