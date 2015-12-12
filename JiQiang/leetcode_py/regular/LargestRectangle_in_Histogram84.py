

class Solution(object):
    def largestRectangleArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not  height or len(height) == 0:
            return 0
        if len(height) ==1:
            return  height[0]
        i = 0
        size = len(height)
        stack = []
        maxArea = 0
        while i < size:
            if len(stack) == 0 or stack[len(stack)-1] < height[i]:
                stack.append(height[i])
            else:
                j = 1
                while len(stack) != 0 and stack[len(stack)-1] > height[i]:
                    top = stack.pop()
                    area= top*j
                    if area > maxArea:
                        maxArea = area
                    j +=1
                for k in range(j):
                    stack.append(height[i])
            i +=1
        j = 1
        while len(stack) != 0:
            maxArea = max(maxArea,j*stack.pop())
            j+=1
        return  maxArea

    def largestRectangleArea2(self, height):
        """
        :type height: List[int]
        :rtype: int
        上面的函数在栈中存放的是高度，这里存放的是索引，这样就可以较快的通过索引差计算面积

        """
        if not  height or len(height) == 0:
            return 0
        if len(height) ==1:
            return  height[0]
        i = 0
        height.append(0)
        size = len(height)
        stack = []
        maxArea = 0
        while i < size:
            if len(stack) == 0 or height[stack[len(stack)-1]] < height[i]:
                stack.append(i)
            else:
                while len(stack) != 0 and height[stack[len(stack)-1]] > height[i]:
                    top = stack.pop()
                    leftA = 0
                    if len(stack) == 0:
                        leftA = (top+1)*height[top]
                    else:
                        leftA = (top-stack[len(stack)-1])*height[top]
                    rightA = (i - top-1)*height[top]


                    if (rightA+leftA) > maxArea:
                        maxArea = rightA+leftA
                stack.append(i)
            i +=1
        return  maxArea
if __name__ == '__main__':
    so = Solution()
    height = [2,1,5,6,7,5,5,3,2,1]
    print(so.largestRectangleArea(height))
    print(so.largestRectangleArea2(height))