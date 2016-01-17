# 46. Permutations

## Front-matter
---
title: 46. Permutations
description: "无重复数的全排列生成算法"
tags:
- backtracking
- 排列与组合
categories:
- week7
---


## Solution

- 直接生成（递归/回溯）
- 邻位互换
- 序数法
- 字典序法
- 轮转法

### 递归
n个不重复数的全排列:
n=1 即为当前排列
n>1 先排第一位 则P<sub>n</sub> = iP<sub>n-1</sub> (i=1,2,3,...n)

**golang**
```golang
func Permtuate(res *[][]int, nums []int, begin int, end int) {
	if begin == end {
		*res = append(*res, nums)
	} else {
		for i := begin; i < end; i++ {
			nums[begin], nums[i] = nums[i], nums[begin]
			Permtuate(res, nums, begin+1, end)
			nums[begin], nums[i] = nums[i], nums[begin]
		}
	}
}
```
**java**
```java
public class Solution {
	
	//46. Permutations
	public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> res = new  ArrayList<List<Integer>>();
		 recursive(res, nums, 0, nums.length);
		 return res;
	}

	void recursive(List<List<Integer>> res, int[] nums, int begin, int end) {
		if (end == begin) {
			List<Integer> li = new ArrayList<Integer>(nums.length);
			for(Integer num:nums){
				li.add(num);
			}
			res.add(li);
		} else {
			for (int i = begin; i < end; i++) {
				swap(nums, begin, i);
				recursive(res, nums, begin + 1, end);
				swap(nums, i, begin);
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	//47.  Permutations II
}
```