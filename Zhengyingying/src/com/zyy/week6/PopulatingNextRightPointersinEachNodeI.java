package com.zyy.week6;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeI {
	//AC : 5ms  9.71%
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
				node.next = null;
				levelNum = list.size();
			} else {
				node.next = list.peek();
			}
		}
	}
	
	//深度优先搜索DFS
	public void connect1(TreeLinkNode root) {
		
	}
}
