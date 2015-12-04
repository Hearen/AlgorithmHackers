import sys
class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) < 4:
            return sum(nums)
        minDiff =  sys.maxsize
        closestSum = sys.maxsize
        i =0
        size = len(nums)
        # 首先要排序
        newNums = sorted(nums)
        print(newNums)
        while i < size:
            j = i +1
            k = size-1
            # 如果当前的数已经处理过了，那么就可以跳过
            if i > 0 and newNums[i] == newNums[i-1] :
                i +=1
                continue
            while j < k:
                if j > i+1 and newNums[j] == newNums[j-1]:
                    j +=1
                    continue
                if k < size-1 and newNums[k] == newNums[k+1]:
                    k -=1
                    continue
                tempS = newNums[i] + newNums[j] + newNums[k]
                diff = (tempS - target)
                if diff == 0:
                    return target
                if diff > 0:
                    k -=1
                else:
                    j +=1
                if abs(diff) < minDiff:
                    minDiff = abs(diff)
                    closestSum = tempS
            i +=1
        return closestSum

if __name__ == '__main__':
    nums = [1,1,1,0]
    so = Solution()
    print(so.threeSumClosest(nums, 100))

