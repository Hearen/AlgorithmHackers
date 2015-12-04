
import  sys
class Solution(object):

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        这里nums中没有重复的元素
        """
        if not nums:
            return -1
        pivo = self.searchPivo(nums)
        le = self.binarySearch(nums,0,pivo-1,target)
        if le != -1:
            return le
        return  self.binarySearch(nums,pivo,len(nums)-1,target)

    def binarySearch(self,nums,left,right,target):

        while left <= right:
            mid = (left + right)//2
            if nums[mid] == target:
                return mid
            if nums[mid]> target:
                right = mid-1
            else:
                left = mid +1
        return -1
    def searchPivo(self,nums):
        l = len(nums)
        left = 0
        right = l-1
        minValue = sys.maxsize
        minIndex =-1
        while left <= right:
            mid = (left + right)//2
            if nums[mid]>= nums[left]:
                if nums[left] < minValue:
                    minValue = nums[left]
                    minIndex = left

                left = mid+1
            else:
                if nums[mid]< minValue:
                    minValue = nums[mid]
                    minIndex = mid
                right = mid-1
        return minIndex

if __name__ == '__main__':
    sol = Solution()
    nums = [3,4,0]
    print(sol.search(nums,0))