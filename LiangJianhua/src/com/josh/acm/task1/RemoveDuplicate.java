package com.josh.acm.task1;

import org.junit.Test;

/**
 * In a array duplicate elements at most twice 
 * e.g. 
 * Array:[1,1,1,2,2,3]
 * return:length=5 
 * 		  elements=[1,1,2,2,3]
 * 
 * @author Summer
 *
 */
public class RemoveDuplicate {

	//int[] nums = {1,1,1,2,2,3};
	//int len =nums.length;

	@Test
	public void test(){
		
		int[] nums = {1,1,1,2,2,2,3,3};
		removeDuplicates(nums);
		
	}
	
	public int removeDuplicates(int[] nums){
		
		//数组为空的情况
		if(nums.length==0){
			return 0;
		}
		
		int j=0;
		int count=0;//计数器，记录重复出现数字次数
		
		for(int i=1;i<nums.length;i++){
			//
			if(nums[i]==nums[j]){
				count++;//重复出现数字，计数器+1
				if(count<2){
					j++;
					nums[j] = nums[i];
				} 
			}else{
				j++;
				nums[j]=nums[i];
				count = 0;
			}
		}
		
		System.out.println(j+1);
		for(int index=0;index<j+1;index++){
			System.out.println(nums[index]);
		}
		
		return j+1;
	}
}
