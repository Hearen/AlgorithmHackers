package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月9日 下午11:32:14 
* class description
*/
public class N_137_Single_NumberII {
	public static int singleNumber(int[] nums) {
		int[] array=new int[32];
		int result=0;
		for(int i=0;i<32;i++){
			for(int j=0;j<nums.length;j++){
				array[i]+=(nums[j]>>i)&1;
			}
			if(array[i]%3!=0)
				result+=1<<i;
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_137_Single_NumberII.singleNumber(new int[]{1,1,1,2,2,3,2}));
	}

}
