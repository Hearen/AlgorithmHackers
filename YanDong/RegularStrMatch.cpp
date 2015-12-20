#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
    bool isMatch(string s, string p) {
        cout<<s<<" "<<p<<endl;
        if(p.size() < 1){
            return s.size() < 1;
        }
        if(p[1] != '*'){
            return (p[0] == s[0] || (p[0] == '.' && s.size()>0)) && isMatch(s.substr(1),p.substr(1));
        }else{
            int i = 0;
            while(i <= s.size() && (s[i] == p[0] || p[0] == '.')){
                //match zero preceding element
                if(isMatch(s.substr(i),p.substr(2))) return true;
                i++;
            }
            return isMatch(s,p.substr(2));
        }

    }
};
int main(){
    Solution sol;
    cout<<sol.isMatch("ab",".*");
    return 0;
}
