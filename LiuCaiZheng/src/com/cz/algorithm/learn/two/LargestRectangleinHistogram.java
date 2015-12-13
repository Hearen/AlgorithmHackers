package com.cz.algorithm.learn.two;

import java.util.Stack;

public class LargestRectangleinHistogram {

	// public static void main(String[] args) {
	// int[] height = new int[] {2,1,5,6,2,3};
	// new LargestRectangleinHistogram().largestRectangleArea(height);
	// }
	public int largestRectanglaArea2(int[] height) {
		return 0;
	}

	/**
	 * the methodology is to create a stack which store the height of the array,
	 * if the height[i] is greater or equal to the top of the stack , then push
	 * height[i] into the stack else compute the max area , on the other hand,
	 * record the number of which pop from the stack and push itself to the
	 * stack when the process ends namely reaching the end of the array , pop
	 * the stack until empty ,computing the area. at last, return the max area.
	 * 
	 * the time complexity is O(n2); the space complexity is O(n);
	 * 
	 * */
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int len = height.length;
		if (len == 1)
			return height[0];
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while (i < len) {
			if (stack.empty() || height[i] >= stack.peek()) {
				stack.push(height[i]);
				i++;
			} else {
				int count = 0;
				while (!stack.empty() && stack.peek() > height[i]) {
					count++;
					int top = stack.peek();
					stack.pop();
					max = Math.max(max, top * count);
				}
				for (int j = 0; j < count + 1; j++) {
					stack.push(height[i]);
				}
				i++;
			}
		}
		int count = 0;
		while (!stack.empty()) {
			count++;
			max = Math.max(max, stack.peek() * count);
			stack.pop();
		}
		return max;
	}
}
