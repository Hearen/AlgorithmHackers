package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月25日 上午9:58:39
 * @content 
 */

public class _092_Reverse_Linked_List_II {
	
	public static void main(String args[]){
		ListNode head=new ListNode(3);
		head.next=new ListNode(5);
		reverseBetween(head,1,2);
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
       if(head==null || head.next==null || m==n) return head;
       int current=0; ListNode first=head; ListNode second=head;
       ListNode broken=new ListNode(0); broken.next=head;
       ListNode connector=broken; ListNode result=broken;
       ListNode temp=head;

	   while(++current<m) //循环找到m指向的位置
		   broken=broken.next;
	   first=broken.next; connector=broken.next;
	   second=first.next; first.next=null;
	   temp=second!=null ? second.next : null;
	   while(++current<=n){//MISTAKE 注意取等
		   second.next=first; 
		   first=second;
		   second=temp; 
		   temp=temp!=null? temp.next : null;
	   }
	   broken.next=first;
	   connector.next=second;
       return result.next;
    }
}
