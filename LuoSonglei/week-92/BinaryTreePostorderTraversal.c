/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 15:08
Description : 
Source      : https://leetcode.com/problems/binary-tree-postorder-traversal/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};
#include <stdlib.h>
void traverse(struct TreeNode* root, int** arr, int* returnSize)
{
    if(root->left)
        traverse(root->left, arr, returnSize);
    if(root->right)
        traverse(root->right, arr, returnSize);
    *returnSize += 1;
    *arr = (int*)realloc(*arr, sizeof(int)*(*returnSize));
    (*arr)[*returnSize-1] = root->val;
}

//AC - 0ms;
int* postorderTraversal0(struct TreeNode* root, int* returnSize)
{
    if(!root) return NULL;
    int* arr = (int*)malloc(sizeof(int));
    *returnSize = 0;
    traverse(root, &arr, returnSize);
    return arr;
}

//AC - 0ms;
int* postorderTraversal1(struct TreeNode* root, int* returnSize)
{
    if(!root) return NULL;
    int* arr = (int*)malloc(sizeof(int));
    *returnSize = 0;
    struct TreeNode** stack = (struct TreeNode**)malloc(sizeof(struct TreeNode*));
    int size = 0;
    stack[size++] = root;
    while(size)
    {
        root = stack[size-1];
        size--;
        *returnSize += 1;
        arr = (int*)realloc(arr, sizeof(int)*(*returnSize));
        arr[*returnSize-1] = root->val;
        if(root->left)
        {
            size++;
            stack = (struct TreeNode**)realloc(stack, sizeof(struct TreeNode*)*size);
            stack[size-1] = root->left;
        }
        if(root->right)
        {
            size++;
            stack = (struct TreeNode**)realloc(stack, sizeof(struct TreeNode*)*size);
            stack[size-1] = root->right;
        }
    }
    size = *returnSize;
    for(int i = 0; i < size/2; i++)//reverse the previous result - mid+right+left customized preorder;
    {
        int t=arr[i]; arr[i]=arr[size-i-1]; arr[size-i-1]=t;
    }
    return arr;
}

//AC - 0ms;
#define LEN 1000
int* postorderTraversal(struct TreeNode* root, int* returnSize)
{
    if(!root) return NULL; 
    int* arr = (int*)malloc(sizeof(int)*LEN);
    *returnSize = 0;
    struct TreeNode** stack = (struct TreeNode**)malloc(sizeof(struct TreeNode*)*LEN);
    int size = 0;
    stack[size++] = root;
    struct TreeNode* pre = NULL; //either the parent or the child of cur;
    while(size)
    {
        struct TreeNode *cur = stack[size-1];
        if(!pre || pre->left==cur || pre->right==cur) //pushing only one child to the stack each time;
        //from the current node to collect the children;
        {
            if(cur->left)
                stack[size++] = cur->left;
            else 
            {
                if(cur->right)
                    stack[size++] = cur->right;
                else
                {
                    *returnSize += 1;
                    arr[*returnSize-1] = cur->val;
                    size--;
                }
            }
        }
        //start to collect the right part from bottom to top;
        else if(cur->left == pre) //left part has been handled;
        {
            if(cur->right)
                stack[size++] = cur->right;
            else
            {
                *returnSize += 1;
                arr[*returnSize-1] = cur->val;
                size--;
            }
        }
        else if(cur->right == pre)
        {
            *returnSize += 1;
            arr[*returnSize-1] = cur->val;
            size--;
        }
        pre = cur;
    }
    return arr;
}
