package com.xingkong;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月20日 上午8:44:09 class description
 */
public class HouseRobber_198 {

	/**
	 * 转移方程：money[(i)=max{money(i-1),money(i-2)+nums[i]}
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] money = new int[nums.length];
		money[0] = nums[0];
		if (nums.length >= 2)
			money[1] = nums[1] > nums[0] ? nums[1] : nums[0];
		for (int i = 2; i < nums.length; i++) {
			money[i] = money[i - 1] >= (money[i - 2] + nums[i]) ? money[i - 1] : (money[i - 2] + nums[i]);
		}
		return money[nums.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber_198 hr = new HouseRobber_198();
		System.out.println(hr.rob(new int[] {}));
	}

}
