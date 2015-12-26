#include<stdio.h>
#include<memory.h>
#include<stdlib.h>
struct ListNode {
	int val;
	struct ListNode *next;
};
struct ListNode *getMid(struct ListNode *head){
	//printf("%d\n",head->next->val);
	struct ListNode *first=head,*second=head->next;
	while(first->next!=NULL && second->next!=NULL && second->next->next!=NULL){
		first = first->next;
		second = second->next->next;
	}
	return first;
}
struct ListNode* merge(struct ListNode *left,struct ListNode *right){
	struct ListNode *head = (struct ListNode*)malloc(sizeof(struct ListNode));
	struct ListNode *store = head;
	struct ListNode *l = left,*r = right;
	while(l != NULL && r !=NULL){
		if(l->val < r->val){
			head->next = l;
			head = l;
			l = l->next;
		}else{
			head->next = r;
			head = r;
			r = r -> next;
		}
	}
	if(l!=NULL){
		head->next = l;
	}
	if(r!=NULL){
		head->next = r;
	}
	struct ListNode *ret = store->next;
	free(store);
	return ret;
}

struct ListNode* sortList(struct ListNode* head) {
	//the end condition
	if(head == NULL || head->next == NULL){
		return head;
	}
	struct ListNode *mid = getMid(head);
	struct ListNode *right = mid->next;
	mid->next = NULL;
	struct ListNode *first = sortList(head);
	struct ListNode *second = sortList(right);
	return merge(first,second);
}
struct ListNode* init(){
	struct ListNode* dummy =(struct ListNode*)malloc(sizeof(struct ListNode));
	struct ListNode* head = dummy;
	int i;
	for(i = 10;i>1;--i){
		struct ListNode* node =(struct ListNode*)malloc(sizeof(struct ListNode));
		node->val = i;
		node->next = NULL;
		head->next = node;
		head = node;
	}
	struct ListNode* ret = dummy->next;
	free(dummy);
	return ret;
};
void print(struct ListNode *head){
	struct ListNode *dummy = head;
	while(dummy!=NULL){
		printf("%d ",dummy->val);
		dummy = dummy->next;
	}
	printf("\n");
}
int main(){
	struct ListNode *list = init();
	print(list);
	struct ListNode *ret = sortList(list);
	print(ret);
	getchar();
	return 0;
}
