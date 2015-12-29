package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月23日 下午8:29:37
 * @content 
 */

public class _148_Sort_List {
	
	public static void main(String args[]){
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(1);
		l1.next=l2;
		ListNode result=sortList(l1);
	}
	
	public static ListNode sortList(ListNode head) {
        if(head==null || head.next == null) return head;
        //split 
        ListNode fast=head; ListNode slow=new ListNode(0); slow.next=head;
        while(fast!=null && fast.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }
        fast=slow.next; slow.next=null;
        //sort
        ListNode left=sortList(head);
        ListNode right=sortList(fast);
        //merge ordered list
        return merge(left,right);
    }
	
	public static ListNode merge(ListNode left,ListNode right){
		if(left == null) return right;
		if(right == null) return left;
		ListNode result=new ListNode(0); ListNode head=result;
		while(left!=null && right!=null){
			if(left.val<right.val){
				result.next=left;
				left=left.next;
			}
			else{
				result.next=right;
				right=right.next;
			}
			result=result.next;
		}
		if(left!=null) result.next=left;
		else result.next=right;
		return head.next;
	}

}
