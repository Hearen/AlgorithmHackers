package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月12日 下午10:32:12
 * @content 
 */

public class _081_SearchinRotatedSortedArrayII {
	
	public boolean search(int[] nums,int target){
		return _search(nums,0,nums.length-1,target);
	}
	
	public boolean _search(int[] nums,int start,int end,int target){
		if(start>end) return false;
		if(start==end) return nums[start]==target;
		int middle=(end-start)/2+start;
		if(nums[middle]==target)return true;
		return _search(nums,start,middle,target) || _search(nums,middle+1,end,target);
	}

}
