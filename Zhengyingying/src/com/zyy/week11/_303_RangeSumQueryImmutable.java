package com.zyy.week11;

/**
 * 
 * @author ZYY 计算nums中从i到j的数组中元素之和,但会多次调用。
 *
 */
public class _303_RangeSumQueryImmutable {
	private int[] nums;

	public _303_RangeSumQueryImmutable(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + nums[i - 1];
		}
		this.nums = nums;
	}

	public int _303_RangeSumQueryImmutable(int i, int j) {
		if (i == 0)
			return nums[j];
		else
			return nums[j] - nums[i - 1];
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -2, 0, 3, -5, 2, -1 };
		_303_RangeSumQueryImmutable rsqi = new _303_RangeSumQueryImmutable(nums);
		int sum = rsqi._303_RangeSumQueryImmutable(0,5);
		System.out.println(sum);
	}
}
