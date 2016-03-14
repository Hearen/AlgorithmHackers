/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-14 16:42
Description : 
Source      : https://leetcode.com/problems/binary-tree-paths/
*******************************************/
#include <stdlib.h>
#define LEN 1000
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
char* int2Str(int a)
{
    int minus = 0;
    if(a < 0)
    {
        minus = 1;
        a *= -1;
    }
    int index = 0;
    char* s = (char*)malloc(sizeof(char)*32);
    char* t = (char*)malloc(sizeof(char)*32);
    while(a > 0)
    {
        t[index++] = a%10+'0';
        a /= 10;
    }
    int j = 0;
    if(minus)
        s[j++] = '-';
    for(int i = 0; i < index; i++)
        s[j++] = t[index-i-1];
    s[j] = '\0';
    return s;
}
void traverse( struct TreeNode* root, struct TreeNode** stack, int top, char** sArr, int* count )
{
    if(root->left == NULL && root->right == NULL)
    {
        int size = top*3+1;
        sArr[*count] = (char*)malloc(sizeof(char)*size);
        sArr[*count][0] = '\0';
        int index = 0;
        int i = 0;
        for(; i < top; i++)
        {
            char* s = int2Str(stack[i]->val);
            strcat(sArr[*count], s);
            strcat(sArr[*count], "->");
        }
        char* s = int2Str(stack[i]->val);
        strcat(sArr[*count], s);
        (*count)++;
    }
    else
    {
        if(root->left != NULL)
        {
            stack[++top] = root->left;
            traverse(root->left, stack, top, sArr, count);
        }
        if(root->right != NULL)
        {
            if(root->left)
                --top;
            stack[++top] = root->right;
            traverse(root->right, stack, top, sArr, count);
        }
    }
}

//AC - 4ms;
char** binaryTreePaths( struct TreeNode* root, int* returnSize )
{
    if(root == NULL)
        return NULL;
    int top = -1;
    struct TreeNode **stack = ( struct TreeNode **)malloc(sizeof( struct TreeNode *)*LEN);
    stack[++top] = root;
    char** ss = (char**)malloc(sizeof(char*)*LEN);
    traverse(root, stack, top, ss, returnSize);
    return ss;
}
