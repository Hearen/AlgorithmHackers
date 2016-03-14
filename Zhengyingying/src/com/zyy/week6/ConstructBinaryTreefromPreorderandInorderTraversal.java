package com.zyy.week6;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	// 深度优先搜索DFS
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildChildTree(0, preorder.length - 1, inorder, preorder, 0);
	}

	// 超时
	public TreeNode buildChildTree(int left, int right, int[] inorder,
			int[] preorder, int preIndex) {
		// 出口判断很重要
		if (preIndex >= preorder.length || left > right)
			return null;
		// 先根遍历中取出的是根元素
		TreeNode tree = new TreeNode(preorder[preIndex]);
		// 找以 tree为根的左右子树
		int index = 0;
		for (int i = left; i <= right; i++) {
			if (tree.val == inorder[i]) {
				index = i;
				break;
			}
		}
		// 左子树
		tree.left = buildChildTree(left, index - 1, inorder, preorder,
				preIndex + 1);
		// 右子树
		// 注意先序的位置
		tree.right = buildChildTree(index + 1, right, inorder, preorder,
				preIndex + index - left + 1);
		return tree;
	}

	public static void main(String[] args) {
		int[] inorder = new int[] { 1, 2, 3, 4 };
		int[] preorder = new int[] { 3, 1, 2, 4 };
		ConstructBinaryTreefromPreorderandInorderTraversal cbtpit = new ConstructBinaryTreefromPreorderandInorderTraversal();
		cbtpit.buildTree(preorder, inorder);

	}

}
