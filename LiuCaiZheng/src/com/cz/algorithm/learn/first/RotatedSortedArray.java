package com.cz.algorithm.learn.first;

public class RotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {5, 6 ,7,0, 1 ,1,2,2,3,3 ,4};
		int target = 3;
		System.out.println(search(nums, target));
	}
	public static boolean search(int[] nums, int target) {
		int right  = nums.length - 1;
		int left  = 0;
		while (left <=  right) {
			    int middle = (left + right)/2 ; 
			    System.out.println(middle + "   " + nums[middle]);
				if( target ==  nums[middle]) {
					return true;
				} else if(target > nums[middle]) {
					left = middle + 1;
				
				} else if(target <= nums[middle]) {
					right = middle - 1;
				}
	 }
	 return false;
	}
} //done
