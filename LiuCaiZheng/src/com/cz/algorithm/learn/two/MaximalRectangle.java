package com.cz.algorithm.learn.two;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		char[][] matrix = { { '0', '1', '1', '0', '1' },
				{ '1', '1', '0', '1', '0' }, { '0', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));
	}

	/**
	 * here we apply the methodology of the last topic and transform the
	 * question to this circumstance but how we transform this topic. what i do
	 * here is that the max continues sequence of the number 1 construct the
	 * height of the histogram, next step is to use the method previous. so we
	 * can solve the question through two step: (1) find the max continues
	 * sequence of the number 1 (2) use the method previous (3) the proof of the
	 * transformation is in the resources of the project. the file name is
	 * MaximalRectangle.docx
	 * 
	 * the time complexity of the method is O(N3) the space complexity is O(n);
	 * 
	 * */
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int[] height = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0')
					height[j] = 0;
				else
					height[j] += 1;
			}
			max = Math.max(largestRectangleArea(height), max);
		}
		return max;

	}
	private  int largestRectangleArea(int[] height) {
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
