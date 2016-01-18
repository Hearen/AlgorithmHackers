package com.zyy.week7;

public class JumpGameII {

	// 3ms
	public int jump1(int[] nums) {
		int n = nums.length;
		if (n < 2)
			return 0;
		int level = 0, currentMax = 0, i = 0, nextMax = 0;

		while (currentMax - i + 1 > 0) { // nodes count of current level>0
			level++;
			for (; i <= currentMax; i++) { // traverse current level , and
											// update the max reach of next
											// level
				nextMax = Math.max(nextMax, nums[i] + i);
				if (nextMax >= n - 1)
					return level; // if last element is in level+1, then the min
									// jump=level
			}
			currentMax = nextMax;
		}
		return 0;
	}

	// 3ms
	// 仍然使用贪心算法，需记录当前所能到达的最远距离、上一跳所能到达的最远距离、当前跳数
	public int jump(int[] nums) {
		int ret = 0;// 当前跳数
		int last = 0; // 上一跳可达最远距离
		int cur = 0;// 当前一跳可达最远距离
		for (int i = 0; i < nums.length; i++) {
			// 需要进行下次跳，需要更新last和当前执行的跳数
			if (i > last) {
				last = cur;
				++ret;
			}
			// 记录当前可达的最远点
			cur = Math.max(cur, nums[i] + i);
		}
		return ret;
	}
}
