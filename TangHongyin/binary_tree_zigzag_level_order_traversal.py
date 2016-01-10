# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = [[]]
        v_result = [[]]
        flag = True
        layer = 0

        if root is not None:
            result[layer].append(root)
            v_result[layer].append(root.val)
        else:
            return []

        while layer < len(result):
            queue = []
            v_queue = []
            flag = not flag
            # from right to left
            if flag is not True:
                for i in range(len(result[layer]) - 1, -1, -1):
                    if result[layer][i].right is not None:
                        queue.insert(0, result[layer][i].right)
                        v_queue.append(result[layer][i].right.val)
                    if result[layer][i].left is not None:
                        queue.insert(0, result[layer][i].left)
                        v_queue.append(result[layer][i].left.val)
                    # if result[layer][i].left is not None:
                    #     queue.append(result[layer][i].left)
                    # if result[layer][i].right is not None:
                    #     queue.append(result[layer][i].right)
            else:
                for i in range(len(result[layer])):
                    if result[layer][i].left is not None:
                        queue.append(result[layer][i].left)
                        v_queue.append(result[layer][i].left.val)
                    if result[layer][i].right is not None:
                        queue.append(result[layer][i].right)
                        v_queue.append(result[layer][i].right.val)
            if len(queue) > 0:
                result.append(queue)
                v_result.append(v_queue)
            layer += 1
        return v_result
