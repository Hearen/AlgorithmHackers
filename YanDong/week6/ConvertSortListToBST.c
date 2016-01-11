#include<stdio.h>
struct ListNode {
    int val;
    struct ListNode *next;
};
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};
struct ListNode *getMidPre(struct ListNode *head){
    struct ListNode *slow = head;
    struct ListNode *fast = head->next;
    while(slow->next != NULL && fast->next !=NULL && fast->next->next !=NULL){
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
};
struct TreeNode* sortedListToBST(struct ListNode* head){
    if(head == NULL){
        return NULL;
    }
    if(head->next == NULL){
        struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
        root->left = root->right = NULL;
        root->val = head->val;
        return root;
    }
    struct ListNode *midpre = getMidPre(head);
    struct ListNode *mid = midpre->next;
    midpre->next = NULL;
    struct ListNode *right = mid->next;
    mid->next = NULL;
    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = mid->val;
    root->left = sortedListToBST(head);
    root->right = sortedListToBST(right);
    return root;
};



/*struct TreeNode* sortedListToBST(struct ListNode* head) {
    int n = 0;
    ListNode *p = head;
    while(p){
        n += 1;
        p = p->next;
    }

}

struct TreeNode *convert(struct ListNode *head,int n,ListNode *&next){
    if(n == 1){
        TreeNode *
    }
};*/
int main(){
    return 0;
}
