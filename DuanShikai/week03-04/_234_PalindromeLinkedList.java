package com.sky.leetcode;
/*
 *  @author: DuanSky
 *    @time: 2015年8月23日 下午12:34:47
 * @content:
 * 题目：
 * 
	Given a singly linked list, determine if it is a palindrome.
	Follow up:
	Could you do it in O(n) time and O(1) space?
	答案:
	    比较精彩的答案：
	    https://leetcode.com/discuss/45656/easy-understand-java-solution-o-1-space-cost
	    该题目的难点是如何使得空间复杂度达到o(1)?
	  继续往下引申为如何在o(1)空间内反转链表？
 */
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){this.val=x;}
}
public class _234_PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if(head==null)
        	return true;
        ListNode temp1,temp2=head;
        int num=0;
        while(temp2.next!=null){ 
        	num++;
        }
        int count=0;
        while(count<=num/2){
        	temp1=head;
        	temp2=head;
        	for(int i=0;i<=count;i++)
        		temp1=temp1.next;
        	for(int i=1;i<num-count;i++)
        		temp2=temp2.next;
        	if(temp1.val!=temp2.val)
        		return false;
        }
        
        return true;
    }
}
