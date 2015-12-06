package com.josh.acm.task1;

import org.junit.Test;

public class ThreeSumClosest {

	@Test
	public void test(){
		
		int[] nums = {0,1,2};
		//		67;
		SumClosest(nums,0);
		//System.out.println((1+2/2));
		
	}
	
	public int SumClosest(int[] nums, int target) {
		
		//判断数组是否少于三个
		if(nums.length<3){
			return -1;
		}
		
		//定义最小距离三个数的和
		int threeSum = 0;
		//初始化相对target的最短距离
		int minDistance = target-nums[0]-nums[1]-nums[2];
		if(minDistance<0){
			minDistance=-minDistance;
		}
		//数组排序，冒泡升序
		int len = nums.length-1;
		for(int i=len; i>0;i--){
			for(int j=0;j<i;j++){
				//int j = len - i;
				if(nums[j]> nums[j+1]){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		//固定两个数，根据和与target比较的大小变化第三个数
		for(int k=0;k<nums.length-2;k++){
			int h=k+1;
			int z=nums.length-1;
			while(h<z){
				int tempThreeSum = nums[k]+nums[h]+nums[z];
				//定义当前和相对于target的距离
				int temDistance;
				if(tempThreeSum<target){//三数之和小于target，指向第二个数（第二大数）的指针向右移动一位以使和逼近target
					temDistance=target-tempThreeSum;
					if(temDistance<=minDistance){
						minDistance=temDistance;
						threeSum = nums[k]+nums[h]+nums[z];
					}
					h++;
				}else if(tempThreeSum>target){//三数之和大于target，指向最右侧（最大值）的指针向左移动一位以使和逼近target
					temDistance=tempThreeSum-target;
					if(temDistance<=minDistance){
						minDistance=temDistance;
						threeSum = nums[k]+nums[h]+nums[z];
					}
					z--;
				}else{//三数之和正好等于target，距离为0
					minDistance = 0;
					threeSum = nums[k]+nums[h]+nums[z];
					System.out.println("最短距离："+minDistance);
					System.out.println("三个数之和："+threeSum);
					return threeSum;
				}
			}
		}
		System.out.println("最短距离："+minDistance);
		System.out.println("三个数之和："+threeSum);
		return threeSum;
    }
}
