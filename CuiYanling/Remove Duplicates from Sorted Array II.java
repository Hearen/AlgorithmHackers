public class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        for(int i=0;i<nums.length;){
            nums[start++] = nums[i];
            int tmp = nums[i];
            if((++i)<nums.length&&nums[i]==tmp)
                nums[start++] = nums[i];
            else continue;
            while((++i)<nums.length&&nums[i]==tmp);
        }
        return start;
    }
}
