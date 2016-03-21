package com.xingkong;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月9日 上午9:39:21 class description
 * 未解决，输出错误!
 */
public class PopulatingNextRightPointersInEachNode_117 {
	public static class TreeLinkNode {
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

	public void connectNode(TreeLinkNode root) {
		//输入的根节点
		TreeLinkNode rootHeadNode = root;
		while (rootHeadNode != null) {
			TreeLinkNode headNode = null;
			TreeLinkNode currentNode = rootHeadNode;
			boolean flag = true;
			while (currentNode != null) {
				TreeLinkNode lastNode=null;
				TreeLinkNode linkedToRight = null;
				if (currentNode.left != null) {
					currentNode.left.next = currentNode.right;
					linkedToRight = currentNode.left;
					lastNode=currentNode.left;
					if (flag) {
						headNode = currentNode.left;
						flag = false;
					}
				}
				if (currentNode.right != null) {
					linkedToRight = currentNode.right;
					lastNode=currentNode.left;
					if (flag) {
						headNode = currentNode.right;
						flag = false;
					}
				}
				TreeLinkNode linkedToLeft = null;
				if (currentNode.next != null) {
					if (currentNode.next.left != null) {
						currentNode.next.left.next = currentNode.next.right;
						linkedToLeft = currentNode.next.left;
						lastNode=currentNode.next.left;
						if (flag) {
							headNode = currentNode.next.left;
							flag = false;
						}
					} else {
						linkedToLeft = currentNode.next.right;
						if(currentNode.next.right!=null)
							lastNode=currentNode.next.right;
						if (flag) {
							headNode = currentNode.next.right;
							flag = false;
						}
					}
				}
				if (linkedToRight != null) {
					linkedToRight.next = linkedToLeft;
				}else if(lastNode!=null){
					lastNode.next=linkedToLeft;
				}
				currentNode = currentNode.next;
			}
			rootHeadNode = headNode;
		}
	}

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode_117 t=new PopulatingNextRightPointersInEachNode_117();
		TreeLinkNode tln=new TreeLinkNode(0);
		t.connectNode(tln);
	}

}
