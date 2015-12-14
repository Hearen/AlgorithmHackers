#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size() <= 2)return 0;
        typedef vector<int>::size_type vi;
        int heighest = 0;
        /*找到最高点*/
        for(vi i = 1 ;i < height.size(); ++i){
            if(height[i] > height[heighest]){
                    heighest = i;
            }
        }
        int ret = 0;
        //cur记录当前最高点
        int cur = height[0];
        for(vi i = 1;i<heighest;++i){
            if(cur > height[i]){
                ret += (cur - height[i]);
            }
            else{
                cur = height[i];
            }
        }
        cur = height[height.size()-1];
        for(vi i = height.size()-1;i>heighest;--i){
            if(cur > height[i]){
                ret += (cur - height[i]);
            }
            else{
                cur = height[i];
            }
        }
        return ret;

    }
    void test(){
        vector<int> height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ret = trap(height);
        cout<<ret<<endl;
    }
};
int main(){
    Solution sol;
    sol.test();
}
