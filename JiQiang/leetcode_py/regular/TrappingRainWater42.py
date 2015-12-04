
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not height or len(height)<2:
            return  0
        maxValue = max(height)
        if maxValue == 0:
            return  0
        maxIndex = height.index(maxValue)
        left = 0
        # 找到左侧第一个非0
        while left < maxIndex and height[left] ==0:
            left +=1
        right = len(height)-1
        # 找到右侧第一个非0
        while right > maxIndex and height[right] == 0:
            right-=1
        ans = 0
        #计算左侧的水量
        while left < maxIndex:
            i = left+1
            dele = 0
            while i < maxIndex and height[i]<height[left]:
                dele +=height[i]
                i+=1
            ans += (i - left -1)*height[left] - dele
            left = i
        while right > maxIndex:
            j = right-1
            dele = 0
            while  j > maxIndex and height[j]<height[right]:
                dele += height[j]
                j -= 1
            ans += (right - j -1 )*height[right]-dele
            right = j
        return  ans

if __name__ == '__main__':
    so = Solution()
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    print(so.trap(height))