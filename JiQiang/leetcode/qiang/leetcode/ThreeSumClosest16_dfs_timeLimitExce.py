import sys


class Solution(object):
    def __init__(self):
        self.closetSum = sys.maxsize
        self.minDiff = sys.maxsize

    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) < 4:
            return sum(nums)
        self.dfs(nums, 0, 0, 0, target)
        return self.closetSum

    def dfs(self, nums, curLen, curIndex, curSum, target):

        if curLen == 3:
            diff = abs(curSum - target)
            if diff == 0:
                self.closetSum = target
                self.minDiff = 0
            elif diff < self.minDiff:
                self.minDiff = diff
                self.closetSum = curSum
            return
        if curIndex > len(nums) - 1:
            return
        i = curIndex
        while i < len(nums):
            self.dfs(nums, curLen + 1, i + 1, curSum + nums[i], target)
            i = i + 1
            if self.minDiff == 0:
                return


if __name__ == '__main__':
    nums = [-1, 2, 1, -1]
    so = Solution()
    print(so.threeSumClosest(nums, 0))
    print(so.minDiff)
