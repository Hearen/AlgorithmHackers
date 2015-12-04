class Solution(object):

    direction_list = [(1, 0), (0, 1), (-1, 0), (0, -1)]

    def dfs(self, matrix, board, target, word, x, y):
        """
        :type board: List[List[str]]
        """
        if word == target:
            return True
        elif len(word) > len(target) or target[0:len(word)] != word:
            return False

        for i in range(len(self.direction_list)):
            if 0 <= x + self.direction_list[i][0] < len(board[0]) \
                    and 0 <= y + self.direction_list[i][1] < len(board):
                x += self.direction_list[i][0]
                y += self.direction_list[i][1]
                if not matrix[y][x]:
                    matrix[y][x] = True
                    word = word + board[y][x]

                    if self.dfs(matrix, board, target, word, x, y):
                        return True
                    else:
                        word = word[0:-1]
                        matrix[y][x] = False
                x -= self.direction_list[i][0]
                y -= self.direction_list[i][1]
        return False

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        matrix =[[0 for i in range(len(board[0]))] for i in range(len(board))]
        for i in range(len(board)):
            for j in range(len(board[0])):
                matrix[i][j] = True
                if self.dfs(matrix, board, word, board[i][j], j, i):
                    return True
                matrix[i][j] = False
        return False

if __name__ == '__main__':
    solution = Solution()
    board = ["ABCE","SFCS","ADEE"]
    word = "SEE"
    print solution.exist(board, word)