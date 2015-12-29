
from JiQiang.leetcode_py.util.ListNode import  ListNode
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        return  self.mergeK(lists,0,len(lists)-1)

    def mergeK(self,lists,i,j):
        diff = j - i
        if diff <0:
            return
        if diff == 0:
            return  lists[i]
        if diff==1:
            return self.mergeTowList(lists[i],lists[j])
        first = self.mergeK(lists,i,i+diff//2)
        second = self.mergeK(lists,i+diff//2+1,j)
        return  self.mergeTowList(first,second)



    def mergeTowList(self,first,second):
        if not first :
            return  second
        if not second:
            return  first
        head = curNode = ListNode(-1)
        while first != None and second != None:
            if first.val < second.val:
                curNode.next = first
                first = first.next
            else:
                curNode.next = second
                second = second.next
            curNode = curNode.next
        if first != None:
            curNode.next = first
        if second != None:
            curNode.next = second
        return  head.next

if __name__ == '__main__':
    node = ListNode(-1)
    so = Solution()
    first= node.getOneListNode([1,3,5,7,9,10,11])
    second = node.getOneListNode([2,4,6,8,1111])
    third = node.getOneListNode([10,11,12])
    lists = [first,second,third]
    node.printOneList(so.mergeKLists(lists))