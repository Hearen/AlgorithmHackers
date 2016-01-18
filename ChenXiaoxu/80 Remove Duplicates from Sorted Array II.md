# 80. Remove Duplicates from Sorted Array II

## Problem

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


tags: 
- Array
- Two Pointers

## Solution

**java**

```java
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int cur = 2, pre = 1;
		while (cur < nums.length) {
			if (nums[cur] == nums[pre] && nums[cur] == nums[pre - 1])
				cur++;
			else
				nums[++pre] = nums[cur++];
		}
		return pre + 1;
	}
```