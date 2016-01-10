#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    /*有序区间的二分法*/
    bool binarySearch(vector<int> &nums,int left,int right,int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
    /*对于区间不确定是否有断点的情形*/
    bool binarySearchI(vector<int> &nums,int left,int right,int target){
        if(left > right){
            return false;
        }
        int mid = (left + right) / 2;
        if(nums[mid] == target){
            return true;
        }
        if(nums[mid] > nums[left]){
            if(target >= nums[left] && target < nums[mid]){
                return binarySearch(nums,left,mid-1,target);
            }
            else{
                return binarySearchI(nums,mid+1,right,target);
            }

        }
        else if(nums[mid] < nums[left]){
            if(target > nums[mid] && target <= nums[right]){
                return binarySearch(nums,mid+1,right,target);
            }
            else{
                return binarySearchI(nums,left,mid-1,target);
            }
        }
        else{
            return binarySearchI(nums,left,mid-1,target) || binarySearchI(nums,mid+1,right,target);
        }
    }
    bool search(vector<int>& nums, int target) {
        return binarySearchI(nums,0,nums.size()-1,target);
    }
    void test(){
        vector<int> nums = {1,2,1};
        cout<<search(nums,1)<<endl;
    }

    /*首先找到断点，然后对有序区间进行二分查找*/
     bool searchII(vector<int>& nums, int target) {
        int pivot = -1;
        int cur = nums[0];
        for(int i=1;i<nums.size();i++){
            if(cur > nums[i]){
                pivot = i - 1;
                break;
            }
            cur = nums[i];
        }
        int start,end;
        if(pivot == -1){
            start = 0;
            end = nums.size() - 1;
        }
        else if(target <= nums[pivot] && target >= nums[0]){
            start = 0;
            end = pivot;
        }
        else{
            start = pivot + 1;
            end = nums.size() - 1;
        }
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid]>target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }
};
int main(){
    Solution sol;
    sol.test();
    return 0;
}
