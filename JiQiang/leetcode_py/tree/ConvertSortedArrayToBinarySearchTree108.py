

from JiQiang.leetcode_py.tree.TreeNode import TreeNode

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if not nums:
            return  None
        return self.buildBST(nums,0,len(nums)-1)

    def buildBST(self,nums,i,j):

        if i> j :
            return None
        if i == j:
            no = TreeNode(nums[i])
            return no
        mid = (i+j)//2
        root = TreeNode(nums[mid])
        left = self.buildBST(nums,i,mid-1)
        right = self.buildBST(nums,mid+1,j)
        root.left = left
        root.right = right
        return  root

if __name__ == '__main__':

    so = Solution()

    root = so.sortedArrayToBST([1,2,3,4,5,6,7])
    TreeNode.inOrderRec(root)
    print()
    TreeNode.preOrder(root)