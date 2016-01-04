package com.cz.algorithm.four;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
 * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的。利用归并的思想，
 * 递归地将当前链表分为两段，然后merge，分两段的方法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，
 * 知道快的走到了末尾，然后慢的所在位置就是中间位置，这样就分成了两段。
 * 
 * 
 * merge时，把两段头部节点值比较，用一个 p 指向较小的， 且记录第一个节点，然后
 * 两段的头一步一步向后走， p也一直向后走，总是指向较小节点，直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可
 * */
public class SortList {

//	public static void main(String[] args) {
//       
//	}

	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
        ListNode middleNode = getMiddleNode(head);
        ListNode next = middleNode.next;
        middleNode.next = null;
        return merge(sortList(head), sortList(next));
	}
	private ListNode merge(ListNode listNode, ListNode listNode2) {
		  ListNode Head = new ListNode(-1);  
	      ListNode curr = Head;  
	      while(listNode != null  && listNode2 != null) {
	    	  if(listNode.val <= listNode2.val) {
	    		  curr.next = listNode;
	    		  listNode = listNode.next;
	    	  } else {
	    		  curr.next = listNode2;
	    		  listNode2 = listNode2.next;
	    	  }
	    	  curr = curr.next;
	      }
	      curr.next = listNode !=null?  listNode : listNode2;  
		return Head.next;
	}
	
	//设置两个指针寻找相应的中点的位置.
	private ListNode getMiddleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow  = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}

class ListNode2 {
	int val;
	ListNode2 next;
	ListNode2(int x) {
		val = x;
	}
}
