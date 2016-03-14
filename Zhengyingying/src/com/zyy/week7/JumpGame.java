package com.zyy.week7;

/**
 * 
 * @author zyy 问题描述：给定一个非负整数的数组，数组中的每个元素存放的是能够jump的最大距离，判断是否可以从第一个位置jump到最后一个位置。
 *         
 *
 */
public class JumpGame {

	//2ms
	public boolean canJump3(int[] nums) {
		int n = nums.length;
		if (n == 0 || n == 1) {
			return true;
		}
		int maxstep = nums[0];
		for (int i = 1; i < n; i++) {
			if (maxstep == 0)
				return false;
			maxstep--;
			if (maxstep < nums[i]) {
				maxstep = nums[i];
			}
			if (maxstep + i >= n - 1) {
				return true;
			}
		}
		return false;
	}

	//3ms
	public boolean canJump2(int[] nums) {
		int i = 0, n = nums.length;
		for (int reach = 0; i < n && i <= reach; ++i)
			reach = Math.max(i + nums[i], reach);
		return i == n;
	}

	// 30.8% 3ms
	public boolean canJump1(int[] nums) {
		int dis = 0;
		for (int i = 0; i <= dis; i++) {
			dis = Math.max(dis, i + nums[i]);
			if (dis >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}

	// 从前往后 3ms 29.1%
	public boolean canJump(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > max)
				return false;
			max = Math.max(nums[i] + i, max);
		}
		return true;
	}
}
