package com.zyy.week6;

public class ConvertSortedListtoBinarySearchTree {
	// 二分搜索树：根元素大于其左子树的值，小于其右子树的值
	// 深度优先搜索DFS
	public TreeNode sortedListToBST(ListNode head) {
		return search(head, null);
	}

	private TreeNode search(ListNode head, ListNode node) {
		if (head == node)
			return null;
		// 找到list中间一个元素，就是Tree的根:一个快指针，一个慢指针
		ListNode quick = head, slow = head;
		// 因为quick一次要移动两个位置
		while (quick.next != node && quick != node) {
			quick = quick.next.next;
			slow = slow.next;
		}
		TreeNode tree = new TreeNode(slow.val);
		// 左子树中找中间元素
		tree.left = search(head, slow);
		// 右子树中找中间元素
		tree.right = search(slow.next, node);
		return tree;
	}
}
