# 46. Permutations

## Problem

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

tags: 
- array
- binary search

similar problems:

- (M) Search in Rotated Sorted Array II 
- (M) Find Minimum in Rotated Sorted Array


## Solution

```java
public int search(int[] nums, int target) {
	if (nums == null || nums.length == 0)
		return -1;
	int left = 0, right = nums.length - 1;
	while (left <= right) {
		int mid = left + (right - left) / 2;
		if (target == nums[mid])
			return mid;

		if (nums[mid] >= nums[left]) {
			if (nums[left] <= target && target <= nums[mid])
				right = mid - 1;
			else
				left = mid + 1;
		} else {
			if (nums[mid] < target && target <= nums[right])
				left = mid + 1;
			else
				right = mid - 1;
		}
	}
	return -1;
}
```