package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月11日 下午10:49:25 
* class description
*/
public class N_27_Remove_Element {
	public static int removeElement(int[] nums, int val) {
		int p1=0;
		int p2=0;
		while(p1<nums.length&&p2<nums.length){
			if(nums[p1]==val){
				while(p2<nums.length&&nums[p2]==val){
					p2++;
				}
				if(p2==nums.length) p2--;
				if(nums[p1]==nums[p2]) return p1;
				int temp=nums[p1];
				nums[p1]=nums[p2];
				nums[p2]=temp;
				p1++;
			}else{
				p1++;
				p2++;
			}
		}
        return p1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_27_Remove_Element.removeElement(new int[]{1,2,2,3,4}, 0));
	}

}
