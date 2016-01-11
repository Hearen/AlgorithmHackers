

from JiQiang.leetcode_py.tree.TreeNode import TreeNode
class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        if n ==0:
            return []
        return self.dfs(1,n)

    def dfs(self,begin,end):
        """
        从begin到end，生成BST
        :param begin:int
        :param end: int
        :return: List[TreeNode]
        """
        ans = []
        if begin > end:
            ans.append(None)
            return  ans
        if begin == end:
            t = TreeNode(begin)
            ans.append(t)
            return ans
        if begin +1 == end:
            t1 = TreeNode(begin)
            t1.right = TreeNode(end)
            ans.append(t1)
            t2 = TreeNode(end)
            t2.left = TreeNode(begin)
            ans.append(t2)
            return  ans
        for i in range(begin,end+1):
            leftTreeSet = self.dfs(begin,i-1)
            rightTreeSet = self.dfs(i+1,end)
            for nodeL in leftTreeSet:
                for nodeR in rightTreeSet:
                    ro = TreeNode(i)
                    ro.left = nodeL
                    ro.right = nodeR
                    ans.append(ro)
        return ans


if __name__ == '__main__':

    so = Solution()
    ans =  so.generateTrees(2)
    for n in ans:
        TreeNode.preOrder(n)
        print()


