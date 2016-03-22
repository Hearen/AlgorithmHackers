package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月14日 上午8:38:51 
* class description
*/
public class N_83_Remove_Duplicates_from_Sorted_List {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
	        ListNode p1=head;
	        ListNode p2=head;
	        while(p2.next!=null){
	        	p2=p2.next;
	        	if(p1.val==p2.val){
	        		//p2=p2.next;
	        		p1.next=p2.next;
	        	}
	        	else{
	        		p1=p1.next;
	        	}
	        }
	        return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
