package bs;

public class Solution {

	// 34 search for range
	public int[] searchRange(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {
				int p1 = m, p2 = m;
				while (--p1 >= 0 && nums[p1] == target)
					;
				while (++p2 <= (nums.length - 1) && nums[p2] == target)
					;
				return new int[] { ++p1, --p2 };
			} else if (nums[m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return new int[] { -1, -1 };
	}
}
