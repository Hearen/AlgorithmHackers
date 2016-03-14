# 26. Remove Duplicates from Sorted Array

## Problem

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.



---

title: 26. Remove Duplicates from Sorted Array
description: ""
tags:
- Arrary
- Two Pointers

categories:
- week7

---


## Solution

**java**

```java
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return nums.length;
		int cur = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[cur]) {
				nums[++cur] = nums[i];
			}
		}
		return cur + 1;
	}
```