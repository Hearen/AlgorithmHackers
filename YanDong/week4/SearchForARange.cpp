#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    int binarySearch(vector<int>& nums,int left,int right,int target,bool isleft){
        if(right < left) return -1;
        int mid = (left + right) / 2;
        if(target < nums[mid]){
            return binarySearch(nums,left,mid-1,target,isleft);
        }else if(target > nums[mid]){
            return binarySearch(nums,mid+1,right,target,isleft);
        }else{
            if(isleft){
                if(mid ==0 || nums[mid-1]!=target)
                    return mid;
                else return binarySearch(nums,left,mid-1,target,isleft);
            }else{
                if(mid ==nums.size()-1 || nums[mid+1]!=target)
                    return mid;
                else return binarySearch(nums,mid+1,right,target,isleft);
            }
        }
    }
    vector<int> searchRange(vector<int>& nums, int target) {
       int left = binarySearch(nums,0,nums.size()-1,target,true);
       int right = binarySearch(nums,0,nums.size()-1,target,false);
       vector<int> ret;
       ret.push_back(left);
       ret.push_back(right);
       return ret;
    }
    void test(){
        int a[] = {5, 7, 7, 8, 8, 10};
        vector<int> nums(a,a+5);
        vector<int> ret = searchRange(nums,8);
        cout<<ret[0]<<" "<<ret[1]<<endl;
    }
};
int main(){
    Solution sol;
    sol.test();
    return 0;
}
