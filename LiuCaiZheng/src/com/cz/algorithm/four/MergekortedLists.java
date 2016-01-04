package com.cz.algorithm.four;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. 
 *                  Analyze and describe its complexity. 
 *       算法思想是维护一个有限队列, 每次均入队一个元素,在入队后,进行调整,
 *       
 *       时间复杂度是   Time: log(k) * n.
 * 
 * */
public class MergekortedLists {

	public static void main(String[] args) {
		
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		 if(lists==null||lists.length == 0) {  
	            return null;  
	        }  
	        if(lists.length ==1) {  
	            return lists[0];
	        }  
	        int length =lists.length;
	        int mid = (length - 1)/2 ;  
	        ListNode l1 = mergeKLists(Arrays.copyOfRange(lists, 0, mid  + 1 ));
	        ListNode l2 = mergeKLists(Arrays.copyOfRange(lists, mid, length )) ;  
	        return merge2Lists(l1,l2) ;  
	}
	private ListNode merge2Lists(ListNode list1, ListNode list2) {
		   ListNode head    = new ListNode(-1);  
	        ListNode current = head;  
	        while(list1!=null&&list2!=null) {  
	            if(list1.val<list2.val) {  
	                current.next = list1;  
	                list1   = list1.next;  
	            } else {  
	                current.next = list2;  
	                list2   = list2.next;  
	            }  
	            current = current.next;  
	        }  
	        if(list1!=null) {  
	            current.next = list1;  
	        } else {  
	            current.next = list2;  
	        }  
	        return head.next;  
	}
	
//	public ListNode mergeKLists(ListNode[] lists) {
//		if(lists == null  || lists.length == 0)  return null;
//		PriorityQueue<ListNode> queue  = new PriorityQueue<ListNode>(lists.length,
//				new Comparator<ListNode>() {
//			public int compare(ListNode a, ListNode b) {
//				return  a.val - b.val;  
//			}
//		});
//		for(ListNode list: lists) {
//			if(list != null) {
//				queue.add(list);
//			}
//		}
//		ListNode returnNode = new ListNode(-1);
//		ListNode curr = returnNode;
//       while(!queue.isEmpty()) {
//    	   ListNode temp = queue.poll();
//    	   curr.next = temp;
//    	   if (temp.next != null)
//				queue.add(temp.next);
//    	   curr = curr.next;
//       }			
//		return returnNode.next;
//	}
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x;next = null;}
 }
