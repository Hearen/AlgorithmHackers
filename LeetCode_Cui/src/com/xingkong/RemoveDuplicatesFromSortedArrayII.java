package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2015年12月4日 下午4:14:25 
* 难度：medium
*/
public class RemoveDuplicatesFromSortedArrayII {
	public static int removeDuplicates(int[] nums) {
		int start=0;
		boolean isRepeated=false;
		for(int current=1;current<nums.length;current++){
			if(nums[current]!=nums[start]){
				isRepeated=false;
				start++;
				nums[start]=nums[current];
			}else{
				if(!isRepeated){
					isRepeated=true;
					start++;
					nums[start]=nums[current];
				}
			}
		}
        return start+1;
    }
	public static void main(String args[]){
		int [] a=new int[]{1,1,1,2,2,3};
		System.out.println(removeDuplicates(a));
	}
}
