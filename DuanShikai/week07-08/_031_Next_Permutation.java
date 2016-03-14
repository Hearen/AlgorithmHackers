package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年1月12日 下午2:22:15
 * @content 
 */

public class _031_Next_Permutation {
	
	public static void main(String args[]){
		int[] nums={1,2};
		_031_Next_Permutation test = new _031_Next_Permutation();
		test.nextPermutation(nums);
	}
	
	public void nextPermutation(int[] nums) {
        if(nums.length<=1) return; 
        int start=nums.length-1, i=start;
        for(;i>0;i--){
        	if(nums[i]>nums[i-1]){ //找到第一个逆序的位置。
        		start = i;
        		break;
        	}
        }
        if(i==0) sort_(nums,0);
        else sort(nums,start-1);
    }

	private void sort(int[] nums, int start) {
		int rep = findMinLargerPos(nums,start+1,nums[start]);
		swap(nums,rep,start); //交换
		for(int i=start+1;i<nums.length;i++){
			int minPos = findMinPos(nums,i);
			swap(nums,minPos,i);
		}
	}
	
	private void sort_(int[] nums,int start){
		for(int i=start;i<nums.length;i++)
			swap(nums,findMinPos(nums,i),i);
	}
	
	private int findMinLargerPos(int[] nums,int start,int key){
		if(start>=nums.length || start<0) return -1;
		int minPos = start;
		for(int i=start+1;i<nums.length;i++)
			minPos = nums[i]>key && nums[i] < nums[minPos] ? i : minPos;
		return minPos;
	}
	
	private int findMinPos(int[] nums, int start){
		if(start>=nums.length || start<0) return -1;
		int minPos = start;
		for(int i=start+1;i<nums.length;i++)
			minPos = nums[i] < nums[minPos] ? i : minPos;
		return minPos;
	}
	private void swap(int[] nums, int a,int b){
		int temp = nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
}
