package com.xpx.demo;

public class TrapRain {
	int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
	
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	 * compute how much water it is able to trap after raining.
	 * For example,
	 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
	 * In this case, 6 units of rain water (blue section) are being trapped.
	 */
	public int rainTrap(int[] nums){
		/*思路，首先查看要求的部分特点，参差不齐，不好处理，想到能否取反的方法
		 * air，water，stone
		 * 如果能求出water+stone也不错，这样减去stone就可以
		 * 求法遍历，如果当前不是最大值，则以最大值累加，。。。有问题，最大值后边的那部分会多加
		 * 从末尾再求一遍，。。有问题，最大值前边那一部分会多加
		 * 两次所求加起来呢，多加了一个左边stone，右边stone，和一个最大值，这三者正好是一个all方块
		 * 所以，leftMass+rightMass-all = water+stone
		 * 这样，再减去stone（也就是sum）得到water
		 */
		if (3 > nums.length) {
			return 0;
		}
		int tmpMax = nums[0];
		int mass = tmpMax;
		for(int i = 1; i < nums.length ;i++ ){
			if (tmpMax < nums[i]) {
				tmpMax = nums[i];
			}
			mass+=tmpMax-nums[i];
		}
		tmpMax = nums[nums.length-1];
		for(int i = nums.length-1; i >= 0 ;i-- ){
			if (tmpMax < nums[i]) {
				tmpMax = nums[i];
			}
			mass+=tmpMax;
		}
		
		return mass-tmpMax*nums.length;
	}
	public static void main(String[] args) {
		TrapRain tr = new TrapRain();
		System.out.println(tr.rainTrap(tr.nums));
	}


}
