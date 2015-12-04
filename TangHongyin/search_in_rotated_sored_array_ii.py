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
               return True
        return False

    def subSearch(self, low, high, nums, target):
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] > nums[low]:
                if nums[mid] == target:
                    return True
                elif nums[low] <= target < nums[mid]:
                    return self.binarySearch(low, mid, nums, target)
                elif target > nums[mid] or target <= nums[high]:
                    low = mid + 1
                else:
                    return False
            elif nums[mid] < nums[low]:
                if nums[mid] == target:
                    return True
                elif nums[mid] < target <= nums[high]:
                    return self.binarySearch(mid + 1, high, nums, target)
                elif target >= nums[low] or target < nums[mid]:
                    high = mid - 1
                else:
                    return False
            # nums[mid] == nums[low]
            else:
                if nums[mid] == target:
                    return True
                # high == mid or high == mid - 1
                if mid == low:
                    if nums[high] == target:
                        return True
                    else:
                        return False
                # nums[low] === nums[high] === nums[mid]
                if nums[high] == nums[mid]:
                    if self.subSearch(low, mid - 1, nums, target):
                        return True
                    else:
                        return self.subSearch(mid + 1, high, nums, target)
                elif nums[high] < nums[mid]:
                        low = mid + 1
                else:
                    return self.binarySearch(mid + 1, high, nums, target)
        return False

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        return self.subSearch(low, high, nums, target)

if __name__ == '__main__':
    nums = [1,1,2]
    solution = Solution()
    print solution.search(nums, 2)
