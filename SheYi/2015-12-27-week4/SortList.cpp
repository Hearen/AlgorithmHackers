#include<stdio.h>
 struct ListNode {
      int val;
      struct ListNode *next;
  };
void main(){


}
struct ListNode* sortList(struct ListNode* head) {
     int count=0;
	 int tcount=0;
	 struct ListNode* sort(struct ListNode* head,int* count);
	if(!head) return ;
     head=sort(head,&count);
	 while(count--){
	    head=sort(head,&tcount);
	 }
	 return head;
}

struct ListNode* sort(struct ListNode* head,int* count){
    struct ListNode* rNode=head;
	int temp;
	while(!head->next){
		if(head->val>head->next->val){
			temp=head->val;
			head->val=head->next->val;
			head->next->val=temp;
		}
		head=head->next;
		count++;
	}
	   return rNode;
}