package com.cz.algorithm.four;

public class SearchForaRange {

	public static void main(String[] args) {
		int[]nums = new int[]{5, 7, 7, 8, 8, 10};
		int target = 6;
		int[] results = new SearchForaRange().searchRange(nums, target);
		for (int  i= 0; i  < results.length; i++) {
			System.out.println(results[i]);
		}
	}
	 public int[] searchRange(int[] nums, int target) {
		     if(nums == null || nums.length ==0)  return new int[]{-1,-1};
		     int len = nums.length;
		     int[] result = new int[2];
		    
		     return  new int[]{-1,-1};
	 }
	 private int findTargetIndex(int[] nums, int target) {
		 int left = 0;
	     int right = nums.length - 1;
	     int middle = 0;
	     while(left <=  right) {
	    	 middle = (left + right) / 2;
	    	 if(nums[middle] == target) {
	    		 return middle;
	    	 } else if(nums[middle] > target) {
	    		 right = middle -1;
	    	 } else {
	    		 left = middle + 1;
	    	 }
	   }
	     return 0;
   }
}
