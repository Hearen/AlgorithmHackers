class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self.nums = nums
        self.len = len(nums)
        if self.len >0:
            self.partsum =[nums[0]]

        for i in range(1,self.len):
            self.partsum.append(self.partsum[i-1]+nums[i])



    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        if self.len== 0:
            return 0
        if i > j :
            return 0
        if i == j and  i > -1 and i < self.len:
            return self.nums[i]
        newI = i
        if i >= self.len:
            return 0
        if i < 0:
            newI = 0
        newJ = j
        if j > self.len-1:
            newJ = self.len-1
        if newI == 0:
            return  self.partsum[newJ]
        return self.partsum[newJ] - self.partsum[newI-1]


# Your NumArray object will be instantiated and called as such:
# numArray = NumArray(nums)
# numArray.sumRange(0, 1)
# numArray.sumRange(1, 2)
if __name__ == '__main__':

    so = NumArray([1,2,3,4,5,6,7])
    print(so.sumRange(1,-21))