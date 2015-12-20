#include<string>
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    string simplifyPath(string path) {
        vector<string> v;
        path.append("/");
        int start=1,end=1;
        for(int i=1;i<path.size();i++){
            //cout<<i<<" "<<path.size()<<endl;
            //cout<<path[i]<<endl;
            if(path[i] == '/'){
                if(start < path.size() && start < end){
                    string tmp = path.substr(start,end-start);
                    //cout<<tmp<<endl;
                    if(tmp == ".."){
                        if(v.size()>0)
                            v.pop_back();
                    }else if(tmp!=".")
                        v.push_back(tmp);
                }
                start = end = i + 1;
            }
            else{
                end++;
            }
        }
        if(v.size()==0)
            return "/";
        string ret = "/";
        for(int i=0;i<v.size()-1;++i){
            ret=ret+v[i]+"/";
        }
        ret+=v[v.size()-1];

        return ret;
    }
};
int main(){
    Solution sol;
    cout<<sol.simplifyPath("/a/");
}
