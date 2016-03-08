package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年2月25日 上午11:27:51
 * @content 
 */

public class _086_Partition_List {
	
	public static void main(String args[]){
		_086_Partition_List test = new _086_Partition_List();
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		ListNode result = test.partition(head, 0);
	}
	
	//采用用两个指针，一个指针存储的是<key值的元素列表，另一个指针存储的是>=key值的元素列表，再把两个指针合并即可。
	public ListNode partition(ListNode head, int x) {
		
		if(head==null || head.next==null) return head;
		ListNode firstTail=new ListNode(0),firstHead=firstTail;
		ListNode secondTail=new ListNode(0),secondHead=secondTail;
		while(head!=null){
			if(head.val<x){
				firstTail.next=head;
				firstTail=firstTail.next;
			}
			else{
				secondTail.next=head;
				secondTail=secondTail.next;
			}
			head=head.next;
		}
		secondTail.next=null; firstTail.next=secondHead.next;
		return firstHead.next;
    }

}
