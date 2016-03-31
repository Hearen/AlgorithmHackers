package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月9日 下午11:29:29 
* class description
*/
public class N_136_Single_Number {
	public static int singleNumber(int[] nums) {
		int result=nums[0];
		for(int i=1;i<nums.length;i++){
			result=result^nums[i];
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_136_Single_Number.singleNumber(new int[]{1,2,3,1,2}));
	}

}
