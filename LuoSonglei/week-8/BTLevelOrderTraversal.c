/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 10:03
Description : 
Source      : https://leetcode.com/problems/binary-tree-level-order-traversal/
*******************************************/
#define LEN 1000
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
int** levelOrder( struct TreeNode* root, int** colSizes, int* returnSize )
{
    struct TreeNode** stack0 = ( struct TreeNode** )malloc(sizeof( struct TreeNode* )*LEN);
    struct TreeNode** stack1 = ( struct TreeNode** )malloc(sizeof( struct TreeNode* )*LEN);
    int top0 = -1; 
    int top1 = -1;
    colSizes = (int**)malloc(sizeof(int*)*LEN);
    int** arrs = (int**)malloc(sizeof(int*)*LEN);
    stack0[++top0] = root;
    *returnSize = 0;
    while(top0)
    {
        *colSizes[*returnSize] = top0+1;
        arrs[*returnSize] = (int*)malloc(sizeof(int)*(top0+1));
        for(int i = 0; i <= top0; i++)
        {
            colSizes[*returnSize][i] = stack0[i]->val;
            if(stack0[i]->left)
                stack1[++top1] = stack0[i]->left;
            if(stack0[i]->right)
                stack1[++top1] = stack0[i]->right;
        }
        (*returnSize)++;
        top0 = top1;
        struct TreeNode** t = stack0;
        stack0 = stack1;
        stack1 = t; 
    }
    return arrs;
}
