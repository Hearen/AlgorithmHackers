/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 19:53
Description : 
Source      : https://leetcode.com/problems/count-complete-tree-nodes/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};


//this traversal will slow the whole operation down dramatically;
//since it's a complete tree - TLE;
int traverse(struct TreeNode* root)
{
    if(!root->left && !root->right) return 1;
    int sum = 1;
    if(root->left)
        sum += traverse(root->left);
    if(root->right)
        sum += traverse(root->right);
    return sum;
}


int countNodes0(struct TreeNode* root)
{
    if(!root) return 0;
    int lHeight=0, rHeight=0;
    struct TreeNode* t = root;
    while(t)
    {
        t = t->left;
        lHeight++;
    }
    t = root;
    while(t)
    {
        t = t->right;
        rHeight++;
    }
    if(lHeight==rHeight) return (1<<lHeight)-1; 
    return traverse(root);
}


int leftHeight(struct TreeNode* root)
{
    return !root? 0 : 1+leftHeight(root->left);
}

//AC - 152ms;
int countNodes1(struct TreeNode* root)
{
    if(!root) return 0;
    int lHeight = leftHeight(root->left);
    int rHeight = leftHeight(root->right);
    return lHeight == rHeight? pow(2, lHeight)-1 : (1 << rHeight) + countNodes(root->left);
}

//AC - 144ms;
int countNodes(struct TreeNode* root)
{
    if(!root) return 0;
    int lHeight=0, rHeight=0;
    for(struct TreeNode* l=root; l; l=l->left) lHeight++;
    for(struct TreeNode* r=root; r; r=r->right) rHeight++;
    if(lHeight==rHeight) return (1<<lHeight)-1; 
    return countNodes(root->left)+countNodes(root->right)+1;
}

