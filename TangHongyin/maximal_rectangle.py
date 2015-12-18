class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) == 0: return 0
        for i in xrange(len(matrix)):
            for j in xrange(len(matrix[i])):
                if i == 0:
                    matrix[i][j] = int(matrix[i][j])
                    continue
                if matrix[i][j] == '1':
                    matrix[i][j] = matrix[i-1][j] + int(matrix[i][j])
                else:
                    matrix[i][j] = 0
        return max([self.maxRectangle(row) for row in matrix])

    # calc the area of the histogram
    def maxRectangle(self, hist):
        stk = []
        maxx = 0
        # append 0 to calc the area including the last hist
        hist.append(0)
        for i in xrange(len(hist)):
            while len(stk) > 0 and hist[i] < hist[stk[-1]]:
                s = stk.pop()
                if len(stk) == 0:
                    maxx = max(maxx, i*hist[s])
                else:
                    maxx = max(maxx, (i - stk[-1] - 1)*hist[s])
            stk.append(i)
        return maxx

if __name__ == '__main__':
    nums = [['0','0','1','0','0'],['0','1','1','1','0'],['1','1','1','1','1']]
    solution = Solution()
    print solution.maximalRectangle(nums)