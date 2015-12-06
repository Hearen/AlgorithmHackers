package leetcode_njz;

public class _080_RemoveDuplicatesfromSortedArray2 {

	//double index
	public static int removeDuplicates(int[] nums) {
		if(nums == null)
			return 0;
		if(nums.length < 3)
			return nums.length;
		
		int start = 2;
		for(int i=2; i<nums.length; i++){
			if(nums[i] != nums[start-2])
				nums[start++] = nums[i];
		}
		return start;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int rs_len = removeDuplicates(nums);
		System.out.println("rs : "+rs_len);
	}

}
