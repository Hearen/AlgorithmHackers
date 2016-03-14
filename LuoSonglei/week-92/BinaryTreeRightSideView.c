/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 16:44
Description : 
Source      : https://leetcode.com/problems/binary-tree-right-side-view/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};
#include <stdlib.h>
//AC - 0ms;
int* rightSideView(struct TreeNode* root, int* returnSize)
{
    if(!root) return NULL;
    int* arr = (int*)malloc(sizeof(int));
    *returnSize = 0;
    struct TreeNode** queue0 = (struct TreeNode**)malloc(sizeof(struct TreeNode*));
    struct TreeNode** queue1 = (struct TreeNode**)malloc(sizeof(struct TreeNode*));
    int size=1, count=0;
    queue0[size-1] = root;
    while(size)
    {
        count = 0;
        queue1 = (struct TreeNode**)realloc(queue1, sizeof(struct TreeNode*)*2*size);
        for(int i = 0; i < size; i++)
        {
            if(queue0[i]->left)
                queue1[count++] = queue0[i]->left;
            if(queue0[i]->right)
                queue1[count++] = queue0[i]->right;
        }
        *returnSize += 1;
        arr = (int*)realloc(arr, sizeof(int)*(*returnSize));
        arr[*returnSize-1] = queue0[size-1]->val;
        struct TreeNode** t = queue0; queue0=queue1; queue1=t;
        size = count;
    }
    return arr;
}
