package com.zyy.week11;

public class _307_RangeSumQueryMutable {
	// 9.57%
	class SegmentTreeNode {
		// 记录分段的起始位置
		int start, end;
		SegmentTreeNode left, right;
		int sum;

		// 初始化
		SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}

	SegmentTreeNode root = null;

	public _307_RangeSumQueryMutable(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}

	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end)
			return null;
		// 初始化一个节点
		SegmentTreeNode ret = new SegmentTreeNode(start, end);
		if (start == end)
			ret.sum = nums[start];
		else {
			int mid = start + (end - start) / 2;
			ret.left = buildTree(nums, start, mid);
			ret.right = buildTree(nums, mid + 1, end);
			ret.sum = ret.left.sum + ret.right.sum;
		}
		return ret;

	}

	void update(int i, int val) {
		update(root, i, val);
	}

	// 更新需要先找到这个点的位置，采用二分搜索
	private void update(SegmentTreeNode node, int index, int val) {
		// 只有这一个节点,更新值
		if (node.start == node.end)
			node.sum = val;
		else {
			int mid = node.start + (node.end - node.start) / 2;
			if (index <= mid)
				update(node.left, index, val);
			else
				update(node.right, index, val);
			// 需要更新当前节点的sum值
			node.sum = node.left.sum + node.right.sum;
		}
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	private int sumRange(SegmentTreeNode node, int start, int end) {
		if (node.start == start && node.end == end)
			return node.sum;
		else {
			int mid = node.start + (node.end - node.start) / 2;
			if (end <= mid) {
				return sumRange(node.left, start, end);
			} else if (start >= mid + 1) {
				return sumRange(node.right, start, end);
			} else
				return sumRange(node.left, start, mid)
						+ sumRange(node.right, mid + 1, end);
		}

	}
}
