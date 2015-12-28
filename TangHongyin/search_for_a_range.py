class Solution(object):

    def binarySearch(self, low, high, a, target, range):

        while low <= high:
            mid = (low + high) // 2
            midVal = a[mid]

            if midVal < target:
                low = mid + 1
            elif midVal > target:
                high = mid - 1
            else:
                if range[0] == range[1] == -1:
                    range[0] = range[1] = mid
                    self.binarySearch(low, mid - 1, a, target, range)
                    self.binarySearch(mid + 1, high, a, target, range)
                    return range
                else:
                    if mid < range[0]:
                        range[0] = mid
                        high = mid - 1
                    if range[1] < mid:
                        range[1] = mid
                        low = mid + 1
        return range

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        range = [-1, -1]
        return self.binarySearch(0, len(nums) - 1, nums, target, range)

if __name__ == '__main__':
    solution = Solution()
    nums = [1]
    target = 0
    print solution.searchRange(nums, target)
