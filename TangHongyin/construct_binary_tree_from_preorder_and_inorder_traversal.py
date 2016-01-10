# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    def traverse(self, preorder, inorder, pre_start, pre_end, in_start, in_end):
        root_value = preorder[pre_start]
        root = TreeNode(root_value)
        # the last position of the left tree in inorder array + 1
        inorder_left_end = inorder.index(root_value, in_start, in_end)
        # the last position of the left tree in preorder
        preorder_left_end = inorder_left_end - in_start + pre_start + 1
        # if left child exists
        if root_value != inorder[in_start]:
            root.left = self.traverse(preorder, inorder, pre_start + 1, preorder_left_end, in_start, inorder_left_end)
        inorder_right_start = inorder_left_end + 1
        preorder_right_start = preorder_left_end
        # if right child exists
        if root_value != inorder[in_end - 1]:
            root.right = self.traverse(preorder, inorder, preorder_right_start, pre_end, inorder_right_start, in_end)
        return root

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if preorder is None or len(preorder) == 0:
            return None
        return self.traverse(preorder, inorder, 0, len(preorder), 0, len(inorder))

if __name__ == "__main__":
    solution = Solution()
    solution.buildTree([1,2,4,8,5,3,6,9,7,10],[8,4,2,5,1,9,6,3,7,10])