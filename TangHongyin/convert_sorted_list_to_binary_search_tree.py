# Definition for singly-linked list.
import math

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if head is None:
            return None
        p,i = head,0
        while p:
            i += 1
            p = p.next
        return self.buildBST(head, i)[0]

    def buildBST(self, head, k):
        if k == 1:
            head_node = TreeNode(head.val)
            return head_node, head.next
        if k == 2:
            head_node = TreeNode(head.val)
            right_node = TreeNode(head.next.val)
            head_node.right = right_node
            return head_node, head.next.next
        left_node, mid = self.buildBST(head, math.floor((k - 1) / 2))
        if mid is not None:
            mid_node = TreeNode(mid.val)
            mid_node.left = left_node
            if mid.next is not None:
                right_node, next = self.buildBST(mid.next, k - 1 - math.floor((k - 1) / 2))
                mid_node.right = right_node
                return mid_node, next
            else:
                return mid_node, None
        else:
            return left_node, None

if __name__ == '__main__':
    solution = Solution()
    array = [ListNode(i) for i in range(1, 5)]
    for i in range(0, len(array) - 1):
        array[i].next = array[i + 1]
    solution.sortedListToBST(array[0])
