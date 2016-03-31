package com.xingkong;

import com.xingkong.Test.ListNode;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月7日 下午2:27:37 class description
 */
public class ConvertSortedListtoBinarySearchTree_109 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	// 返回中间节点的前一个节点
	static ListNode getLeftNodeFromList(ListNode head) {
		ListNode next = head;
		ListNode previous = head;
		while (next != null) {
			next = next.next;
			if (next == null) {
				break;
			}
			next = next.next;
			if (next == null) {
				break;
			}
			previous = head;
			head = head.next;
		}
		return previous;
	}
	public static TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		if(head.next==null){
			return new TreeNode(head.val);
		}
		ListNode leftListNode=getLeftNodeFromList(head);
		ListNode rootListNode=leftListNode.next;
		ListNode rightListNode=rootListNode.next;
		leftListNode.next=null;
		rootListNode.next=null;
		TreeNode root=new TreeNode(rootListNode.val);
		root.left=sortedListToBST(head);
		root.right=sortedListToBST(rightListNode);
		return root;
	}
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode pre=head;
		for(int i=2;i<=9;i++){
			ListNode temp=new ListNode(i);
			pre.next=temp;
			pre=temp;
		}
		TreeNode root=sortedListToBST(head);
		System.out.println(root);
	}

}
