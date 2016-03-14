/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-18 21:25
Description : 
Source      : https://leetcode.com/problems/validate-binary-search-tree/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
#include <stdbool.h>
void traverse(struct TreeNode* root, int** arr, int* size)
{
    if(root->left)
        traverse(root->left, arr, size);
    *size += 1;
    *arr = (int*)realloc(*arr, sizeof(int)*(*size));
    (*arr)[*size-1] = root->val;
    if(root->right)
        traverse(root->right, arr, size);
}

//AC - 8ms;
bool isValidBST(struct TreeNode* root)
{
    if(!root) return true;
    int* arr = (int*)malloc(sizeof(int));
    int size = 0;
    traverse(root, &arr, &size);
    for(int i = 1; i < size; i++)
        if(arr[i] <= arr[i-1])
            return false;
    return true;
}
