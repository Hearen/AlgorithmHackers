

class Solution(object):

    def __init__(self):
        self.direction=[]
        self.direction.append([0,1])
        self.direction.append([0,-1])
        self.direction.append([1,0])
        self.direction.append([-1,0])
        self.row = 0
        self.col = 0
    def solve(self, board):

        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        self.row = len(board)
        self.col = len(board[0])
        if self.row == 0 or self.col == 0:
            return
        for i in range(self.row):
            if board[i][0]=='O':
                self.bfs(board,i,0)
            if board[i][self.col-1] =='O':
                self.bfs(board,i,self.col-1)
        for j in range(self.col):
            if board[0][j] == 'O':
                self.bfs(board,0,j)
            if board[self.row-1][j] =='O':
                self.bfs(board,self.row-1,j)
        for i in  range(self.row):
            for j in range(self.col):
              if board[i][j] == 'O':
                  board[i][j] = 'X'
              if board[i][j] =='#':
                  board[i][j] = 'O'
    def bfs(self,board,i,j):
        """
        从board 的i j位置开始广搜，将 O的位置都置为，#
        :param board:
        :param i:
        :param j:
        :return:
        """
        queue = []

        if self.posIsValid(i,j) and board[i][j] == 'O':
            board[i][j] = '#'
            queue.append([i,j])
            while len(queue) > 0:
                i,j = queue.pop(0)
                for k in range(4):
                    newI = i +self.direction[k][0]
                    newJ = j + self.direction[k][1]
                    if self.posIsValid(newI,newJ) and board[newI][newJ]=='O':
                        queue.append([newI,newJ])
                        board[newI][newJ] = '#'
    def posIsValid(self,i,j):
        if i > -1 and i < self.row and j > -1 and j < self.col:
            return True
        return False

if __name__ == '__main__':

    so = Solution()
    board = [list("XXX"),list("XOX"),list("XXX")]
    so.solve(board)
    print(board)
