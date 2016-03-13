/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-13 08:45
Description : The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
 3
/ \
2   3
\   \ 
 3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
3
/ \
4   5
/ \   \ 
1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
Source      : https://leetcode.com/problems/house-robber-iii/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};

#define MAX(a, b) ((a) > (b) ? (a) : (b))
void traverse(struct TreeNode* root, int* maxWithRoot, int* maxWithoutRoot)
{
    int lMaxWithRoot=0, lMaxWithoutRoot=0;
    int rMaxWithRoot=0, rMaxWithoutRoot=0;
    if(root)
    {
        traverse(root->left, &lMaxWithRoot, &lMaxWithoutRoot);
        traverse(root->right, &rMaxWithRoot, &rMaxWithoutRoot);
        *maxWithRoot = lMaxWithoutRoot+rMaxWithoutRoot+root->val; //if we take root, then the next adjacent children cannot be taken;
        *maxWithoutRoot = MAX(lMaxWithRoot, lMaxWithoutRoot)+MAX(rMaxWithRoot, rMaxWithoutRoot); //since we do not take the root, then whatever might be greater is what we want;
    }
}

int rob(struct TreeNode *root)
{
    int maxWithRoot = 0;
    int maxWithoutRoot = 0;
    traverse(root, &maxWithRoot, &maxWithoutRoot);
    return  MAX(maxWithRoot, maxWithoutRoot);
}
