#include<cstdio>
#include<malloc.h>
using namespace std;
struct TreeLinkNode {
	int val;
	struct TreeLinkNode *left, *right, *next;
};
struct TreeLinkNode* findNextLeftMost(struct TreeLinkNode *&cur,struct TreeLinkNode *curNext){
	  if(cur->left == curNext && cur->right != NULL){
            return cur->right;
        }else{
            while(cur->next != NULL){
                cur = cur->next;
                if(cur->left!=NULL && cur->left!=curNext) return cur->left;
                if(cur->right != NULL && cur->right!=curNext) return cur->right;
            }
        }
        return NULL;
};
void connect(struct TreeLinkNode *root) {
	if(root == NULL)
		return;
	struct TreeLinkNode *leftmost = root;
	while(leftmost != NULL){
		struct TreeLinkNode * curNode = leftmost;
		/*get next level left most node*/
        struct TreeLinkNode *start = NULL;
		while(curNode){
			if(curNode->left){
				start = curNode->left;
				break;
			}else if(curNode->right){
				start = curNode->right;
				break;
			}
			curNode = curNode->next;
		}
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
