package array.duplicates.II;

public class Solution {

	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int cur = 2, pre = 1;
		while (cur < nums.length) {
			if (nums[cur] == nums[pre] && nums[cur] == nums[pre - 1])
				cur++;
			else
				nums[++pre] = nums[cur++];
		}
		return pre + 1;
	}
}
