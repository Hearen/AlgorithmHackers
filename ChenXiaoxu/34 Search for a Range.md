#34. Search for a Range

## Problem

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

tag:
- array
- binary search

## Solution

**java**

```java
	public int[] searchRange(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {
				int p1 = m, p2 = m;
				while (--p1 >= 0 && nums[p1] == target)
					;
				while (++p2 <= (nums.length - 1) && nums[p2] == target)
					;
				return new int[] { ++p1, --p2 };
			} else if (nums[m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return new int[] { -1, -1 };
	}
```
