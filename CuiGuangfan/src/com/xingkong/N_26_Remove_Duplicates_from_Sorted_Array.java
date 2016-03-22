package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月9日 上午8:56:42 
* class description
*/
public class N_26_Remove_Duplicates_from_Sorted_Array {
	public static int removeDuplicates(int[] nums) {
		int count=0;
		int i=0;
		while(i<nums.length){
			if(i==0||nums[i]!=nums[i-1]){
				nums[count]=nums[i];
				count++;
			}
			i++;	
		}
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_26_Remove_Duplicates_from_Sorted_Array.removeDuplicates(new int[]{1,1,1,2,2,3}));
	}

}
