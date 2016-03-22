package com.xingkong;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月9日 上午9:39:21 class description
 */
public class PopulatingNextRightPointersInEachNode_116 {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
		@Override
		public String toString() {
			return "TreeLinkNode [val=" + val + "]";
		}
	}
	public void connect(TreeLinkNode root) {
		if(root==null||root.left==null)
			return;
        root.left.next=root.right;
        if(root.next!=null)
        	root.right.next=root.next.left;
        connect(root.left);
        connect(root.right);
    }
	public static void main(String[] args) {
		
	}

}
