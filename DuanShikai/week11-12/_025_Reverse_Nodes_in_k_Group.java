package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月17日 下午1:12:03
 * @content 
 */

public class _025_Reverse_Nodes_in_k_Group {
	
	public static void main(String args[]){
		_025_Reverse_Nodes_in_k_Group test = new _025_Reverse_Nodes_in_k_Group();
		ListNode head = ListNode.generate(new int[]{1,2});
		int k = 2;
		ListNode t = test.reverseKGroup(head, k);
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null) return head; //至少需要两个元素才有翻转的必要
        ListNode  lastTail = new ListNode(0), res = lastTail,thisNext = null, nextHead = head, curr = head;
        while(curr != null){
        	int counter = 1; 
        	while(nextHead != null && counter < k) { //记录需要反转的链表
        		nextHead = nextHead.next;
        		counter ++;
        	} 
        	ListNode thisHead = curr;
        	if( nextHead != null && counter == k){ //需要反转
        		nextHead = nextHead.next;
        		ListNode thisTail = null;
        		while(curr!=nextHead){
        			thisNext = curr.next;
        			curr.next = thisTail;
        			thisTail = curr;
        			curr = thisNext;
        		}
        		lastTail.next = thisTail;
        		lastTail = thisHead;
        	}else{
        		lastTail.next = thisHead;
        		break;
        	}
        }
        return res.next;
    }
}
