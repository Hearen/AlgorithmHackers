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
#define FOO

struct TreeNode* build(int* preorder, int pBegin, int pEnd, int* inorder, int iBegin, int iEnd)
{
    #ifdef FOO
        printf("pBegin: %d\tpEnd: %d\tiBegin: %d\tiEnd: %d\n", pBegin, pEnd, iBegin, iEnd);
    #endif
    if(pBegin > pEnd)
        return NULL;
    if(pBegin == pEnd)
    {
        struct TreeNode* last =  (struct TreeNode*)malloc(sizeof(struct TreeNode)); 
        last->val = preorder[pBegin];
        return last;
    }
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    int mid = iBegin;
    for(; mid <= iEnd; mid++)
        if(inorder[mid] == preorder[pBegin])
            break;
    int left = mid - iBegin;
    #ifdef FOO
        printf("\n\n**********root value: %d\n", inorder[mid]);
        printf("left part\n");
        printf("preorder\n");
        for(int i = pBegin+1; i<=pBegin+left; i++)
            printf("%d\t", preorder[i]);
        printf("\ninorder\n");
        for(int i = iBegin; i<=mid-1; i++)
            printf("%d\t", inorder[i]);
        printf("\nright part***************\n");
        printf("preorder\n");
        for(int i = pBegin+left+1; i<=pEnd; i++)
            printf("%d\t", preorder[i]);
        printf("\ninorder\n");
        for(int i = mid+1; i<=iEnd; i++)
            printf("%d\t", inorder[i]);
        printf("\nend of root: %d****************\n\n\n", inorder[mid]);
    #endif
    root->val = preorder[pBegin];
    root->left = build(preorder, pBegin+1, pBegin+left, inorder, iBegin, mid-1);
    root->right = build(preorder, pBegin+left+1, pEnd, inorder, mid+1, iEnd);
    return root;
}

//Run through encountered test cases but just Runtime Error!
struct TreeNode* buildTree(int* preorder, int pSize, int* inorder, int iSize)
{
    if(pSize == 0)
        return NULL;
    return build(preorder, 0, pSize-1, inorder, 0, iSize-1);
}
