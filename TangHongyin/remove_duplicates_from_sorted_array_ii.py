#!/usr/bin/env python
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return len(nums)
        pointer = 0
        count = 1
        for i in range(1, len(nums)):
            if nums[i] == nums[pointer]:
                count += 1
                if count == 2:
                    pointer += 1
                    nums[pointer] = nums[pointer - 1]
            else:
                pointer += 1
                nums[pointer] = nums[i]
                count = 1
        return pointer + 1

if __name__ == '__main__':
    nums = [1, 1, 1, 1, 2, 2, 2, 3, 3, 4]
    solution = Solution()
    print solution.removeDuplicates(nums)
