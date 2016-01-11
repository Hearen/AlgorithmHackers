#include<stack>
#include<queue>
#include<iostream>
using namespace std;
class Solution {
public:
    struct Node{
        TreeNode *node;
        int level;
        Node(TreeNode *node,int level):node(node),level(level){}
    };
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ret;
        if(root == NULL)
            return ret;
        queue<Node> q;
        q.push(Node(root,0));
        vector<int> ans;
        int curLevel = 0;
        while(!q.empty()){
            Node cur = q.front();
            q.pop();
            int level = cur.level;
            if(level != curLevel){
                if(curLevel % 2){
                    reverse(ans.begin(),ans.end());
                }
                ret.push_back(ans);
                ans.clear();
                curLevel = level;
            }
            ans.push_back((cur.node)->val);
            if((cur.node)->left){
                q.push(Node((cur.node)->left,level+1));
            }
            if((cur.node)->right){
                q.push(Node((cur.node)->right,level+1));
            }
        }
        if(curLevel % 2){
            reverse(ans.begin(),ans.end());
        }
        ret.push_back(ans);
        return ret;
    }
};
