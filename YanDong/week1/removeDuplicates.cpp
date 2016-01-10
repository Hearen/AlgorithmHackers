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
        vi cur = 1;
        for(vi j = 1;j<nums.size();j++){
            if(nums[j]!=nums[cur-1]){
                nums[cur++] = nums[j];
            }
        }
        return cur;
    }
    void test(){
        vector<int> v = {1,1,2};
        cout<<removeDuplicates(v);
    }
};
int main(){
    Solution sol;
    sol.test();
    return 0;
}
