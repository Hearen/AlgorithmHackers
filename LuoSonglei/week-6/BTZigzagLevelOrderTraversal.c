/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-06 19:57
Description : 
Source      : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*******************************************/
#include <stdlib.h>
struct TreeNode
{
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};
#define FOO
void traverse(struct TreeNode* stack0, struct TreeNode* stack1, int top, int** table, int** colSize, int* count)
{
    #ifdef FOO
        printf("inside traverse top: %d\n", top);
    #endif
    if(top < 0)
        return;
    table[*count] = (int*)malloc(sizeof(int)*(top+1));
    (*colSize)[*count] = top+1;
    if(*count%2 == 0)
    {
        for(int i=0; i<=top; i++)
            table[*count][i]=stack0[i].val;
    }
    else
    {
        for(int i=top; i>-1; i--)
            table[*count][top-i] = stack0[i].val;
    }
    #ifdef FOO
        printf("collected\n");
        for(int i = 0; i <= top; i++)
            printf("%d\t", table[*count][i]);
        printf("\nend here***********\n");
    #endif
    int index = -1;
    for(int i = 0; i <= top; i++)
    {
        if(stack0[i].left != NULL)
            stack1[++index] = *(stack0[i].left);
        if(stack0[i].right != NULL)
            stack1[++index] = *(stack0[i].right);
    }
    if(index < 0)
        return;
    top = index;
    #ifdef FOO
        printf("the next round stack value\n");
        for(int i = 0; i <= top; i++)
            printf("%d\n", stack1[i].val);
        printf("\nstack ends here***********\n");
    #endif
    (*count)++;
    traverse(stack1, stack0, top, table, colSize, count);
}

//AC - 0ms;
int** zigzagLevelOrder(struct TreeNode* root, int** colSize, int* count)
{
    if(root == NULL)
        return NULL;
    int len = 1000;
    struct TreeNode* stack0 = (struct TreeNode*)malloc(sizeof(struct TreeNode)*len);
    struct TreeNode* stack1 = (struct TreeNode*)malloc(sizeof(struct TreeNode)*len);
    *colSize = (int*)malloc(sizeof(int)*len);
    int top = -1;
    stack0[++top] = *root;
    int** table = (int**)malloc(sizeof(int*)*len); 
    *count = 0;
    traverse(stack0, stack1, top, table, colSize, count);
    return table;
}
