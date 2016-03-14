package com.zyy.week6;

/**
 * 
 * @author zyy 问题描述： 爬n阶台阶，每次可以爬一阶或是两阶，问爬到n阶有多少种爬法。
 * 
 *         思路分析： 爬到n阶的爬法可以表示为爬到n-1阶的爬法数（爬一阶到ｎ）加上爬到ｎ－２阶的爬法数（爬两阶到ｎ）。
 *
 */
public class ClimblingStairs {

	// 类似于斐波那契排列
	// 时间和空间复杂度为O(n)
	public int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2)
			return n;
		int[] mem = new int[n];
		mem[0] = 1;
		mem[1] = 2;
		for (int i = 2; i < n; i++) {
			mem[i] = mem[i - 2] + mem[i - 1];
		}
		return mem[n - 1];
	}

	// 递归
	public int climbStairs1(int n) {
		if (n == 0 || n == 1 || n == 2)
			return n;
		return climbStairs1(n - 1) + climbStairs1(n - 2);
	}

	// 非递归
	// 占用空间为O（1），时间复杂度为 O(n)
	public int climbStairs2(int n) {
		if (n == 0 || n == 1 || n == 2)
			return n;
		int stepOne = 1, stepTwo = 1;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = stepOne + stepTwo;
			stepTwo = stepOne;
			stepOne = result;
		}
		return result;
	}

	public static void main(String[] args) {
		ClimblingStairs cs = new ClimblingStairs();
		System.out.println(cs.climbStairs2(35));
	}
}
