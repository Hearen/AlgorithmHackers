

from JiQiang.leetcode_py.list.ListNode import ListNode
from JiQiang.leetcode_py.tree.TreeNode import TreeNode
class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if not head :
            return  None
        self.node = head
        tempH = head
        size = 0
        while tempH:
            size +=1
            tempH = tempH.next
        return self.buildBST(0,size-1)


    def buildBST(self,begin,end):
        """
        按照中根遍历的顺序构建BST
        :param head: ListNode
        :param begin: int
        :param end: int
        :return: TreeNode
        """
        if begin > end:
            return  None
        mid = (begin+end)//2
        leftTree = self.buildBST(self.node,begin,mid-1)
        root = TreeNode(self.node.val)
        root.left = leftTree
        self.node = self.node.next
        root.right = self.buildBST(self.node,mid+1,end)
        return  root

if __name__ == '__main__':

    so = Solution()
    root = TreeNode.buildBinaryTreeFromSer([1,2,3])







