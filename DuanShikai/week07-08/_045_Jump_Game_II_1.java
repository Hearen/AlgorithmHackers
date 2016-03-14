package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年1月14日 下午2:14:13
 * @content 
 */

public class _045_Jump_Game_II_1 {
	
	public static void main(String args[]){
		_045_Jump_Game_II_1 test = new _045_Jump_Game_II_1();
		int[] nums={2,3,1,1,4,3,2,5,4,9,1,3,2,1,1};
		System.out.println(test.jump(nums));
		System.out.println(test.jump_(nums));
		System.out.println(test.jump_2(nums));
	}
	
	//宽度优先搜索 o(n)
	public int jump_2(int[] nums){
		int size = nums.length, maxRange = 0, count = 0;
		for(int i=0, pivot=0; i<size-1 && i<=maxRange; i++){
			maxRange = Math.max(maxRange, nums[i]+i);
			if(i==pivot){
				count++;
				pivot = maxRange;
			}
		}
		return maxRange >= size-1 ? count : -1;
	}
	
	
	//o(n^2) TLE
	public int jump(int[] nums) {
        int size = nums.length;
        int[] d=new int[size];
        for(int i=1;i<size;i++){
        	int minStep = Integer.MAX_VALUE;
        	for(int j=0;j<i;j++)
        		if(nums[j]+j>=i)
        			minStep = Math.min(minStep,d[j]+1);
        	d[i]=minStep;
        }
        return d[size-1];
    }
	
	// TLE
	public int jump_(int[] nums){
		int size = nums.length;
		int[] d=new int[size];
		for(int i=0;i<size;i++){
			if(nums[i]+i>=size-1)
				return d[i]+1;
			for(int k=i+1;k<=nums[i]+i;k++){
				d[k] = d[k]==0 ? d[i]+1 : d[k];
			}
		}
		return d[size-1];
	}
}
