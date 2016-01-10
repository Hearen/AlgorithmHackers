#include<stdio.h>
#include<malloc.h>
struct TreeLinkNode {
	int val;
	struct TreeLinkNode *left, *right, *next;
};
struct TreeLinkNode* findNextLeftMost(struct TreeLinkNode *&cur,struct TreeLinkNode *curNextLev){
	  if(cur -> left == curNextLev && cur -> right != NULL){
            return cur -> right;
        }else{
            while(cur -> next != NULL){
                cur = cur -> next;
                if(cur -> left != NULL && cur -> left != curNextLev) return cur -> left;
                if(cur -> right != NULL && cur -> right != curNextLev) return cur -> right;
            }
        }
        return NULL;
};
struct TreeLinkNode* findStartNodeNextLev(struct TreeLinkNode* node){
	if(NULL == node) return NULL;
	if(node -> left != NULL) return node -> left;
	return findNextLeftMost(&node, node -> left);
}
void connect(struct TreeLinkNode *root) {
	if(root == NULL)
		return;
	struct TreeLinkNode *leftmost = root;
	while(leftmost != NULL){
		struct TreeLinkNode * curNode = leftmost;
		/*get next level left most node*/
		struct TreeLinkNode *start = findStartNodeNextLev(curNode);

		/*while(curNode){
			if(curNode->left){
				start = curNode->left;
				break;
			}else if(curNode->right){
				start = curNode->right;
				break;
			}
			curNode = curNode->next;
		}*/
		struct TreeLinkNode *next = findNextLeftMost(leftmost,start);
		struct TreeLinkNode *curPreNode = start;
		while(next != NULL){
			curPreNode->next = next;

			curPreNode = next;
			next = findNextLeftMost(leftmost,next);
		}
		leftmost = start;
	}
}
struct TreeLinkNode* init(){
	struct TreeLinkNode* root = (struct TreeLinkNode*)malloc(sizeof(struct TreeLinkNode));
	root->val = 3;
	root->left = root->right = root->next = NULL;
	struct TreeLinkNode* node1 = (struct TreeLinkNode*)malloc(sizeof(struct TreeLinkNode));
	node1->val = 9;
	struct TreeLinkNode* node2 = (struct TreeLinkNode*)malloc(sizeof(struct TreeLinkNode));
	node2->val = 20;
	struct TreeLinkNode* node3 = (struct TreeLinkNode*)malloc(sizeof(struct TreeLinkNode));
	node3->val = 15;
	struct TreeLinkNode* node4 = (struct TreeLinkNode*)malloc(sizeof(struct TreeLinkNode));
	node4->val = 7;
	root->left = node1;
	root->right = node2;
	node2->left = node3;
	node2->right = node4;

	node1->left = node1->right = NULL;
	node3->left = node3->right = NULL;
	node4->left = node4->right = NULL;
	node1->next = NULL;
	node2->next = NULL;
	node3->next = NULL;
	node4->next = NULL;
	root->next = NULL;
	return root;
};
int main(){
	struct TreeLinkNode* root  = init();
	connect(root);
	return 0;
}
