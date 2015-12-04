class Solution(object):

    def binarySearch(self, low, high, a, target):

        while low <= high:
            mid = (low + high) // 2
            midVal = a[mid]

            if midVal < target:
                low = mid + 1
            elif midVal > target:
                high = mid - 1
            else:
               return mid
        return -1

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] > nums[low]:
                if nums[mid] == target:
                    return mid
                elif nums[low] <= target < nums[mid]:
                    return self.binarySearch(low, mid, nums, target)
                elif target > nums[mid] or target <= nums[high]:
                    low = mid + 1
                else:
                    return -1
            elif nums[mid] < nums[low]:
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target <= nums[high]:
                    return self.binarySearch(mid + 1, high, nums, target)
                elif target >= nums[low] or target < nums[mid]:
                    high = mid - 1
                else:
                    return -1
            else:
                if high == low and target == nums[high]:
                    return mid
                else:
                    if nums[low] == target:
                        return low
                    elif nums[high] == target:
                        return high
                    else:
                        return -1
        return -1
if __name__ == '__main__':
    nums = [5, 1, 3]
    solution = Solution()
    print solution.search(nums, 3)
