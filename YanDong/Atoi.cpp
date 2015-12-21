#include<iostream>
#include<string>
#include<cmath>
#include<vector>
using namespace std;
const int INT_MAX = 2147483647;
const int INT_MIN = -2147483648;
class Solution {
public:
    int myAtoi(string str){
        int flag = 1;
        int start = -1;
        for(int i = 0;i<str.size();i++){
            if(str[i] != ' ' && start  == -1){
                start = i;
            }
        }
        //All space
        if(start == -1){
            return 0;
        }
        if(str[start]=='-'){
            flag = -1;
            str = str.substr(start+1);
        }else if(str[start] == '+'){
            str = str.substr(start+1);
        }else{
            str = str.substr(start);
        }
        //cout<<str<<endl;
        cout<<str<<endl;
        long ret = 0;
        for(int i=0;i<str.size();i++){
           if(str[i] >='0' && str[i]<='9'){
                ret = ret * 10 + str[i] - '0';
                if(ret > INT_MAX){
                    if(flag > 0){
                        return INT_MAX;
                    }else{
                        return INT_MIN;
                    }
                }
           }else{
                break;
           }
        }
        return flag * ret;
    }
};
int main(){
    Solution sol;
    string s = "   +0 123";
    cout<<sol.myAtoi(s);
    return 0;
}
