package com.xingkong;

import java.util.ArrayList;
import java.util.Arrays;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月15日 下午10:21:00 
* class description
*/
public class N_16_3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min=Integer.MAX_VALUE;
		int finalMin=0;
		for(int p1=0;p1<nums.length-2;p1++){
			if(p1>0&&nums[p1]==nums[p1-1]) continue;//优化点2
			int p2=p1+1;
			int p3=nums.length-1;
			while(p2<p3){
				int tempMin=nums[p1]+nums[p2]+nums[p3];
				if(Math.abs(tempMin-target)<min){
					min=Math.abs(tempMin-target);
					finalMin=tempMin;
					if(min==0) return tempMin;
				}
				if(tempMin<target){
					while (p2 < p3 && nums[p2] == nums[p2+1]){//优化点6
                    	p2++;
                    }
                    p2++;
				}else{
					while (p2 < p3 && nums[p3] == nums[p3 - 1]){//优化点5
						p3--;
                    }
					p3--;
				}
			}
		}
        return finalMin;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_16_3Sum_Closest n=new N_16_3Sum_Closest();
		System.out.println(n.threeSumClosest(new int[]{1,1,1,0},-100));
	}

}
