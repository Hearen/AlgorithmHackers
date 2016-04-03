package com.zyy.week11;

//75.38% 7ms
public class _307_RangeSumQueryMutable_1 {
	// 使用树状数组
	private int[] BIT;
	private int[] nums;
	private int n;

	public _307_RangeSumQueryMutable_1(int[] nums) {
		this.n = nums.length;
		this.BIT = new int[n + 1];
		this.nums = nums;
		for (int i = 0; i < n; i++) {
			init(i, nums[i]);
		}
	}

	private void init(int pos, int val) {
		pos++;
		while (pos <= n) {
			BIT[pos] += val;
			pos += pos & -pos;
		}
	}

	void update(int i, int val) {
		int discard = val - nums[i];
		nums[i] = val;
		init(i, discard);
	}

	int getSum(int i) {
		i++;
		int sum = 0;
		while (i > 0) {
			sum += BIT[i];
			i -= i & -i;
		}
		return sum;
	}

	public int sumRange(int i, int j) {
		return getSum(j) - getSum(i - 1);
	}

}
