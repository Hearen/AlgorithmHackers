class Solution(object):

    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        diff = 0xffffffff
        nums = sorted(nums)
        for i in range(len(nums)):
            low = i + 1
            high = len(nums) - 1
            while low < high:
                sum = nums[low] + nums[high] + nums[i]
                temp = sum - target
                if abs(temp) < abs(diff):
                    diff = temp
                if temp == 0:
                    return sum
                if temp < 0:
                    low += 1
                if temp > 0:
                    high -= 1
        return target + diff

if __name__ == '__main__':
    nums = [0,2,1,-3]
    solution = Solution()
    print solution.threeSumClosest(nums, 1)
