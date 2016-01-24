package com.josh.task8;


import org.junit.Test;
/*
 * 在一列数组中取出一个或多个不相邻数，使其和最大
 * 动态规划
 */
public class HouseRobber {
	@Test
	public void test(){
		int[] nums = {2,1,1,2};
		System.out.println(rob2(nums));
	}
   /*
    * 动态规划 关键在于找到状态转移方程和初始状态
    * 定义数组dp[i]存储在位置i时的最大值
    * 状态转移方程：dp[i] = max(dp[i-1],dp[i-2]+nums[i])
    * 最后返回dp[nums.length-1]
    */
	public int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		int[] dp = new int[nums.length];
		dp[0] = nums[0];//初始状态
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++){
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);//状态转移方程
		}
		return dp[nums.length-1]; 
    }
	/*
	 *取值要么在奇数位置要么在偶数位置，用两个变量a，b来记录奇数位置和偶数位置的取值
	 *
	 */
	public int rob2(int[] nums){
		int a=0,b=0;
		for(int i=0;i<nums.length;i++){
			if(i%2==0){//取偶数位置的数
				a+=nums[i];
				a=Math.max(a,b);//更新最大值
			}else{
				b+=nums[i];
				b=Math.max(a, b);
			}
		}
		return Math.max(a, b);
	}
}
