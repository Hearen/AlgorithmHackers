package com.zyy.week1;

public class SearchInRotatedSortedArrayII {

	public boolean search1(int[] nums, int target) {
		int len = nums.length;
		for (int k = 0; k < len; k++) {
			if (target == nums[k])
				return true;
			else {
				if (k != len - 1) {
					if (target > nums[k] && nums[k] > nums[k + 1]) {
						return false;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArrayII si = new SearchInRotatedSortedArrayII();
		int[] nums = { 3, 3, 4, 4, 5, 6, 0, 1 };
		System.out.println(si.search1(nums, 5));
	}

}
