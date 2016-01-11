


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
            nextLineRoot = tempRoot
            while tempRoot:
                if tempRoot.left and tempRoot.right: # 当左右都不为空的时候
                    tempRoot.left.next =  tempRoot.right
                    if tempRoot.next:
                        tempRoot.right.next = tempRoot.next.left
                        tempRoot = tempRoot.next
                    else:break
                else:break
            tempRoot = nextLineRoot.left











