/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-18 17:02
Description : 
Source      : https://leetcode.com/problems/symmetric-tree/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNod *left, *right;
};
#include <stdbool.h>
struct TreeNode** fillNext( struct TreeNode** stack, int size , int* newSize)
{
    struct TreeNode** t = ( struct TreeNode** )malloc(sizeof( struct TreeNode* )*2*size);
    int index = 0;
    for(int i = 0; i < size; i++)
    {
        if(stack[i])
        {
            t[index++] = stack[i]->left;
            t[index++] = stack[i]->right;
        }
    }
    *newSize = index;
    return t;
}

//AC - 4ms;
bool isSymmetric( struct TreeNode * root )
{
    if(!root || (!(root->left) && !(root->right))) return true;
    if(!root->left || !root->right) return false;
    int count = 1;
    struct TreeNode **lStack = ( struct TreeNode** )malloc(sizeof( struct TreeNode* ));
    lStack[0] = root->left;
    struct TreeNode **rStack = ( struct TreeNode** )malloc(sizeof( struct TreeNode* ));
    rStack[0] = root->right;
    while(count)
    {
        int lIndex = 0, rIndex = 0;
        for(int i = 0; i < count; i++)
        {
            if(!lStack[i] || !rStack[count-i-1])
            {
                if(!lStack[i] && !rStack[count-i-1])
                    continue;
                return false;
            }
            if(lStack[i]->val != rStack[count-i-1]->val)
                return false;
        }
        int lCount=0, rCount=0;
        lStack = fillNext(lStack, count, &lCount);
        rStack = fillNext(rStack, count, &rCount);
        if(lCount != rCount) return false;
        count = lCount;
    }
    return true;
}
