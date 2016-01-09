package com.zyy.week6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	// 宽度优先搜索BFS
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result ;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//保证顺序
		LinkedList<Integer> valList = new LinkedList<Integer>();
		int levelNumber = 1;
		boolean flag = true;
		queue.add(root);
		TreeNode node;
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (flag)
				valList.add(node.val);
			else
				valList.addFirst(node.val);

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			} 

			--levelNumber;
			if (levelNumber == 0) {
				result.add(valList);
				//这一层，有几个需要处理的
				levelNumber = queue.size();
				//不能使用clear方法：这里都是指针，只是clear还是指的原来的list，如果要新的，就得重新创建
				valList= new LinkedList<Integer>();
				flag = !flag;
			}
		}
		return result;
	}

}
