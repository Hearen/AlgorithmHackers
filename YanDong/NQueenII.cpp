#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    void dfs(int n,int cur,vector<int> &ans,int &ret){
        if(cur == n){
            ret += 1;
            return;
        }
        for(int i = 0;i<n;i++){
            ans[cur] = i;
            bool isLegal = true;
            for(int j = 0;j<cur;j++){
                if(j-ans[j]==cur-ans[cur] || j+ans[j] == cur+ans[cur] || ans[cur]==ans[j]){
                    isLegal = false;
                }
            }
            if(isLegal){
                dfs(n,cur+1,ans,ret);
            }
        }
    }
    int totalNQueens(int n) {
        int ret = 0;
        vector<int> ans(n);
        dfs(n,0,ans,ret);
        return ret;
    }
};
int main(){
    Solution sol;
    cout<<sol.totalNQueens(5);
    return 0;
}
