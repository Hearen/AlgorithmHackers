package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年1月6日 下午4:24:11
 * @content 
 */

public class _109_Convert_Sorted_List_to_Binary_Search_Tree {
	
	public TreeNode sortedListToBST(ListNode head) {
		return generate(head);
    }
	
	public TreeNode generate(ListNode head){
		if(head==null) return null;
		if(head.next==null) return new TreeNode(head.val);
		ListNode middle = getMiddle(head);
		TreeNode root = new TreeNode(middle.next.val);
		ListNode right = middle.next != null ? middle.next.next : null;
		middle.next = null;
		root.left = generate(head);
		root.right = generate(right);
		return root;
	}
	
	public ListNode getMiddle(ListNode head){
		ListNode fast=head,slow=head,temp=head;
		while(fast!=null && fast.next!=null){
			temp=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		return temp;
	}
}
