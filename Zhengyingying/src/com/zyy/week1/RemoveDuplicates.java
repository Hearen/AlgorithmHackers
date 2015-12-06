package com.zyy.week1;

public class RemoveDuplicates {

	//大神级别
	public int removeDuplicatesUp(int[] nums) {
		int i = 0;
		for (int target : nums) {
			if (i < 2 || nums[i - 2] < target) {
				nums[i++] = target;
			}
		}
		for (int k = 0; k < i; k++) {
			System.out.println(nums[k]);
		}
		return i;
	}

	//菜鸟级别
	public int removeDuplicates(int[] nums) {
		int record = 0;
		int len = nums.length;
		int[] target = new int[len];
		int flag = nums[0];
		target[record++] = flag;
		int duplicate = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == flag) {
				duplicate++;
				if (duplicate > 2) {
					len--;
				} else {
					target[record++] = flag;
				}
			} else {
				flag = nums[i];
				if (duplicate != 1) {
					duplicate = 1;
				}
				target[record++] = flag;
			}
		}
		for (int i = 0; i < len; i++) {
			nums[i] = target[i];
		}
		return len;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3, 3, 3 };
		RemoveDuplicates rd = new RemoveDuplicates();
		System.out.println(rd.removeDuplicatesUp(nums));
	}
}
