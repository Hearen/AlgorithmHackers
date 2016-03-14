


from JiQiang.leetcode_py.tree.TreeNode import TreeNode
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        根据先根和中根还原二叉树。
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder:
            return None
        return  self.buildTreeFromPreIn(preorder,0,len(preorder)-1,inorder,0,len(inorder)-1)

    def buildTreeFromPreIn(self,preorder,pB,pE,inorder,iB,iE):
        if pB > pE or iB > iE:
            return None
        if pB == pE:
            return TreeNode(preorder[pE])
        root = TreeNode(preorder[pB])
        mid = 0
        for i in range(iB,iE+1):
            if inorder[i] == preorder[pB]:
                mid = i
                break
        leftSize = mid-iB
        root.left = self.buildTreeFromPreIn(preorder,pB+1,pB+leftSize,inorder,iB,mid-1)
        root.right = self.buildTreeFromPreIn(preorder,pB+leftSize+1,pE,inorder,mid+1,iE)
        return root

if __name__ == '__main__':

    so = Solution()
    TreeNode.inOrderRec(so.buildTree([1,2,4,3],[4,2,1,3]))
