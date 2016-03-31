package com.xingkong;


/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年3月8日 下午8:02:50 class description
 */
public class N_21_Merge_Two_Sorted_Lists {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=new ListNode(1);
		ListNode first=head;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				head.next=l1;
				l1=l1.next;
			}else{
				head.next=l2;
				l2=l2.next;
			}
			head=head.next;
		}
		while(l1!=null){
			head.next=l1;
			l1=l1.next;
			head=head.next;
		}
		while(l2!=null){
			head.next=l2;
			l2=l2.next;
			head=head.next;
		}
		return first.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//一次性通过，无需测试
	}

}
