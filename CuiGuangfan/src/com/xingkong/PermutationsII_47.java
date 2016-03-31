package com.xingkong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年1月11日 下午10:46:32 
* class description
*/
public class PermutationsII_47 {
	private void swap(int[] nums, int index1, int index2) {
		// 不能使用nums[index1]=nums[index1]^nums[index2];
		// nums[index2]=nums[index1]^nums[index2];
		// nums[index1]=nums[index1]^nums[index2];
		// 当index1=index2时，由于nums[index1]和nums[index2]使用的地址相同，会导致nums[index1]和nums[index2]变为0
		// 如果将值赋值给a,b，由于a和b地址不同，所以不会产生这个问题
		int a = nums[index1];
		int b = nums[index2];
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		nums[index1] = a;
		nums[index2] = b;
	}
	HashSet<List<Integer>> result=new HashSet<List<Integer>>();
	//每次从后面去一个数num[i]，替换num[cur]。
	//	因为num内存在相同的数，也就是说，num[k] 可能和num[j]相同。
	//	因此如果num[i]已经在cur这个位置上出现过，这num[j]可以直接跳过去（所以，应该从cur位置开始一直到j，在这段区域内查看存在num[i]是否有与num[j]相同的数字，即cur<=i<j）。
	boolean needSwap(int[]nums,int current,int j){
		while(nums[current]!=nums[j]&&current<j) current++;
		if(current==j) return true;
		else 
			return false;
	}
	private void backTrace(int[] nums,int currentIndex){
		if(currentIndex>=nums.length){
			List<Integer> temp=new ArrayList<Integer>();
			for(int value:nums){
				temp.add(value);
			}
			result.add(temp);
				
		}
		for(int i=currentIndex;i<nums.length;i++){
			if(!needSwap(nums,currentIndex,i))
				continue;
			swap(nums,currentIndex,i);
			backTrace(nums,currentIndex+1);
			swap(nums,currentIndex,i);
			
		}
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		backTrace(nums,0);
		return new ArrayList<List<Integer>>(result);
        
    }
	public static void main(String[] args) {
		PermutationsII_47 pI=new PermutationsII_47();
		System.out.println(pI.permuteUnique(new int[]{1,1,2}));
	}

}
