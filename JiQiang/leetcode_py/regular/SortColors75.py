
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        count = [0,0,0]
        for a in nums:
            count[a]+=1
        k = 0
        for i in range(3):
            for j in range(count[i]):
                nums[k] = i
                k+=1
    def sortColors2(self,nums):

        if not nums or len(nums) <2:
            return
        size = len(nums)
        left = 0
        right = size - 1
        k=0
        while left < right:

            while left < size and nums[left]==0:
                left +=1
            while right > -1 and nums[right]==2:
                right -=1
            if left >= right:
                return
            if k < left:
                k = left
            while k <= right and nums[k]==1:
                k +=1
            if k > right:return
            if nums[k] == 0:
                self.swap(nums,left,k)
                left +=1
            elif nums[k] == 2:
                self.swap(nums,right,k)
                right -= 1

    def swap(self,nums,i,j):
        a = nums[i]
        nums[i] = nums[j]
        nums[j] = a

if __name__ == '__main__':

    so = Solution()
    nums = [0,2,1,0,1]
    so.sortColors2(nums)
    print(nums)


