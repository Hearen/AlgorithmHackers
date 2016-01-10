#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int total_size = 1 << (nums.size());
        vector<vector<int>> ret;
        for(int i = 0 ;i<total_size;i++){
            vector<int> tmp;
            for(int j = 0;j<nums.size();j++){
                if(i &(1<<j)){
                    tmp.push_back(nums[j]);
                }
            }
            ret.push_back(tmp);
        }
        return ret;
    }

};
int main(){
    return 0;
}
