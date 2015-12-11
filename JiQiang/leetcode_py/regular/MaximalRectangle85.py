

class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int

        """
        if not matrix or len(matrix) == 0:
            return 0
        row = len(matrix)
        col = len(matrix[0])

        histogram = [ [0 for j in range(col)] for i in range(row)]

        for i in range(col):
            j = row -2
            if  matrix[row-1][i] == '1':
                histogram[row-1][i] =1
            while j > -1:
                if matrix[j+1][i] == '1':
                    if matrix[j][i] == '1':
                        histogram[j][i] = histogram[j+1][i]+1
                else:
                    if matrix[j][i] == '1':
                        histogram[j][i] =1
                j -=1
        ans = -1
        print(histogram)
        for oneRow in histogram:
            a = self.largestRectangleArea(oneRow)
            if a > ans:
                ans = a
        return  ans

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

if __name__ == '__main__':
    m = ["10100","10111","11111","10010"]
    matrix = []
    for r in m:
        matrix.append(list(r))
    so = Solution()
    print(so.maximalRectangle(matrix))
