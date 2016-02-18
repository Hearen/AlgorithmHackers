/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-18 19:45
Description : 
Source      : https://leetcode.com/problems/minimum-depth-of-binary-tree/
*******************************************/
#include <limits.h>
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
//AC - 8ms;
int minDepth0( struct TreeNode* root )
{
    if(!root) return 0;
    if(!root->left && !root->right) return 1;
    int lDepth=INT_MAX, rDepth=INT_MAX; //the current node is not a leaf;
    if(root->left)
        lDepth = minDepth(root->left)+1;
    if(root->right)
        rDepth = minDepth(root->right)+1;
    return lDepth > rDepth? rDepth : lDepth;
}

//AC - 4ms - level traversing;
int minDepth( struct TreeNode* root )
{
    if(!root) return 0;
    if(!root->left && !root->right) return 1;
    struct TreeNode** queue0 = ( struct TreeNode** )malloc(sizeof( struct TreeNode* ));
    struct TreeNode** queue1 = ( struct TreeNode** )malloc(sizeof( struct TreeNode* ));
    int size = 1;
    int level = 1;
    queue0[size-1] = root;
    while(size)
    {
        queue1 = ( struct TreeNode** )realloc(queue1, sizeof( struct TreeNode* )*2*size);
        int index = 0;
        for(int i = 0; i < size; i++)
        {
            if(!queue0[i]->left && !queue0[i]->right)
                return level;
            if(queue0[i]->left)
                queue1[index++] = queue0[i]->left;
            if(queue0[i]->right)
                queue1[index++] = queue0[i]->right;
        } 
        level++; //move to the next level;
        struct TreeNode** t = queue0;
        queue0 = queue1;
        queue1 = t;
        size = index;
    }
}
