package com.sky.leetcode;

import java.util.Arrays;

/**
 * @author DuanSky
 * @date 2015年12月12日 下午9:00:32
 * @content 
 */

public class _016_3SumClosest {
	
	public static void main(String args[]){
		int[] nums={1,1,1,0};
		int target=100;
		System.out.println(threeSumClosest(nums,target));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result=0;
        for(int i=0;i<nums.length && i<3;i++)
        	result+=nums[i];
        for(int i=0;i<nums.length-2;i++){
        	if(i==0 || (i>0 && nums[i]!=nums[i-1])){
        		int start=i+1;int end=nums.length-1;
        		while(start<end){
        			int sum=nums[i]+nums[start]+nums[end];
        			if(Math.abs(sum-target)<Math.abs(result-target)){
        				result=sum;
        				while(start>0 && start<end  && nums[start]==nums[start-1]) start++;
        				while(end<nums.length-1 && start<end && nums[end]==nums[end+1]) end--;
        				if(sum==target)return sum;
        				else if(sum<target)start++;
        				else end--;
        			}
        			else if(sum>target) end--;
        			else start++;
        		}
        	}
        }
        return result;
    }
}
