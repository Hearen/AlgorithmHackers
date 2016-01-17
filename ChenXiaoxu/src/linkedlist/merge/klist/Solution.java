package linkedlist.merge.klist;

import java.util.List;

import linkedlist.ListNode;

public class Solution {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return mergeHelper(lists, 0, lists.length - 1);
	}

	private ListNode mergeHelper(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		}
		int mid = start + (end - start) / 2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid + 1, end);
		return mergeTwoLists(left, right);
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;

		if (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if (l1 != null)
			p = l1;
		if (l2 != null)
			p = l2;

		return dummyHead.next;
	}
}
