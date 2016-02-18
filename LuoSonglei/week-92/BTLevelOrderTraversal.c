/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-18 20:16
Description : 
Source      : https://leetcode.com/problems/binary-tree-level-order-traversal/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
#include <stdlib.h>
//AC - 0ms;
int** levelOrder( struct TreeNode* root, int** colSize, int* returnSize )
{
    if(!root) return NULL;
    struct TreeNode** queue0 = (struct TreeNode*)malloc(sizeof(struct TreeNode*));
    struct TreeNode** queue1 = (struct TreeNode*)malloc(sizeof(struct TreeNode*));
    int size = 1;
    queue0[0] = root;
    int **arr = (int**)malloc(sizeof(int*)); //before revoking realloc, we have to provide an address first;
    *returnSize = 0;
    while(size)
    {
        *returnSize += 1;
        *colSize = (int*)realloc(*colSize, sizeof(int)*(*returnSize));
        (*colSize)[*returnSize-1] = size;
        arr = (int**)realloc(arr, sizeof(int*)*(*returnSize));
        arr[*returnSize-1] = (int*)malloc(sizeof(int)*size);
        queue1 = (struct TreeNode*)realloc(queue1, sizeof(struct TreeNode*)*2*size);
        int index = 0;
        for(int i = 0; i < size; i++)
        {
            arr[*returnSize-1][i] = queue0[i]->val;
            if(queue0[i]->left)
                queue1[index++] = queue0[i]->left;
            if(queue0[i]->right)
                queue1[index++] = queue0[i]->right;
        }
        struct TreeNode** t = queue0; queue0 = queue1; queue1 = t;
        size = index;
    }
    return arr;
}
