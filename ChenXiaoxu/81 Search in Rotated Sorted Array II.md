# 46. Permutations

## Problem

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

tags: 
- array
- binary search

similar problems:

- (M) Search in Rotated Sorted Array


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