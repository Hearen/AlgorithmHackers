package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年1月14日 上午11:26:28
 * @content 
 */

public class _055_Jump_Game {
	
	public static void main(String args[]){
		_055_Jump_Game test = new _055_Jump_Game();
		int nums[]={0};
		System.out.println(test.canJump(nums));
	}
	
	//4ms o(n)
	public boolean canJump_1(int[] nums){
		int maxReach = 0;
		for(int i=0;i<nums.length && i<=maxReach; i++){
			maxReach=Math.max(maxReach, nums[i]+i);
		}
		return maxReach >= nums.length-1;
	}
	
	//2ms o(n^2)
	public boolean canJump(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
        	if(nums[i]==0){
        		int k=i;
        		for(;k>=0;k--){
        			if(nums[k]+k>i) break;
        		}
        		if(k==-1) return false;
        	}
        }
        return true;
    }

}
