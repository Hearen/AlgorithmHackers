package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月11日 下午4:47:12
 * @content 
 */

public class _321_Create_Maximum_Number_2_round_V {
	
	public static void main(String args[]){
		_321_Create_Maximum_Number_2_round_V test = new _321_Create_Maximum_Number_2_round_V();
		int[] nums = new int[]{9,1,2,5,8,3};
//		int k =1;
//		int[] res = test.solution(nums, k);
		
		int[] nums1 = new int[]{8, 9};
		int[] nums2 = new int[]{3, 9};
		int k = 3;
		int[] res = test.maxNumber(nums1,nums2,k);
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
       if(nums1 == null || nums1.length == 0) return  createMaxNumber(nums2,k);
       if(nums2 == null || nums2.length == 0) return  createMaxNumber(nums1,k);
       int n1 = nums1.length, n2 = nums2.length;
       int[] res = new int[k];
       for(int  k1 = Math.max(0, k-n2); k1 <= Math.min(k, n1); k1 ++){
    	 int[] temp = merge(createMaxNumber(nums1,k1),createMaxNumber(nums2,k-k1));
    	 res = greater(temp,0,res,0) ? temp : res;
       }
       return res;
    }
	
	// 01 从一个N位整数中抽取K个数组成最大整数
	public int[] createMaxNumber(int[] nums,int k){
		if(nums==null || nums.length==0 || k <= 0) return null;
		int[] res =  new int[k];
		for(int i = 0, j = 0; i < nums.length; i ++){
			while( j > 0 && nums.length - i + j > k && nums[i] > res[j-1])
				j--;
			if( j < k) res[j++] = nums[i];
		}
		return res;
	}
	// 02 两个整数所能组成的最大整数
	public int[] merge(int[] nums1,int[] nums2){
		if(nums1==null || nums1.length == 0) return nums2;
		if(nums2 == null || nums2.length == 0) return nums1;
		int n1 = nums1.length, n2 = nums2.length;
		int[] res = new int[n1+n2];
		for(int k = 0, i = 0, j = 0; k < n1 + n2; k ++){
			res[k] = greater(nums1,i,nums2,j) ? nums1[i++] : nums2[j++];
		}
		return res;
	}

	private boolean greater(int[] nums1, int i, int[] nums2, int j) {
		while(i<nums1.length && j< nums2.length && nums1[i]==nums2[j]){
			i++;
			j++;
		}
		return j==nums2.length || (i < nums1.length && nums1[i]>nums2[j]);
	}
	
	
	
	
	
	
}
