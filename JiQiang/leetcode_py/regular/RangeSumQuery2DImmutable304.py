

class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if  matrix and len( matrix[0])!= 0:
            self.row = len(matrix)
            self.col = len(matrix[0])
        else:
            self.row=0
            return
        #self.matrix = matrix

        self.partsum=[[ 0 for i in range(self.col)] for j in range(self.row)]
        self.partsum[0][0] = matrix[0][0]
        for i in range(1,self.col):
            self.partsum[0][i] = self.partsum[0][i-1] + matrix[0][i]
        for j in range(1,self.row):
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
        if self.row == 0:
            return  0
        if not self.isPosValid(row1,col1) or not  self.isPosValid(row2,col2):
            return 0
        if row1 == 0 and col1 == 0:
            return self.partsum[row2][col2]
        top =0
        left = 0
        topLeft = 0
        if row1 == 0:
            left = self.partsum[row2][col1-1]

        if col1 ==0:
            top = self.partsum[row1-1][col2]
        if row1 != 0 and col1 != 0:
             left = self.partsum[row2][col1-1]
             top = self.partsum[row1-1][col2]
             topLeft =  self.partsum[row1-1][col1-1]
        return self.partsum[row2][col2] + topLeft -left-top

    def isPosValid(self,i,j):
        if i < 0 or j < 0 or i > self.row-1 or j > self.col-1:
            return  False
        return  True

# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.sumRegion(1, 2, 3, 4)
if __name__ == '__main__':
    matrix =[
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
    nu = NumMatrix(matrix)
    print(nu.sumRegion(2, 1, 4, 3))
    print(nu.sumRegion(1, 1, 2, 2))
    print(nu.sumRegion(1, 2, 2, 4))
