/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 08:56
Description : 
Source      : https://leetcode.com/problems/sum-root-to-leaf-numbers/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};
void traverse(struct TreeNode* root, struct TreeNode** stack, int* size, int* sum)
{
    if(!root->left && !root->right)
    {
        int t = (*stack)[0].val; 
        for(int i=1; i < *size; i++)
            t = 10*t + (*stack)[i].val;
        *sum += t;
    }
    if(root->left)
    {
        *size += 1;
        *stack = (struct TreeNode*)realloc(*stack, sizeof(struct TreeNode)*(*size));
        (*stack)[*size-1] = *(root->left);
        traverse(root->left, stack, size, sum);
        *size -= 1;
    }
    if(root->right)
    {
        *size += 1;
        *stack = (struct TreeNode*)realloc(*stack, sizeof(struct TreeNode)*(*size));
        (*stack)[*size-1] = *(root->right);
        traverse(root->right, stack, size, sum);
        *size -= 1;
    }
}
//AC - 0ms;
int sumNumbers(struct TreeNode* root)
{
    if(!root) return 0;
    int sum = 0;
    struct TreeNode* stack = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    int size = 1;
    stack[size-1] = *root;
    traverse(root, &stack, &size, &sum);
    return sum;
}
