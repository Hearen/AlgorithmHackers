/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-11 08:54
Description : 
Source      : https://leetcode.com/problems/count-of-smaller-numbers-after-self/
*******************************************/
#include <stdlib.h>
struct MyTreeNode
{
    int val, lessCount, count;
    struct MyTreeNode *left, *right;
};
typedef struct MyTreeNode TreeNode;

TreeNode* makeTreeNode(int val)
{
    TreeNode *node = (TreeNode*)malloc(sizeof(TreeNode));
    node->val = val;
    node->lessCount = 0;
    node->count = 1;
    node->left = node->right = NULL;
    return node;
}

void insert(TreeNode* root, int val, int *lessCount)
{
    int curVal = root->val;
    if(val < curVal)
    {
        root->lessCount++;
        if(NULL == root->left)
            root->left = makeTreeNode(val);
        else
            insert(root->left, val, lessCount);
    }
    else if(val > curVal)
    {
        *lessCount += root->lessCount + root->count;
        if(NULL == root->right)
            root->right = makeTreeNode(val);
        else
            insert(root->right, val, lessCount);
    }
    else
    {
        *lessCount += root->lessCount;
        root->count++;
        return ;
    }
}

//AC - 20ms;
int* countSmaller(int* nums, int size, int* returnSize)
{
    *returnSize = size;
    if(size == 0)
        return NULL;
    int *count = (int*)malloc(sizeof(int)*size);
    memset(count, 0, sizeof(int)*size);
    TreeNode *root = makeTreeNode(nums[size-1]);
    for(int i = size-2; i > -1; i--)
        insert(root, nums[i], count+i);
    return count;
}

