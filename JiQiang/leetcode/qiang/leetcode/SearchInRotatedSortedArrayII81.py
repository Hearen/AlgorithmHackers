
import  sys
class Solution(object):

    def __init__(self):
        self.minValue = sys.maxsize
        self.minIndex = -1

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        这里nums中没有重复的元素
        """
        if not nums:
            return -1
        self.searchPivo(nums,0,len(nums)-1)
        pivo = self.minIndex
        print( pivo)
        le = self.binarySearch(nums,0,pivo-1,target)
        if le != -1:
            return True
        if self.binarySearch(nums,pivo,len(nums)-1,target) > -1:
            return True
        return False

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
    def searchPivo(self,nums,left,right):

        if left > right:
            return
        if left < 0 or right < 0 or left > len(nums)-1 or right > len(nums)-1 :
            return
        mid = (left + right)//2
        if nums[mid] > nums[left]:
            if nums[left] < self.minValue or (nums[left] == self.minValue and left != 0 and nums[left-1] > self.minValue):
                self.minValue = nums[left]
                self.minIndex = left
            self.searchPivo(nums,mid+1,right)
        elif nums[mid]< nums[left]:
            if nums[mid] < self.minValue or (nums[mid] == self.minValue and mid != 0 and nums[mid-1] > self.minValue):
                self.minValue = nums[mid]
                self.minIndex = mid
            self.searchPivo(nums,left,mid-1)
        elif nums[mid] < nums[right]:
            if nums[mid] < self.minValue or (nums[mid] == self.minValue and mid != 0 and nums[mid-1] > self.minValue):
                self.minValue = nums[mid]
                self.minIndex = mid
            self.searchPivo(nums,left,mid-1)
        elif nums[mid] > nums[right]:
            if nums[left] < self.minValue or(nums[left] == self.minValue and left != 0 and nums[left-1] > self.minValue):
                self.minValue = nums[left]
                self.minIndex = left
            self.searchPivo(nums,mid+1,right)
        else:
            if nums[mid] < self.minValue or (nums[mid] == self.minValue and mid != 0 and nums[mid-1] > self.minValue):
                self.minValue = nums[mid]
                self.minIndex = mid
            self.searchPivo(nums,left,mid-1)
            self.searchPivo(nums,mid+1,right)
if __name__ == '__main__':
    sol = Solution()
    nums = [3,1]
    print(sol.search(nums,2))