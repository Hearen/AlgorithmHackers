#include<vector>
#include<unordered_set>
#include<string>
#include<algorithm>
using namespace std;
class Solution {
public:
    string encode(vector<int> &nums){
        stringstream ss;
        for(int i = 0;i<nums.size();i++){
            ss<<nums[i]<<"_";
        }
        return ss.str();
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int total_size = 1 << (nums.size());
        vector<vector<int>> ret;
        unordered_set<string> visited;
        for(int i = 0 ;i<total_size;i++){
            vector<int> tmp;
            for(int j = 0;j<nums.size();j++){
                if(i &(1<<j)){
                    tmp.push_back(nums[j]);
                }
            }
            string code = encode(tmp);
            if(visited.find(code)==visited.end()){
                visited.insert(code);
                ret.push_back(tmp);
            }

        }
        return ret;
    }

};
int main(){
    return 0;
}
