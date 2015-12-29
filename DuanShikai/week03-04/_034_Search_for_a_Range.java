package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月22日 下午8:22:43
 * @content 
 */

public class _034_Search_for_a_Range {
	
	public static void main(String args[]){
		int[] nums={7,7,7,7,7};
		int target=7;
		int[] result=searchRange(nums,target);
		System.out.println(result[0]+" "+result[1]);
		//System.out.println(findRight(nums,target));
	}
	
	public static int findLeft(int[] nums,int target){
		int low=0;int high=nums.length-1;int middle=0;
		while(low<high){
			middle=(low+high)/2;
			if(nums[middle]<target)
				low=middle+1;
			else //如果target和 middle相等，那么也需要将high移动到middle，即保证相等时也要往左一定
				high=middle;
		}
		return nums[low]==target ? low : -1;
	}
	
	public static int findRight(int nums[],int target){
		int low=0;int high=nums.length-1;int middle=0;
		while(low<high){
			middle=(low+high+1)/2;
			if(nums[middle]<=target)
				low=middle;
			else
				high=middle-1;
		}
		return nums[high]==target ? high : -1;
	}
	
	public static int[] searchRange(int[] nums,int target){
		int low=0;int high=nums.length-1;int middle=0;
		int result[]=new int[]{-1,-1};
		while(low<high){
			middle=(low+high)/2;
			if(nums[middle]<target)
				low=middle+1;
			else
				high=middle;
		}
		if(nums[low]!=target)
			return result;	
		else{
			result[0]=low;
			high=nums.length-1; middle=low;
			while(low<high){
				middle=(low+high+1)/2;
				if(nums[middle]<=target)
					low=middle;
				else
					high=middle-1;
			}
			result[1]=high;
			return result;
		}
		
	}
}
