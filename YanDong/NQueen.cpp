#include<vector>
#include<iostream>
using namespace std;
/*一次AC 纪念一下*/
class Solution {
public:
    void dfs(int n,int cur,vector<int> &ans,vector<vector<string>> &ret){
        if(cur == n){
            vector<string> tmp;
            for(int i = 0;i<n;i++){
                string s(n,'.');
                s[ans[i]] = 'Q';
                tmp.push_back(s);
            }
            ret.push_back(tmp);
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
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ret;
        vector<int> ans(n);
        dfs(n,0,ans,ret);
        return ret;
    }
};
int main(){
    Solution sol;
    vector<vector<string> > ret = sol.solveNQueens(10);
    return 0;
}
