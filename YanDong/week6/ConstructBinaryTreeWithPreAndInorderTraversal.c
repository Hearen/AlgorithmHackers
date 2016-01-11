#include<stdio.h>
#include<malloc.h>
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};
struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize) {
    if(preorderSize == 0)
        return NULL;
    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->left = root->right = NULL;
    root->val = preorder[0];
    int leftLen;
    for(leftLen = 0;leftLen<inorderSize;leftLen++){
        if(inorder[leftLen]==preorder[0]){
            break;
        }
    }
    int rightLen = inorderSize - leftLen - 1;
    if(leftLen > 0){
        root->left = buildTree(&preorder[1],leftLen,inorder,leftLen);
    }
    if(rightLen > 0){
        root->right = buildTree(&preorder[leftLen+1],rightLen,&inorder[leftLen+1],rightLen);
    }
    return root;
}
int main(){
    return 0;
}
