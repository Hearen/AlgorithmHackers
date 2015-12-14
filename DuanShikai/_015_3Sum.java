package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author DuanSky
 * @date 2015年12月11日 下午4:32:04
 * @content 
 * 本题的重点是如何去重。
 */

public class _015_3Sum {

	public static void main(String args[]){
		int[] nums={-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}
	
	
	public static List<List<Integer>> threeSum(int[] nums){
		//进来先排序
		Arrays.sort(nums);
	    List<List<Integer>> result=new ArrayList<>();
	    if(nums.length<3) return result;
	    for(int i=0;i<nums.length-2;i++){
	    	if(i==0 || (i>0 && nums[i]!=nums[i-1])){ //trick1:在这里第一次去重。
	    		/*
	    		 * trick1:为什么在这里可以这样直接跳过相同的元素？
	    		 * 不妨假设nums:a a a b b b c c c c ,...,g
	    		 * 且此时i指向的是第二个a,判断前面有一个重复的a，于是直接跳过，继续往后找到c。
	    		 * 如果不跳过，那么将要在 a,b,b,b,c,c,c,c,...,g 中找到sum.
	    		 * 如果跳过，那么将要在 b,b,b,c,c,c,c,...g中同样找到该sum。而这两个数组唯一的区别是
	    		 * 是否再次的包含若干个a. 假设在第一个a的扫描过程中，用到了后面的一个a,那么在后面的扫描中，肯定不能再次用到
	    		 * 这个a,如果用到了肯定会重复，当然这是针对3Sum而言的，因为3Sum中如果有前两个元素都相同，那么第三个元素肯定相同
	    		 * 而如果在前面的扫描中没有用到这个a,那么在后面的扫描中，肯定也不会使用这个a。 不然为啥前面的没有扫描出来？o(╯□╰)o
	    		 * 所以这样的过滤对3Sum是有效的。
	    		 */
	    		int start=i+1; int end=nums.length-1;
	    		while(start<end){
	    			int sum=nums[i]+nums[start]+nums[end];
	    			if(sum==0){
	    				result.add(Arrays.asList(nums[i],nums[start++],nums[end--]));
	    				//注意，只有找到了才需要过滤，没有找到肯定不能过滤掉
		    			while(start<end && nums[start]==nums[start-1]) start++; //trick2:如果遇到相同的元素，直接跳过。过滤重复。
		    			while(end>start && nums[end]==nums[end+1]) end--;
	    			}
	    			else if(sum<0)start++;
	    			else end--;
	    		}
	    	}
	    }
	    return result;
	}
	
	public static List<List<Integer>> threeSum_time_limited(int[] nums) {
        Set<List<Integer>> result=new HashSet<List<Integer>>();
        if(nums.length<3){
        	result.add(new ArrayList<Integer>());
        	return new ArrayList<>(result);
        }
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	int subsum=0-nums[i]; //这个是剩下的两个数的和。
        	map.clear();
        	for(int j=i+1;j<nums.length;j++){
        		if(map.containsKey(nums[j])){
        			List<Integer> list=new ArrayList<Integer>();
        			list.add(nums[i]);list.add(nums[j]);list.add(nums[map.get(nums[j])]);
        			Collections.sort(list);
        			result.add(list);
        		}
        		else
        			map.put(subsum-nums[j], j);
        	}
        }
        return new ArrayList<>(result);
    }
}
