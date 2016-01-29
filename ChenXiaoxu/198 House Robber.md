# 198. House Robber

## Problem

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

tag:
- dp

## Solution

dp[i] = max( dp[i-1], dp[i-2] + num[i] )
dp[0] = nums[0]
dp[1] = max(nums[0],nums[1])

```java
	public int rob(int[] nums) {
		if(nums.length<=1)
			return nums.length==0?0:nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0]; dp[1] = Math.max(nums[0], nums[1]);
		for(int i=2; i<nums.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		return dp[nums.length-1];
	}
```

