package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月24日 下午7:45:38
 * @content 
 * 	这个题目的意思是，从右往左数第k个元素将链表分成两半。需要注意的是k值可能很大。甚至大于链表的长度。
 */

public class _061_Rotate_List {
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int size=0; ListNode temp=head;
        while(temp!=null){
        	temp=temp.next;
        	size++;
        }
        int i=0;
        int pos= k % size; //计算分离的位置
        if(pos==0) return head;
        ListNode first=head; ListNode second=head;
        while(++i<=pos)
        	first=first.next;
        while(first.next!=null){
        	first=first.next;
        	second=second.next;
        }
        ListNode result=second.next;
        second.next=null;
        first.next=head;
        return result;
    }

}
