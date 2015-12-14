package array.duplicates.I;

public class Solution {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return nums.length;
		int cur = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[cur]) {
				nums[++cur] = nums[i];
			}
		}
		return cur + 1;
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		int[] nums = { 1, 2, 2, 3, 3, 4 };
		System.out.println(so.removeDuplicates(nums));
	}
}
