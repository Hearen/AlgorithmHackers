/**
* @author DuanSky
* @date 2015年12月3日 下午7:41:19
* @content 
*/
package com.sky.leetcode;

public class _080_RemoveDuplicatesfromSortedArrayII {
	public static void main(String args[]){
		int[] nums={1,1,1,1,3,3};
		System.out.println(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		int result=nums.length;int counter=1;int temp=nums[0]; int max=2;
		for(int i=1;i<result;i++){
			int next=nums[i];
			if(next==temp){
				if(counter<max){
					counter++;
					continue;
				}
				int j=i;
				while(j<nums.length-1){
					nums[j]=nums[j+1];
					j++;
				}
				result--;
				i--;
			}
			else{
				counter=1;
				temp=next;
			}
		}
		return result;
	}
}
