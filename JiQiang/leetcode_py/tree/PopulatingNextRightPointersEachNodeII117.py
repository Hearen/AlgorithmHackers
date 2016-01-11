


from JiQiang.leetcode_py.tree.TreeNode import TreeNode
class Solution(object):
    def connect(self, root):
        """
        这里给的图确定是一个完全二叉树，但是不是满二叉树。
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if not root :
            return
        tempRoot = root
        nextLineRoot = tempRoot
        while tempRoot:
            nextLineRoot = None
            nextLineRootFound = False
            guard = TreeNode(-1)
            # 找到当前行的第一个儿子节点 nextLineRoot
            while tempRoot:
                if tempRoot.left:
                    if not nextLineRootFound:
                        nextLineRoot = tempRoot.left
                        nextLineRootFound = True
                    guard.next = tempRoot.left
                    guard = guard.next
                if tempRoot.right:
                    if not nextLineRootFound:
                        nextLineRoot = tempRoot.right
                        nextLineRootFound = True
                    guard.next = tempRoot.right
                    guard = guard.next
                tempRoot = tempRoot.next
            if not nextLineRoot:return
            tempRoot = nextLineRoot

















