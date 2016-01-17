# 83. Remove Duplicates from Sorted List

## Problem

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

tag:
- linked list

## Solution

**java**

```java
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
```
