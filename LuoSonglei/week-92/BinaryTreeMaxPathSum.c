/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 20:05
Description : 
Source      : https://leetcode.com/problems/binary-tree-maximum-path-sum/
*******************************************/
#define MAX(a, b) ((a) > (b)? (a) : (b))
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};

int max(int a, int b)
{
    return a > b? a : b;
}

//return the max sum ended with root and refresh *max accordingly;
int helper(struct TreeNode* root, int* Max)
{
    if(!root) return 0;
    int lMax = max(0, helper(root->left, Max)); //if the result of helper in left is negative, select nothing;
    int rMax = max(0, helper(root->right, Max));
    *Max = max(*Max, lMax+root->val+rMax);
    return max(lMax, rMax)+root->val;
}
//AC - 16ms;
int maxPathSum(struct TreeNode* root)
{
    if(!root) return 0;
    int max = 0;
    helper(root, &max);
    return max;
}
