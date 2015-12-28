# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):

    def MinHeapFixdown(self, heap, i, end):
        son = i * 2 + 1
        while son < end:
            if son + 1 < end and heap[son].val > heap[son + 1].val:
                son += 1
            if heap[i].val < heap[son].val:
                return
            else:
                heap[i], heap[son] = heap[son], heap[i]
                i = son
                son = i * 2 + 1

    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        priority_queue = []
        head = None
        pointer = None

        length = 0
        for i in range(len(lists)):
            if lists[i] is not None:
                length += 1

        for i in range(len(lists)):
            if lists[i] is not None:
                priority_queue.append(lists[i])

        for i in range(length/2 - 1, -1, -1):
            self.MinHeapFixdown(priority_queue, i, length)
        while length > 0:
            if head is None:
                head = priority_queue[0]
                pointer = head
            else:
                pointer.next = priority_queue[0]
                pointer = priority_queue[0]
            # if not the last of the list
            if pointer.next is not None:
                priority_queue[0] = priority_queue[0].next
            # the last of the list
            else:
                # pick the last one to the first
                priority_queue[0] = priority_queue[length - 1]
                length -= 1
            self.MinHeapFixdown(priority_queue, 0, length)
        return head
if __name__ == '__main__':
    solution = Solution()
    input = [[-8,-7,-6,-3,-2,-2,0,3],[-10,-6,-4,-4,-4,-2,-1,4],[-10,-9,-8,-8,-6],[-10,0,4]]
    node_list = []
    for i in range(len(input)):
        pointer = None
        for j in range(len(input[i])):
            node = ListNode(input[i][j])
            if len(node_list) - 1 < i:
                node_list.append(node)
                pointer = node
            else:
                pointer.next = node
                pointer = node
    solution.mergeKLists(node_list)
