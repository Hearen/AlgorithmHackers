# ************************************
# ***************TLE******************
# ************************************

class Solution(object):

    pointer = [0, 0, 0]
    diff = 0xffffffff
    result = 0

    def traverse(self, depth, index, m_sum, nums, target):
        if depth == 3:
            if abs(m_sum - target) < self.diff:
                self.result = m_sum
                self.diff = abs(m_sum - target)
        else:
            for i in range(index + 1, len(nums)):
                # if is the last num to get
                if i + 2 - depth > len(nums):
                    break
                self.pointer[depth] = i
                m_sum += nums[i]
                self.traverse(depth + 1, i, m_sum, nums, target)
                m_sum -= nums[i]

    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        m_sum = 0
        self.traverse(0, -1, m_sum, nums, target)
        return self.result

if __name__ == '__main__':
    nums = [-3,-2,-5,3,-4]
    solution = Solution()
    print solution.threeSumClosest(nums, -1)
