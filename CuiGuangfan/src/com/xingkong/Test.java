package com.xingkong;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2015年12月29日 上午9:21:14 class description
 */
public class Test {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	static ListNode getLeftNodeFromList(ListNode head) {
        ListNode next = head;
        while(next!=null) {
            next = next.next;
            if(next==null) {
                break;
            }
            next = next.next;
            if(next==null) {
                break;
            }
            head = head.next;
        }
        return head;
    }
	public static void main(String[] args) {
		ListNode pre=new ListNode(1);
		ListNode head=pre;
		for(int i=2;i<=9;i++){
			ListNode temp=new ListNode(i);
			pre.next=temp;
			pre=temp;
		}
		ListNode check=head;
		while(check!=null){
			System.out.print(check.val+" ");
			check=check.next;
		}
		System.out.println("\n"+getLeftNodeFromList(head).val);
	}

}
