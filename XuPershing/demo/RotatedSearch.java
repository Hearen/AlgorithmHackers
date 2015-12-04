package com.xpx.demo;

/**
 * @author xpxstar@gmail.com
 */
public class RotatedSearch {
	int[] nums = {4,5,6,7,8,9,10,11,12,13,0,1,2,3};
	int[] nums2 = {1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1};
	/**
	 * @param nums
	 * @param target
	 * @return
	 * @author xpxstar@gmail.com
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * You are given a target value to search. If found in the array return its index, otherwise return -1.
	 * You may assume no duplicate exists in the array.
 	 */
	public int searchNoDuplicate(int[] nums, int target) {
		/*思路。 获取nums长度l，二分，得到mid=l/2,
		 * 有四种情况：
		 * 1.start~mid递增，且target在该段
		 * 2.start~mid非递增，且target在该段		
		 * 3.mid~end递增，且target在
		 * 4.mid~end非递增，且target在
		 * 若符合上述4种情况，继续二分查找
		 * 若不符合，返回false
		 * 可以使用循环或者递归实现
		 * 时间复杂度O(lgN)
		 */
		int len = nums.length;
        return binarySearch(0,len-1,nums,target);
    }
		private int binarySearch(int start,int end,int[] nums,int target){
			if (start == end) {
				return nums[start] == target?start:-1;
			}
			int middle = (start+end)/2;
			if(nums[start] <= nums[middle] && nums[start] <= target && nums[middle] >= target){//递增且target在
				return binarySearch(start,middle,nums,target);
			}else if (nums[start] >nums[middle] && !(nums[start] > target && nums[middle] < target)) {//非递增且target在里面
				return binarySearch(start,middle,nums,target);
			}else if(nums[middle+1] <= nums[end] && nums[middle+1] <= target && nums[end] >= target){//递增且target在
				return binarySearch(middle+1,end,nums,target);
			}else if(nums[middle+1] > nums[end] && !(nums[middle+1] > target && nums[end] < target)){//非递增且target在里面
				return binarySearch(middle+1,end,nums,target);
			}else{
				return -1;
			}
		}
	/**
	 * @param nums
	 * @param target
	 * @return
	 * @author xpxstar@gmail.com
	 * Follow up for "Search in Rotated Sorted Array":
	 * What if duplicates are allowed?
	 * Would this affect the run-time complexity? How and why?
	 * Write a function to determine if a given target is in the array.
	 */
	public boolean searchDuplicate(int[] nums, int target) {
		/*思路.基本思想同无重复数组，但是有两个点需要特殊处理
		 * 1.返回值，存在，返回true，否则false
		 * 2.重复处理，若出现首尾相同，这里将起始点前移，排除重复。
		 * 时间复杂度，平均O(lgN)，最坏O(N)
		 */
		int len = nums.length;
        return binaryBiSearch(0,len-1,nums,target);
    }
		private boolean binaryBiSearch(int start,int end,int[] nums,int target){
			if (start == end) {
				return nums[start] == target?true:false;
			}
			if (nums[start]==nums[end]){start++;return binaryBiSearch(start,end,nums,target);};
			int middle = (start+end)/2;
			if(nums[start] <= nums[middle] && nums[start] <= target && nums[middle] >= target){//非递减且target在
				return binaryBiSearch(start,middle,nums,target);
			}else if (nums[start] >nums[middle] && !(nums[start] > target && nums[middle] < target)) {//非递增且target在里面
				return binaryBiSearch(start,middle,nums,target);
			}else if(nums[middle+1] <= nums[end] && nums[middle+1] <= target && nums[end] >= target){//递增且target在
				return binaryBiSearch(middle+1,end,nums,target);
			}else if(nums[middle+1] > nums[end] && !(nums[middle+1] > target && nums[end] < target)){//非递增且target在里面
				return binaryBiSearch(middle+1,end,nums,target);
			}else{
				return false;
			}
		}
	public static void main(String args[]) {
		RotatedSearch rs = new RotatedSearch();
		System.out.println(rs.searchNoDuplicate(rs.nums, 11));
		System.out.println(rs.searchDuplicate(rs.nums2, 3));
	}
}
