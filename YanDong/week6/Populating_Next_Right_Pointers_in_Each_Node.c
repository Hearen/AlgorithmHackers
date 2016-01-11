struct TreeLinkNode {
    TreeLinkNode *left;
    TreeLinkNode *right;
    TreeLinkNode *next;
};
/*一次AC...*/
void connect(struct TreeLinkNode *root) {
    if(root == NULL)
        return root;
    struct TreeLinkNode *leftmost = root;
    while(leftmost->left != NULL){
        struct TreeLinkNode * curNode = leftmost;
        while(curNode != NULL){
            curNode->left->next = curNode->right;
            if(curNode->next != NULL){
                curNode->right->next = curNode->next->left;
            }
            curNode = curNode->next;
        }
        leftmost = leftmost->left;
    }
}
int main(){
    return 0;
}
