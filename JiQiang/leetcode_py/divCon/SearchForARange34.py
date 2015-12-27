
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        ans=[-1,-1]
        if not nums or len(nums) ==0:
            return  ans
        ans[0] = self.leftSide(nums,target)
        ans[1] = self.rightSide(nums,target)
        return  ans
    def leftSide(self,nums,target):

        left =0
        right = len(nums)-1
        while left <= right:
            mid = (left+right)//2
            if nums[mid] == target:
                if mid >0 :
                    if nums[mid-1] != target:
                        return mid
                    else:
                        right = mid-1
                else:
                    return  mid
            elif nums[mid] > target:
                right = mid-1
            else:
                left = mid+1
        return  -1
    def rightSide(self,nums,target):
        left =0
        right = len(nums)-1
        while left <= right:
            mid = (left+right)//2
            if nums[mid] == target:
                if mid < len(nums)-1 :
                    if nums[mid+1] != target:
                        return mid
                    else:
                        left = mid+1
                else:
                    return  mid
            elif nums[mid] > target:
                right = mid-1
            else:
                left = mid+1
        return  -1

if __name__ == '__main__':

    so = Solution()
    print(so.searchRange([5, 7, 7, 8, 8, 10],18))