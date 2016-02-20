/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-20 09:16
Description : 
Source      : https://leetcode.com/problems/binary-search-tree-iterator/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};

#define LEN 100
struct BSTIterator
{
    struct TreeNode** stack;
    int size;
};

void collectLeft(struct TreeNode* root, struct BSTIterator* t)
{
    for(struct TreeNode* l=root; l; l=l->left)
    {
        /*t->stack = (struct TreeNode**)realloc(t->stack, sizeof(struct TreeNode*)*(t->size+1));*/
        t->stack[(t->size)++] = l;
    }
}

//AC - 16ms; - using a fixed size is better in this case - removing realloc method;
//AC - 12ms;
struct BSTIterator* bstIteratorCreate(struct TreeNode* root)
{
    struct BSTIterator* t = (struct BSTIterator*)malloc(sizeof(struct BSTIterator));
    t->stack = (struct TreeNode**)malloc(sizeof(struct TreeNode*)*LEN);
    t->size = 0;
    collectLeft(root, t);
    return t;
}

bool bstIteratorHasNext(struct BSTIterator* iter)
{
    return iter->size;
}

int bstIteratorNext(struct BSTIterator* iter)
{
    int ret = iter->stack[iter->size-1]->val;
    iter->size--;
    collectLeft(iter->stack[iter->size]->right, iter); //since the current node is being popped, collecting the next bigger part - its right children;
    return ret;
}

void bstIteratorFree(struct BSTIterator* iter)
{
    free(iter->stack);
    free(iter);
}
