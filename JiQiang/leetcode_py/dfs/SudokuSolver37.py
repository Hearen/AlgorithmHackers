
class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        使用回溯法
        代码如下：为了判断"."的地方是否可以填充其他的数值，
        我们需要记录每行没列，每个3*3的格子的情况，使用set来记录。
        每行、每列、每个grid都有一个set来标记。
        需要注意： 回溯会将原来为"." 的地方重新置为 ".",
        如果我们不添加在递归调用的时候，不判定是否已经到达解，而是回溯了，
        那么会将board原来为"." 的地方又重新置为".",
        因此需要在得到最后的结果的时候返回True，
        当无法到达最后的解的时候，也就是for后面，返回False。
        """
        if not board or len(board) !=9 or len(board[0]) != 9:
            return
        rowSetList = []
        colSetList = []
        gridSetList = []
        for i in range(9):
            rowSetList.append(set())
            colSetList.append(set())
            gridSetList.append(set())

        for i in range(9):
            for j in range(9):
                c = board[i][j];
                if c != '.':
                    rowSetList[i].add(c)
                    colSetList[j].add(c)
                    gridSetList[i//3*3+j//3].add(c)
        self.dfs(board,rowSetList,colSetList,gridSetList,0,0)


    """
    i j 是要处理的位置
    """
    def dfs(self,board,rowSetList,colSetList,gridSetList,i,j):

        # 找到第一个 . 的位置
        while i < 9 and j < 9 and board[i][j] != '.':
            j+=1
            if j > 8:
                i+=1
                j=0

        # 已经不存在为 . 的位置，说明已经解决问题，返回True
        if i > 8 or j > 8:
            return True
        # i，j后面的下一个要处理的位置
        if j >7:
             newI = i +1
             newJ = 0
        else:
             newI = i
             newJ = j+1
        for k in range(1,10):
            if not self.ifRowColGridContains(rowSetList,colSetList,gridSetList,i,j,k):
                c = str(k)
                board[i][j] = c
                rowSetList[i].add(c)
                colSetList[j].add(c)
                gridSetList[i//3*3 + j//3].add(c)
                # 下一个要处理的位置已经没有了
                if newI > 8:
                    return  True
                if self.dfs(board,rowSetList,colSetList,gridSetList,newI,newJ):
                    return True
                rowSetList[i].remove(c)
                colSetList[j].remove(c)
                gridSetList[i//3*3 + j//3].remove(c)
                board[i][j] = '.'
        return  False



    def ifRowColGridContains(self,rowSetList,colSetList,gridSetList,i,j,k):
        c = str(k)
        if c in rowSetList[i] or c in colSetList[j] or c in gridSetList[i//3*3+j//3]:
            return  True
        return  False
if __name__ == '__main__':
    board = [list("..9748..."),
             list("7........"),
             list(".2.1.9..."),
             list("..7...24."),
             list(".64.1.59."),
             list(".98...3.."),
             list("...8.3.2."),
             list("........6"),
             list("...2759..")]
    so = Solution()
    so.solveSudoku(board)
    print(board)
