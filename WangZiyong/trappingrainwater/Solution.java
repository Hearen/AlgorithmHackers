package leetcode.java.trappingrainwater;

public class Solution {
	public int trap(int[] height) {
		if (null == height || 0 == height.length || 1==height.length) {
			return 0;
		}
		int max_idx = getMax(0, height.length, height, false);
		// left
		int left = getLeftTrap(max_idx, height);
		System.out.println("left trap " + left);
		// right
		int right = getRightTrap(max_idx, height);
		System.out.println("right trap " + right);

		return left+right;
	}

	private int getRightTrap(int max_idx, int[] height) {
		int trap_right = 0;
		while (true) {
			if (max_idx + 1 >= height.length) {
				break;
			}
			int max_right_idx = getMax(max_idx + 1, height.length, height, false);
			trap_right += getRightTrap(max_right_idx, max_idx, height);
			max_idx = max_right_idx;
		}
		return trap_right;
	}

	private int getRightTrap(int max_right_idx, int max_idx, int[] height) {
		int ht = height[max_right_idx] > height[max_idx] ? height[max_idx] : height[max_right_idx];
		int wd = max_right_idx - max_idx - 1;
		if(ht * wd == 0)
		{
			return 0;
		}
		int block = 0;
		for (int i = max_idx + 1; i <= max_right_idx - 1; i++) {
			block += height[i];
		}
		return ht * wd - block;
	}

	private int getLeftTrap(int max_idx, int[] height) {
		int trap_left = 0;
		while (true) {
			if(max_idx == 0)
			{
				return 0;
			}
			int max_left_idx = getMax(0, max_idx, height, true);
			trap_left += getLeftTrap(max_left_idx, max_idx, height);

			max_idx = max_left_idx;
			if (max_left_idx <= 0) {
				break;
			}
		}
		return trap_left;
	}

	private int getLeftTrap(int max_left_idx, int max_idx, int[] height) {
		int ht = height[max_left_idx] > height[max_idx] ? height[max_idx] : height[max_left_idx];
		int wd = max_idx - max_left_idx - 1;
		if(ht * wd == 0)
		{
			return 0;
		}
		int block = 0;
		for (int i = max_left_idx + 1; i <= max_idx - 1; i++) {
			block += height[i];
		}
		return ht * wd - block;
	}

	public int getMax(int start, int end, int[] height, boolean isFloatLeft) {
		int tmp = height[start];
		int index = start;
		for (int i = start; i < end; i++) {
			if (isFloatLeft) {
				if (tmp < height[i]) {
					tmp = height[i];
					index = i;
				}
			} else {
				if (tmp <= height[i]) {
					tmp = height[i];
					index = i;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] testA = {5,8,9,4,9,6,1,4};
		Solution solution = new Solution();
		System.out.println(solution.trap(testA));
		// System.out.println(solution.getMax(0, testA.length, testA, true));
	}

}
