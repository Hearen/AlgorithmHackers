package com.josh.acm.task1;

import org.junit.Test;

/**
 * 旋转数组中找到指定key
 * Search in Rotated Sorted Array,and Get the key.
 * 
 * 二分法查找
 * 
 * @author Summer
 *
 */

public class SearchInRotated {
	
	@Test
	public void test(){
		
		int[] nums = {1,3,5};
		search(nums,1);
		//System.out.println((1+2/2));
		
	}
	
    public boolean search(int[] nums, int target) {
        //数组为空时，直接返回false
    	if(nums.length == 0){
    		return false;
    	}

    	//目标key的index
    	int targetIndex=-1;
    	
    	//定义边界，中点
    	int left=0;
    	int right=nums.length-1;
    	//System.out.println(targetIndex);
    	//二分法查找
    	while(left<=right){
    		int mid=(left+right)/2;
    		//中点即为target,直接返回true
    		if(target==nums[mid]){
        		targetIndex=mid;
        		System.out.println(targetIndex);
        		return true;
        	}
    		if(nums[mid]==nums[right]){//缩减右侧边界
    			right=right-1;
    		}else if(nums[mid]==nums[left]){//缩减左侧边界
    			left=left+1;
    		}else if(nums[mid]<nums[right]){//说明从mid到right有序
        		if(target>nums[mid] && target<=nums[right]){//说明target在右侧有序范围内
        			left=mid+1;//更新左侧边界
        		}else{//说明target在左侧无序范围内
        			right=mid-1;//更新右侧边界
        		}
        	}else{//说明从left到mid有序
        		if(target<nums[mid] && target>=nums[left]){//说明target在左侧有序范围内
        			right=mid-1;//更新右侧边界
        		}else{//说明target在右侧无序范围内
        			left=mid+1;//更新左侧边界
        		}
        	}
    	}
    	System.out.println(targetIndex);
		return false;
    }
}
