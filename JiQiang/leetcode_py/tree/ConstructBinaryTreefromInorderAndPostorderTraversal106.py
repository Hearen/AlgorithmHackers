

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from JiQiang.leetcode_py.tree.TreeNode import TreeNode
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder:
            return None
        return  self.buildTreeFromInPost(inorder,0,len(inorder)-1,postorder,0,len(postorder)-1)

    def buildTreeFromInPost(self,inorder,iB,iE,postorder,pB,pE):
        """
        根据中根和后根遍历构建二叉树。后跟遍历的最后一个是根。
        :param inorder: List[int]
        :param iB:int
        :param iE:int
        :param postorder: List[int]
        :param pB: int
        :param pE:int
        :return:TreeNode
        """
        if iB > iE or pB > pE:return  None
        if iB == iE:
            return  TreeNode(inorder[iE])
        root = TreeNode(postorder[pE])
        mid = inorder.index(postorder[pE])
        leftLen = mid - iB
        root.left = self.buildTreeFromInPost(inorder,iB,mid-1,postorder,pB,pB+leftLen-1)
        root.right = self.buildTreeFromInPost(inorder,mid+1,iE,postorder,pB+leftLen,pE-1)
        return root

if __name__ == '__main__':
    so = Solution()

    root = so.buildTree([0,1,2,3,4,5,6,],[0,2,1,4,6,5,3])
    TreeNode.inOrderRec(root)

