package com.sky.leetcode;

import java.util.Stack;

/**
 * @author DuanSky
 * @date 2015年12月14日 下午6:59:13
 * @content 
 */

public class _084_LargestRectangleinHistogram_NotFinished {
	
	public static void main(String args[]){
		int[] height={4,2,0,3,2,5};
		System.out.println(largestRectangleArea(height));
	}
	
	public static int largestRectangleArea(int[] height){
		int result=0;
		Stack<Integer> stack=new Stack();
		for(int i=0;i<=height.length;i++){
			int curHight= i == height.length ? -1 : height[i];
			//如果栈为空，或者栈顶的元素<=该元素，则将该元素入栈
			if(stack.isEmpty() || height[stack.peek()]<=curHight){
				stack.push(i);
			}
			/*
			 * 相反，如果该元素比栈顶的元素要小，则需要出栈，反方向来计算面积，并且和最大值进行比较。
			 * 计算以第i-1个元素为最右边界的最大矩形面积。
			 */
			else{
				int current=stack.pop();
				/*
				 * 注意下面这段代码容易产生思维陷阱。因为如果栈为空时，表明前面的元素都是大于该元素的，所以在计算的时候
				 * 要特别考虑栈为空时的情况。
				 * 此外需要注意i值指向的是当前的元素，而current指向的是栈顶的元素，而最右边的边界是第i-1个元素，
				 * 如果栈为空，说明该位置以左的位置上的元素都比该元素大，显然以i-1位置为最右边界的最大面积是从第0个元素开始算起，
				 * 一直到第i-1个元素，总共i个元素。
				 * 如果栈不为空，说明前面还有比该元素小的元素，那么计算的i-1个元素到第current个元素的距离就是i-1-current+1=i-current 
				 * 个元素。
				 * BUG：如果遇到 0 怎么办？
				 */

//				result=Math.max((i-current)*height[current],result);
				result=Math.max(result, height[current]*(stack.isEmpty() ? i : i-current));
				i--;//继续保持该元素和栈顶进行比较
			}
		}
		return result;
	}
	
	/*
	 * 假设当矩形取得最大面积时高度为k,那么k一定属于height。
	 * 假设以当前高度为准往后数的最大面积为area.
	 * time limited
	 * o(n^2)
	 */
	public int largestRectangleArea_time_limited(int[] height) {
        int result=0;
        for(int i=0;i<height.length;i++){
        	int curHeight=height[i];
        	int area=curHeight;
        	for(int j=i+1;j<height.length;j++){
        		if(height[j]>=curHeight)
        			area+=curHeight;
        		else
        			break;
        	}
        	if(area>result)
        		result=area;
        }
        return result;
    }

}
