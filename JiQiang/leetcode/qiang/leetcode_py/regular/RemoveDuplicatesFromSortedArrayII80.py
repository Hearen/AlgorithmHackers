class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        res = 1
        l = len(nums)
        if l == 0 or l == 1 or l == 2:
            return  l
        last = nums[0]

        i = 0
        begin = 0
        while i < l:
            while i < l and nums[i] == last:
                i = i+1
            if i - begin > 1:
                nums[res] = last
                res = res+1
            begin = i
            if i == l:
                break
            nums[res] = nums[i]
            last = nums[i]
            res = res+1
            i = i+1
        return res

if __name__ == '__main__':
    nums = [1,1,1,1,2,2,3]
    sol = Solution()
    print(sol.removeDuplicates(nums))
    print(nums)