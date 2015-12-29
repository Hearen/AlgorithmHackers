package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月23日 下午8:48:54
 * @content 
 */

public class _147_Insertion_Sort_List_4 {
	
	public static void main(String args[]){
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(1);
		l1.next=l2;
		ListNode result=insertionSortList(l1);
	}
	
	public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode rightHead=head.next; //记录当前正在比较的位置
        ListNode current=rightHead; //记录右边没有排序的头指针
        ListNode sortHead=head; //记录左边已经排序的头指针
        sortHead.next=null;
        ListNode tempSortHead=head; 
        while(rightHead!=null){
        	rightHead=rightHead.next;
        	tempSortHead=sortHead;//找到要插入的位置，从头开始往后遍历查找
        	if(current.val<tempSortHead.val){ //如果插入的位置在头部
        		current.next=tempSortHead;
        		sortHead=current; //更新头部
        	}
        	else{//要插入的位置在中间
        		while(tempSortHead!=null && tempSortHead.next!=null && tempSortHead.next.val < current.val)
            		tempSortHead=tempSortHead.next;
            	ListNode tempRight=tempSortHead.next;
            	tempSortHead.next=current; current.next=tempRight;
        	}
        	current=rightHead;
        }
        return sortHead;
    }

}
