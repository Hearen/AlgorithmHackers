

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        我们用 a[i][j] 表示以 i,j 为右下角的正方形的边长，那么a[i][j] = min{ a[i][j-1],a[i-1][j],a[i-1][j-1]} +1
        """
        if not matrix or len(matrix)==0 or len(matrix[0]) ==0:
            return 0
        ans = 0
        row = len(matrix)
        col = len(matrix[0])
        board  = [[0 for j in range(col)]for i in range(row)]

        for i in range(col):
            if matrix[0][i] == '1':
                board[0][i] = 1
                ans = 1
        for j in range(row):
            if matrix[j][0] == '1':
                board[j][0] = 1
                ans = 1

        for i in range(1,row):
            for j in range(1,col):
                if matrix[i][j] == '0':
                    board[i][j] = 0
                else:
                    board[i][j] = min(board[i-1][j],board[i][j-1],board[i-1][j-1])+1
                    if board[i][j] > ans:
                        ans = board[i][j]
        return  ans*ans

if __name__ == '__main__':

    so = Solution()
    matrix = [['1','1'],['1','1']]
    print(so.maximalSquare(matrix))