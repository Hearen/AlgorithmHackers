package com.zyy.week1;

public class SearchInRotatedSortedArray {
	public int search1(int[] nums, int target) {
		int len = nums.length;
		for (int k = 0; k < len; k++) {
			if (target == nums[k])
				return k;
			else {
				if (k != len - 1) {
					if (target > nums[k] && nums[k] > nums[k + 1]) {
						return -1;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray sisa = new SearchInRotatedSortedArray();
		int[] nums = { 3, 4, 5, 6, 0, 1 };
		System.out.println(sisa.search1(nums, 1));
	}
}
