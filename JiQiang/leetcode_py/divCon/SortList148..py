
from JiQiang.leetcode_py.util.ListNode import ListNode
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return  head
        if head.next == None:
            return  head

        listLen = 0
        tempHead = head
        while tempHead != None:
            tempHead = tempHead.next
            listLen+=1
        i = 1
        ans = ListNode(-1)
        ans.next = head
        while i < listLen:
            tempHead = ans
            fastNode = tempHead.next
            slowNode = tempHead.next
            while fastNode != None or slowNode != None:
                fv = 0
                sv = 0
                # 较快的指针先走i个节点
                while fv < i and fastNode != None:
                    fastNode = fastNode.next
                    fv +=1
                fv  = 0
                # 和并慢的指针和快的指针
                while fv < i and sv < i and fastNode != None and slowNode != None:
                    if fastNode.val < slowNode.val:
                        fv +=1
                        tempHead.next = fastNode
                        fastNode = fastNode.next
                    else:
                        sv +=1
                        tempHead.next = slowNode
                        slowNode = slowNode.next
                    tempHead = tempHead.next

                while fv < i and fastNode != None:
                    tempHead.next = fastNode
                    tempHead = tempHead.next
                    fv +=1
                    fastNode = fastNode.next
                while sv < i and slowNode != None:
                    tempHead.next = slowNode
                    sv +=1
                    slowNode = slowNode.next
                    tempHead = tempHead.next

                # 这一句必须有，因为最后的时候给链表结尾用
                tempHead.next = fastNode
                slowNode = fastNode

            i*=2
        return  ans.next

if __name__ == '__main__':

    head = ListNode(-1)
    so = Solution()

    head.printOneList(so.sortList(head.getOneListNode([8,5,3,2,1])))