package com.josh.task7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 * 给定一个数组，可能有重复元素，求所有不重复的排列情况
 */
public class PermutationsII {
	@Test
	public void test(){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//Set<List<Integer>> set = new HashSet<List<Integer>>();
		int[] nums = {3,3,0,0,2,3,2};
		//per(nums, 0, nums.length-1, set);
		list = permuteUnique(nums);
		//输出结果
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.get(i).size();j++){
				System.out.print(list.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	//把所有排列情况存储在set中，去重，再输出
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	Set<List<Integer>> set = new HashSet<List<Integer>>();
    	per(nums,0,nums.length-1,set);
    	Iterator<List<Integer>> it = set.iterator();
    	while(it.hasNext()){//把set中的元素转储到list中
    		list.add(it.next());
    	}
    	return list;  
    }
    //求数组nums的所有排列
    /*
     * 递归
     */
    public Set<List<Integer>> per(int[] nums,int start,int end ,Set<List<Integer>> set){
    	if(start == end){//当只有一个元素时，一次输出全排序
    		List<Integer> perList = new ArrayList<Integer>();
    		for(int i=0;i<nums.length;i++){
    			perList.add(nums[i]);
    		}
    		set.add(perList);
    	}else{
    		for(int i=start;i<=end;i++){
    			int temp = nums[start];//交换start元素和其之后的元素
    			nums[start] = nums[i];
    			nums[i] = temp;
    			per(nums, start+1, end, set);
    			temp = nums[start];//交换回来
    			nums[start] = nums[i];
    			nums[i] = temp;
    		}
    	}
    	return set;
    }
}
