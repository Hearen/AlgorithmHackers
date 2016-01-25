package com.zyy.week6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author zyy
 * 
 *         问题描述： 将一个完全二叉树的同一层上的节点用next连接起来
 * 
 *         注意事项： 使用固定的空间，因此谨慎使用队列，会影响效率。
 * 
 *         解题思路： 使用递归
 *
 */
public class PopulatingNextRightPointersinEachNodeI {
	// AC : 5ms 9.71%
	// 广度优先搜索BFS
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
		int levelNum = 1;
		list.add(root);
		while (!list.isEmpty()) {
			TreeLinkNode node = list.poll();
			if (node.left != null)
				list.add(node.left);
			if (node.right != null)
				list.add(node.right);
			levelNum--;
			if (levelNum == 0) {
				levelNum = list.size();
			} else {
				node.next = list.peek();
			}
		}
	}

	// 迭代
	// 两次遍历
	public void connect1(TreeLinkNode root) {
		TreeLinkNode level_start = root;
		while (level_start != null) {
			TreeLinkNode cur = level_start;
			while (cur != null) {
				if (cur.left != null)
					cur.left.next = cur.right;
				if (cur.right != null && cur.next != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			level_start = level_start.left;
		}
	}
}
