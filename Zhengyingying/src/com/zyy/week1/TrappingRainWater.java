package com.zyy.week1;

public class TrappingRainWater {
	// 左右两边同时检测，如果右边比左边高，则左边比当前高度低的可以加上差值；
	// 如果左边比右边高，则右边比当前高度低的可以加上差值。
	public int trap(int[] height) {
		int trap = 0;
		int level = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			if (height[left] < height[right]) {
				level = Math.max(height[left], level);
				trap += level - height[left];
				left++;
			} else {
				level = Math.max(height[right], level);
				trap += level - height[right];
				right--;
			}
		}
		return trap;

	}

	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		TrappingRainWater trw = new TrappingRainWater();
		System.out.println(trw.trap(height));
	}

}
