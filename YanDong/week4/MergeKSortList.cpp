#include<queue>
#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    struct ListNode {
        int val;
        ListNode *next;
        ListNode(int x) : val(x), next(NULL) {}
    };
    struct compare{
        bool operator()(const ListNode *x1,const ListNode *x2) const {
        return x1->val > x2->val;
        }
    };
     ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode *head = NULL,*ret=NULL;
        priority_queue<ListNode*,vector<ListNode*>,compare> q;
        for(int i=0;i<lists.size();++i){
            cout<<i<<endl;
            if(lists[i])
                q.push(lists[i]);
        }
        while(!q.empty()){
            ListNode *tmp = q.top();
            q.pop();
            if(head == NULL){
                head = ret = tmp;
            }
            else{
                head ->next = tmp;
                head = tmp;
            }
            if(tmp->next != NULL){
                q.push(tmp->next);
            }
        }
        return ret;
    }
};
int main(){
    return 0;
}
