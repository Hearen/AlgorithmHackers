class Solution(object):

    def dfs(self, blanks, index, board, rows, columns, group):
        if index == len(blanks):
            return True
        (x, y) = blanks[index]
        for v in range(1, 10):
            # this value is valid
            if not (rows[x][v] or columns[y][v] or group[x//3][y//3][v]):
                board[x][y] = str(v)
                rows[x][v] = True
                columns[y][v] = True
                group[x//3][y//3][v] = True
                if not self.dfs(blanks, index + 1, board, rows, columns, group):
                    board[x][y] = '.'
                    rows[x][v] = False
                    columns[y][v] = False
                    group[x//3][y//3][v] = False
                else:
                    return True
        return False

    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        rows = [[False for j in range(10)] for i in range(9)]
        columns = [[False for j in range(10)] for i in range(9)]
        group = [[[False for j in range(10)] for i in range(3)] for k in range(3)]
        blanks = []
        new_board = [[board[i][j] for j in range(len(board[i]))] for i in range(len(board))]
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] != '.':
                    rows[i][int(board[i][j])] = True
                    columns[j][int(board[i][j])] = True
                    group[i//3][j//3][int(board[i][j])] = True
                else:
                    blanks.append((i,j))
        self.dfs(blanks, 0, new_board, rows, columns, group)

        for i in range(len(board)):
            board[i] = ""
            board[i] = board[i].join(new_board[i])

if __name__ == '__main__':
    board = ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
    solution = Solution()
    solution.solveSudoku(board)
