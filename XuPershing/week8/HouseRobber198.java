package week8;

public class HouseRobber198 {
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月21日
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed, 
	 * the only constraint stopping you from robbing each of them is that
	 *  adjacent houses have security system connected and it will automatically contact the police 
	 *  if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
	 */
	public int rob(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int size = nums.length;
		int back0 =nums[0], back1 = 0,back2 = 0,tmp;
        for(int i = 1;i < size;i++){
        	tmp = back0;
        	if (back2 > back1) {
				back0 = back2+nums[i];
			}else {
				back0 = back1+nums[i];
			}
        	back2 = back1;
        	back1 = tmp;
        }
        if (back1>back0) {
			back0 = back1;
		}
        return back0;
        	
    }
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月21日
	 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that
	 *  he will not get too much attention. This time, all houses at this place are arranged in a circle. 
	 *  That means the first house is the neighbor of the last one. 
	 *  Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
	 */
	public int robII(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int size = nums.length;
		int back0 =nums[0], back1 = 0,back2 = 0,tmp;
		
        for(int i = 1;i < size;i++){
        	tmp = back0;
        	if (back2 > back1) {
				back0 = back2+nums[i];
			}else {
				back0 = back1+nums[i];
			}
        	back2 = back1;
        	back1 = tmp;
        }
        if (back1>back0) {
			back0 = back1;
		}
        
        return back0;
        	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,5,7,6};
		HouseRobber198 hr = new HouseRobber198();
		System.out.println(hr.rob(nums));
	}

}
