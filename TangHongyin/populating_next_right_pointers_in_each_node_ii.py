# Definition for binary tree with next pointer.

class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None

class Solution(object):

    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if root is None:
            return None
        node_queue = [root]
        start = 0
        end = 1
        while start < len(node_queue):
            while start < end:
                father = node_queue[start]

                if start < end - 1:
                    father.next = node_queue[start + 1]

                if father.left is not None:
                    node_queue.append(father.left)

                if father.right is not None:
                    node_queue.append(father.right)

                start += 1
            end = len(node_queue)

if __name__ == '__main__':
    a = TreeLinkNode(0)
    solution = Solution()
    solution.connect(a)
