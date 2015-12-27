

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    '''
        传入一个数组，返回一个listNode链表
    '''
    def getOneListNode(self,nums):
        head = ListNode(-1)
        if not nums or len(nums)==0:
            return head

        nextNode = head
        for i in nums:
            cur = ListNode(i)
            nextNode.next = cur
            nextNode = cur
        return  head.next
    def printOneList(self,head):
        while head != None:
            print( str(head.val) +",")
            head = head.next
if __name__ == '__main__':

    node = ListNode(0)
    node.next = ListNode(-1)
    print(node.val)