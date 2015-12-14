import java.util.Stack;

public class MaxRectangle {
	char[][] m = {{'0','1','1','1'},
				  {'0','1','1','0'},
				  {'1','1','0','0'},
				  {'1','1','0','1'}};
	int[] h = {2,1,5,6,2,3};
	/**
	 * @param height
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月14日
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
	 * find the area of largest rectangle in the histogram.
	 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
	 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
	 * For example,Given height = [2,1,5,6,2,3],return 10.
	 */
	public int maxHistogram(int[] height){
		/*思路：http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
		 * 计算最小矩形，重要的是找到矩形的长和高，以当前为基准，比当前小的连续块即是当前能达到的最大矩形，
		 * 这样找到左边界右边界（第一个小于当前值）就可以计算出矩形大小
		 * 维持一个递增的栈，
		 */
		if(height.length<1){
			return 0;
		}
		Stack<Integer> s = new Stack<>();
		int maxSum = 0;
		int i = 0,n = height.length;
		while(i < n){
			if (s.isEmpty() || height[i] >= height[s.peek()]) {
				s.push(i++);
			}else {
				int tmp = s.pop();
				int tmpSum = height[tmp]*(s.isEmpty()?i:i-s.peek()-1);
				maxSum = tmpSum > maxSum?tmpSum : maxSum;
			}
		}
		while(!s.isEmpty()){
			int tmp = s.pop();
			int tmpSum = height[tmp]*(s.isEmpty()?i:i-s.peek()-1);
			maxSum = tmpSum > maxSum?tmpSum : maxSum;
		}
		return maxSum;
	}
	
	/**
	 * @param matrix
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月9日
	 * Given a 2D binary matrix filled with 0's and 1's, 
	 * find the largest rectangle containing all ones and return its area.
	 * 给定二维0、1矩阵，找到包含1的最大矩形
	 */
	public int maxRectangle(char[][] matrix){
		/*思路 逐行增加，计算当前已遍历部分的最大矩形
		 * 新遍历一行，计算新矩阵的最大矩形
		*/
		if(matrix ==null || 0 == matrix.length){
	        return 0;
	    }
		int[] tmpHeight = new int[matrix[0].length];
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < tmpHeight.length; j++)
				tmpHeight[j] = matrix[i][j] == '1'?tmpHeight[j]+1:0;
			int tmpArea = maxHistogram(tmpHeight);
			maxArea = tmpArea>maxArea? tmpArea:maxArea;
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		MaxRectangle  mr = new MaxRectangle();
		System.out.println(mr.maxRectangle(mr.m));
//		System.out.println(mr.maxHistogram(mr.h));
		
	}
}
