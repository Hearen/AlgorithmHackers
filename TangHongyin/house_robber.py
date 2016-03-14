class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return 0
        dp = [0] * len(nums)
        if len(nums) == 1:
            return nums[0]
        dp[0], dp[1] = nums[0], nums[1]
        dp[1] = max(dp[0], dp[1])
        for i in range(2, len(nums)):
            if dp[i - 1] > dp[i - 2] + nums[i]:
                dp[i] = dp[i - 1]
            else:
                dp[i] = dp[i - 2] + nums[i]
        return dp[len(nums) - 1]

if __name__ == "__main__":
    solution = Solution()
    print solution.rob([2, 1, 1, 1])