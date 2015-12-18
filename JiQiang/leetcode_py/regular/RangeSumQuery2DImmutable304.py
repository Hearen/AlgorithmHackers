

class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if not matrix and not matrix[0]:
            self.row = len(matrix)
            self.col = len(matrix[0])
        else:
            self.row = 0
            self.col = 0
        #self.matrix = matrix
        self.partsum=[[ 0 for i in range(self.col)] for j in range(self.row)]
        self.partsum[0][0] = matrix[0][0]
        for i in range(1,self.row):
            self.partsum[0][i] = self.partsum[0][i-1] + matrix[0][i]
        for j in range(1,self.col):
            self.partsum[j][0] =   self.partsum[j-1][0] + matrix[j][0]

        for i in range(1,self.row):
            for j in range(1,self.col):
                self.partsum[i][j] = self.partsum[i][j-1]+ self.partsum[i-1][j]-self.partsum[i-1][j-1]+matrix[i][j]


    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        


# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.sumRegion(1, 2, 3, 4)