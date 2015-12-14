/**
* @author DuanSky
* @date 2015��12��3�� ����7:41:19
* @content 
*/
package com.sky.leetcode;

public class _080_RemoveDuplicatesfromSortedArrayII {
	public static void main(String args[]){
		int[] nums={1,1,2};
		System.out.println(removeDuplicates_more_beautiful(nums));
	}
	
	public static int removeDuplicates_more_beautiful(int[] nums){
		if(nums.length<3)
			return nums.length;
		int counter=2; int exists=1; int last=1;
		if(nums[0]==nums[1]) exists++;
		for(int i=2;i<nums.length;i++){
			if(nums[i]!=nums[last]){
				counter++;exists=1;
				nums[++last]=nums[i];
			}
			else{
				if(exists!=2){
					counter++;exists++;
					nums[++last]=nums[i];
				}
			}
			
		}
		return counter;
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
					nums[j]=nums[j+1]; //������Ҫ���������鿽����
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
