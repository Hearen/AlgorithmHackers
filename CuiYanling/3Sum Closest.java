public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer res = null;
        for(int i=nums.length-1;i>=2;i--){
            int left =0,right = i-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(res==null||Math.abs(target-sum)<Math.abs(target-res)){
                    res = sum;
                    if(res==target) return res;
                }
                if(sum<target) left++;
                else right--;
            }
        }
        return (int)res;
    }
}
