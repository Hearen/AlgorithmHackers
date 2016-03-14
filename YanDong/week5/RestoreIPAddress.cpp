#include<cstdlib>
#include<iostream>
#include<string>
#include<vector>
using namespace std;
class Solution {

public:
    bool islegal(string &s,int start,int length){
        if(start + length > s.length()){
            return false;
        }
        string tmp = s.substr(start,length);
        if(length == 1){
            return tmp >= "0" && tmp <="9";
        }else if(length == 2){
            return tmp >="10" && tmp <="99";
        }else{
            return tmp>="100" && tmp <="255";
        }
    }
    void dfs(vector<string> &ret,vector<int> &ans,string &s,int start,int time){
        if(time == 0){
            if(start == s.size()){
                string tmp;
                int beg = 0;
                for(int i = 0;i<4;i++){
                    string t = s.substr(beg,ans[i]-beg + 1);
                    beg = ans[i] + 1;
                    tmp += (i==0) ? t : "." + t;
                }
                cout<<tmp<<endl;
                ret.push_back(tmp);
            }
            return;
        }
        for(int i = 1;i <= 3;i++){
            if(islegal(s,start,i)){
                ans.push_back(start + i - 1);
                dfs(ret,ans,s,start+i,time-1);
                ans.pop_back();
            }
        }
    }
    vector<string> restoreIpAddresses(string s) {
        vector<int> v;
        vector<string> ret;
        dfs(ret,v,s,0,4);
        return ret;
    }
};
int main(){
    Solution sol;
    sol.restoreIpAddresses("25525511135");
    return 0;
}
