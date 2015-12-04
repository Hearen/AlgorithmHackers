
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if not board or len(board[0])==0 or not word or len(word)==0:
            return False
        row = len(board)
        col = len(board[0])
        flag = [[False for i in range(col)] for j in range(row)]
        for  i,rowStr in enumerate(board):
            g = (k for k,m in enumerate(rowStr) if m == word[0])
            for j in g:
                re = self.dfs(board,flag,row,col,i,j,0,word)
                if re:
                    return True
        return  False
    def dfs(self,board,flag,row,col,i,j,curIndex,word):
        s = len(word)
        if curIndex == s:
            return True
        if i < 0 or j < 0 or i > row -1 or j > col -1:
            return False

        if flag[i][j]:
            return False
        if board[i][j] != word[curIndex]:
            return False
        flag[i][j] = True
        if self.dfs(board,flag,row,col,i+1,j,curIndex+1,word):
            return True
        if self.dfs(board,flag,row,col,i-1,j,curIndex+1,word):
            return True
        if self.dfs(board,flag,row,col,i,j+1,curIndex+1,word):
            return True
        if self.dfs(board,flag,row,col,i,j-1,curIndex+1,word):
            return True
        flag[i][j] = False
        return False

if __name__ == '__main__':
    so = Solution()
    board = [['A','B','C','E'],
             ['S','F','C','S'],
             ['A','D','E','E']
            ]
    word = 'ABCB'
    print(so.exist(board,word))