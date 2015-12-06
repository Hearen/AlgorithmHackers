public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length<=0) return false;
        if(nums[0]==target) return true;
        
        int left = 0,right = nums.length-1;
        while(left<=right&&nums[left]==nums[right])
            right--;
        while(left<right){
            int mid = (left+right)/2;
            if(target>=nums[0]){ //左支
                if(nums[mid]<nums[0]||nums[mid]>=target)
                    right = mid;
                else left = mid+1;
            }else{
                if(nums[mid]>=nums[0]||nums[mid]<target)
                    left = mid+1;
                else right = mid;
            }
        }
        if(left<nums.length&&nums[left]==target) return true;
        return false;
    }
}
