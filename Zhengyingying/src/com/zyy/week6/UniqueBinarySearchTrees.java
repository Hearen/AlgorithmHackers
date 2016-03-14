package com.zyy.week6;

/**
 * 
 * @author zyy 问题描述： 给定一个整数n，求从1到n的二叉查找树的个数
 * 
 *         解题思路： 以这n个数分别为根，其左边的构成其左子树，其右边的构成其右子树，则以n为根的二叉树的个数为两边构成二叉树的乘积。
 *         F(i, n) = G(i-1) * G(n-i)   1 <= i <= n 
 *         G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
 *
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				//F(i,n);
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}

}
