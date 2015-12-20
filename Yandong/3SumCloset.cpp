class Solution {
public:
    /*固定一点，在其后面查找，变为2Sum Problem*/
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        int res;
        bool first = true;
        for(int i=0;i<nums.size();i++){
            int start = i + 1;
            int end = nums.size() - 1;


            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];

                if(first){
                    res = sum;
                    first = false;
                }
                else{
                    if(abs(res-target) > abs(sum-target)){
                        res = sum;
                    }
                }
                if(res == target)
                    return res;
                if(sum > target){
                    end --;
                }
                else{
                    start++;
                }
            }

        }
        return res;
    }
};
