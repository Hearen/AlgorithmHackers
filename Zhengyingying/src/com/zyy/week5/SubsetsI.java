package com.zyy.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsI {
	public List<List<Integer>> subsetsWithDup1(int[] nums) {
		// 先排序
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int size;
		// 每个都有空集
		result.add(new ArrayList<Integer>());
		// 往结果集中的每一个list中增加没有的元素
		for (int i = 0; i < nums.length; i++) {
			size = result.size();
			for (int j = 0; j < size; j++) {
				// 当做一个新的list
				List<Integer> list = new ArrayList<Integer>(result.get(j));
				list.add(nums[i]);
				result.add(list);
			}
		}
		return result;
	}
	
	//超时
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// 每个都有空集
		result.add(new ArrayList<Integer>());
		// 往结果集中的每一个list中增加没有的元素
		for (int i = 0; i < nums.length; i++) {
			//需要把result.size()提出来，因为这里每次都要计算一次
			for (int j = 0; j < result.size(); j++) {
				// 当做一个新的list
				List<Integer> list = new ArrayList<Integer>(result.get(j));
				list.add(nums[i]);
				result.add(list);
			}
		}
		return result;
	}
}
