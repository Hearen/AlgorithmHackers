package com.xpx.demo;

/**
 * @author xpxstar@gmail.com
 *
 */
public class DuplicateRemove {
	int[] nums = {1,1,1,1,1,1,2,2,2,2,3,3,4,5,5};
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * For example,Given input array nums = [1,1,2],
	 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
	 * It doesn't matter what you leave beyond the new length.
	 */
	public int removeDuplicates(int[] nums){
		/*思路，两个指针i，j. j指向i的下一个不同的数。
		 * count表示已找到的不同数，若找到新的不同数nums[j]则将nums[j]复制到nums[count],count+1
		 * i遍历到lenth-2，j从i+1开始寻找新的不同数，若找到，将j赋给i，继续寻找。
		 * j访问到末尾，表示寻找结束。
		 * 时间复杂度O(N)
		 */
		int count = 1;
		int i=0,j=0;
		while(i < nums.length-1) {
			j=i+1;
			while(j < nums.length && nums[i]==nums[j]){	
				j++;
			}
			if (j >= nums.length) {
				break;
			}
			nums[count++] = nums[j];
			i=j;
		}
		return count;
	}
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 */
	public int removeDuplicatesII(int[] nums){
		/*思路同不重复，需要两点改变
		 * 1.通过布尔变量first判断是否是第一个重复数，如果是，则count++，复制，后边i指针向前移，将first置false
		 * 2.每找到新数，需要重新初始化first为true
		 * 时间复杂度O(N)
		 */
		int count = 1;
		int i=0,j=0;
		boolean first = true;
		while(i < nums.length-1) {
			j=i+1;
			while(j < nums.length && nums[i]==nums[j]){	
				if (first) {
					nums[count++] = nums[j];
					i++;
					first = false;
				}
				j++;
			}
			if (j >= nums.length) {
				break;
			}
			nums[count++] = nums[j];
			i=j;
			first = true;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateRemove dr = new DuplicateRemove();
		System.out.println(dr.removeDuplicates(dr.nums));
		System.out.println(dr.removeDuplicatesII(dr.nums));
	}

}
