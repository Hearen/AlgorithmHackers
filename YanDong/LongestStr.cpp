#include<iostream>
#include<string>
#include<cstring>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start = 0;
        int flag[256];
        int maxLength = 0;
        int tmpLength = 0;
        memset(flag,-1,sizeof(flag));
        for(int i=0;i<s.length();++i){
            if(flag[s[i]] == -1){
                tmpLength += 1;
                flag[s[i]] = i;
            }
            else{
                if(tmpLength > maxLength){
                    maxLength = tmpLength;
                }
                for(int j = start;j<flag[s[i]];j++){
                    flag[s[j]] = -1;
                }
                start = flag[s[i]] + 1;
                tmpLength = i - flag[s[i]];
                flag[s[i]] = i;
            }
        }
        return maxLength > tmpLength?maxLength:tmpLength;
    }
    void test(){
        string s = "abba";
        cout<<lengthOfLongestSubstring(s)<<endl;
    }
};
int main(){
    Solution sol;
    sol.test();
}
