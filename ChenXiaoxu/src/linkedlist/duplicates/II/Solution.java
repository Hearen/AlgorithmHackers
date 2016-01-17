package linkedlist.duplicates.II;

import linkedlist.ListNode;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;

		ListNode p = dummyNode;
		while (p.next != null && p.next.next!=null) {
			if (p.next.val == p.next.next.val) {
				int dup = p.next.val;
				while(p.next!=null&&p.next.next!=null) 
					p.next = p.next.next;
			}
			else
				p = p.next;
		}
		return dummyNode.next;
	}
}
