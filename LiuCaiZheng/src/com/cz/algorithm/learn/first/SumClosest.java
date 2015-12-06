package com.cz.algorithm.learn.first;

public class SumClosest {

	public static void main(String[] args) {
		int[] nums = {-1, 2 ,1 ,-4, 4};
		int target = 1;
		System.out.println(threeSumClosest(nums, target));
	}

	public static int threeSumClosest(int[] nums, int target) {

		int len = nums.length;
		if(len < 3) {
			return 0;
		}
		int sum = nums[0] + nums[1] + nums[2];
		for(int i = 1; i < len - 2 ; i ++) {
			int temp = nums[i] + nums[i + 1] + nums[i + 2];
			if(Math.abs(sum - target)  > Math.abs( temp -target)) {
				sum = temp;
			} 
		}
		return sum;
	}
}//done
