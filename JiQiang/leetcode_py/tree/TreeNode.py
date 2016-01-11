

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    @staticmethod
    def inOrderRec(root):
        """
        递归中根遍历
        :param root: TreeNode
        :return:
        """
        if not root:
            return
        TreeNode.inOrderRec(root.left)
        print(str(root.val)+",",end="")
        TreeNode.inOrderRec(root.right)

    @staticmethod
    def preOrder(root):
        """
        传入一棵二叉树，对其先根遍历
        :param root: TreeNode
        :return:
        """
        if not root:
            return
        print(str(root.val),end=",")
        TreeNode.preOrder(root.left)
        TreeNode.preOrder(root.right)



    @staticmethod
    def buildBinaryTreeFromSer(nums):
        """
        给定数组{3,9,20,#,#,15,7}，返回相应的二叉树
        :param nums: List[]
        :return: TreeNode
        """
        if not nums:
            return  None

        queue = []
        root = TreeNode(nums[0])
        queue.append(root)
        i =1
        size = len(nums)
        while queue:
            top = queue.pop(0)

            if i < size:
                if nums[i]!='#':
                    top.left = TreeNode(nums[i])
                    queue.append(top.left)
                i+=1
            if i < size:
                if nums[i] != '#':
                    top.right = TreeNode(nums[i])
                    queue.append(top.right)
                i+=1
        return  root


    @staticmethod
    def levelOrder(root):
        """
        层次遍历
        :param root: TreeNode
        :return:
        """
        if not root:return
        queue = []
        queue.append(root)
        while queue:
            top = queue.pop(0)
            print(top.val,end=",")
            if top.left:
                queue.append(top.left)
            if top.right:
                queue.append(top.right)

if __name__ == '__main__':

    root = TreeNode.buildBinaryTreeFromSer([1,2,3])
    TreeNode.inOrderRec(root)
    TreeNode.preOrder(root)
    TreeNode.levelOrder(root)
