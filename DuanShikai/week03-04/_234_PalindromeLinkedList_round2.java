package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月15日 下午6:25:49
 * @content 
 */

public class _234_PalindromeLinkedList_round2 {
	
	public static void main(String args[]){
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		l1.next=l2;
		System.out.println(isPalindrome(l1));
	}
	
	public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode center = head; ListNode last = null;
        ListNode middle = head; ListNode first = head.next;
        while(center != null && center.next != null){
        	//MISTAKE 这里center必须先移动，因为如果放在后面移动时，指针已经断掉了，无法再往后面移动。
        	center = center.next.next;
        	middle.next=last; 
        	last=middle;
        	middle=first;
        	first=first.next;
        }
        middle = center == null ? middle : first;
    	while(last!=null){
    		if(last.val!=middle.val) return false;
    		last=last.next; middle=middle.next;
    	}
        return true;
    }
}
