#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() <=1){
            return nums.size();
        }
        typedef vector<int>::size_type vi;
        /*cur 记录当前书写位置*/
        vi cur = 1;
        int cnt = 0;
        for(vi j = 1;j<nums.size();j++){
            if(nums[j]!=nums[cur-1]){
                cnt = 0;
            }
            if(nums[j] == nums[cur-1]){
                cnt++;
            }
            if(cnt < 2){
                nums[cur++] = nums[j];
            }

        }
        return cur;
    }
    void test(){
        vector<int> v = {1,1,1,2,2,3};
        cout<<removeDuplicates(v);
    }
};
int main(){
    Solution sol;
    sol.test();
    return 0;
}
