# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):

    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return None
        p,i = head,0
        while p:
            i += 1
            p = p.next
        return self.mergeSort(head, i)[0]

    def mergeSort(self, head, k):
        if k == 1:
            next = head.next
            head.next = None
            return head, next
        left_head, next = self.mergeSort(head, k/2)
        right_head, next = self.mergeSort(next, k-(k/2))
        return self.merge(left_head,right_head), next

    def merge(self, h1, h2):
        dummy = ListNode(0)
        p = dummy
        while h1 and h2:
            if h1.val <= h2.val:
                p.next = h1
                p = p.next
                h1 = h1.next
            else:
                p.next = h2
                p = p.next
                h2 = h2.next
        if h1 is None and h2 is not None:
            p.next = h2
        elif h2 is None and h1 is not None:
            p.next = h1
        return dummy.next