/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-06 20:45
Description : 
Source      : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*******************************************/

#include <stdlib.h>
struct TreeNode
{
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};
struct TreeNode* build(int* preorder, int pBegin, int pEnd, int* inorder, int iBegin, int iEnd)
{
    if(pBegin > pEnd)
        return NULL;
    if(pBegin == pEnd)
    {
        struct TreeNode* last =  (struct TreeNode*)malloc(sizeof(struct TreeNode)); 
        last->left = NULL, last->right = NULL;
        last->val = preorder[pBegin];
        return last;
    }
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->left = NULL, root->right = NULL;
    int mid = iBegin;
    for(; mid <= iEnd; mid++)
        if(inorder[mid] == preorder[pBegin])
            break;
    int left = mid - iBegin;
    root->val = preorder[pBegin];
    root->left = build(preorder, pBegin+1, pBegin+left, inorder, iBegin, mid-1);
    root->right = build(preorder, pBegin+left+1, pEnd, inorder, mid+1, iEnd);
    return root;
}

//AC - 20ms;
//Initialization part should be handled carefully otherwise weird error might occur;
struct TreeNode* buildTree0(int* preorder, int pSize, int* inorder, int iSize)
{
    if(pSize == 0)
        return NULL;
    return build(preorder, 0, pSize-1, inorder, 0, iSize-1);
}

//AC - 16ms;
struct TreeNode* buildTree1(int* preorder, int pSize, int* inorder, int iSize)
{
    if(pSize == 0)
        return NULL;
    struct TreeNode *root = ( struct TreeNode* )malloc(sizeof( struct TreeNode ));
    root->val = *preorder;
    int i = 0;
    while(inorder[i] != *preorder) i++;
    root->left = buildTree(preorder+1, i, inorder, i);
    root->right = buildTree(preorder+i+1, pSize-i-1, inorder+i+1, iSize-i-1);
    return root;
}
