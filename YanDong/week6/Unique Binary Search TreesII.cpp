#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    struct TreeNode {
        int val;
        TreeNode *left;
        TreeNode *right;
        TreeNode(int x) : val(x), left(NULL), right(NULL) {}
    };
    vector<TreeNode*> generateTreesII(int n,int start){
                vector<TreeNode *> ret;
        if(n == 0){
            return ret;
        }else if(n == 1){
            TreeNode *root = new TreeNode(start);
            ret.push_back(root);
            return ret;
        }
        for(int i = 1;i<=n;i++){

            vector<TreeNode*> left,right;
            left = generateTreesII(i-1,start);
            right = generateTreesII(n-i,start+i);
            if(left.size() == 0){

                for(int k = 0;k<right.size();++k){
                    TreeNode *root = new TreeNode(start+i-1);
                    root->left = NULL;
                    root->right = right[k];
                    ret.push_back(root);
                }
            }
            else if(right.size() == 0){
                for(int k = 0;k<left.size();++k){
                    TreeNode *root = new TreeNode(start+i-1);
                    root->right = NULL;
                    root->left = left[k];
                    ret.push_back(root);
                }
            }
            else{
                for(int k = 0;k<left.size();++k){
                    for(int j = 0;j<right.size();++j){
                        TreeNode *root = new TreeNode(start+i-1);
                        root->left = left[k];
                        root->right = right[j];
                        ret.push_back(root);
                    }
                }
            }



        }
        return ret;
    }
    /*添加一个start 记录取值的开始*/
    vector<TreeNode*> generateTrees(int n) {
        vector<TreeNode *> ret = generateTreesII(n,1);
        return ret;
    }
};
int main(){
    return 0;
}
