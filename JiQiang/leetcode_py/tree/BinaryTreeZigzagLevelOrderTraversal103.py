

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from JiQiang.leetcode_py.tree.TreeNode import TreeNode
class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        queue = []
        queue.append((root,1))
        ans = []
        curLevel = 1
        curLevelList=[]
        level =1
        while queue:
            top,level = queue.pop(0)
            if level == curLevel:
                curLevelList.append(top.val)
            else:
                if curLevel % 2==0:
                    curLevelList.reverse()
                ans.append(curLevelList)
                curLevelList = []
                curLevelList.append(top.val)
                curLevel = level
            if top.left:
                queue.append((top.left,level+1))
            if top.right:
                queue.append((top.right,level+1))
        # 处理之后一层。
        if level %2 ==0:
            curLevelList.reverse()
        ans.append(curLevelList)
        return ans

    def zigzagLevelOrder2stack(self, root):

        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        stack1 = []
        stack2 = []
        ans = []
        stack1.append(root)
        while stack1:

            tempList =[]
            while stack1:
                top = stack1.pop()
                tempList.append(top.val)
                if top.left:
                    stack2.append(top.left)
                if top.right:
                    stack2.append(top.right)
            ans.append(tempList)
            tempList =[]
            while stack2:
                top = stack2.pop()
                tempList.append(top.val)
                if top.right:
                    stack1.append(top.right)
                if top.left:
                    stack1.append(top.left)
            if tempList:
                ans.append(tempList)
        return  ans


if __name__ == '__main__':

    so = Solution()
    root = TreeNode.buildBinaryTreeFromSer([1,2,3,4,5,6])
    print(so.zigzagLevelOrder2stack(root))


