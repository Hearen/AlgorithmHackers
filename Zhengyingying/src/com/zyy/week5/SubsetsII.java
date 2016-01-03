package com.zyy.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	// 优化
	public List<List<Integer>> subsetsWithDup1(int[] nums) {
		// 先排序
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int size = 0, startIndex;
		// 每个都有空集
		result.add(new ArrayList<Integer>());
		// 往结果集中的每一个list中增加没有的元素
		for (int i = 0; i < nums.length; i++) {
			// 如果有重复出现的，则开始的位置设为size；
			startIndex = i >= 1 && nums[i] == nums[i - 1] ? size : 0;
			size = result.size();
			for (int j = startIndex; j < size; j++) {
				// 当做一个新的list
				List<Integer> list = new ArrayList<Integer>(result.get(j));
				list.add(nums[i]);
				result.add(list);
			}
		}
		return result;
	}

	// 超时
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		// 先排序
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// 每个都有空集
		result.add(new ArrayList<Integer>());
		// 往结果集中的每一个list中增加没有的元素
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < result.size(); j++) {
				// 当做一个新的list
				List<Integer> list = new ArrayList<Integer>(result.get(j));
				list.add(nums[i]);
				if (!result.contains(list))
					result.add(list);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SubsetsII si = new SubsetsII();
		int[] nums = { 1,2,2 };
		List<List<Integer>> result = si.subsetsWithDup1(nums);
		for (List<Integer> list : result) {
			for (int i : list) {
				System.out.println(i);
			}
		}
	}

}
