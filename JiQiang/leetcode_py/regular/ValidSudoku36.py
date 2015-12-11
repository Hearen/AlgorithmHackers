
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        暴力统计Sudoku的两个条件
        1. 每一行每一列都不能有相同的数字
        2. 每个3*3 的格子不能有相同的数字
        """
        if not board or len(board) != 9 or len(board[0])!=9:
            return  False

        # 条件1 每一行每一列不能有相同的数子
        for i in range(9):
            rowFlag = set([])
            colFlag = set([])
            for j in range(9):
                if board[i][j] != '.':
                    if board[i][j] in rowFlag:
                        return  False
                    else:
                        rowFlag.add(board[i][j])
                if board[j][i] != '.':
                    if board[j][i] in colFlag:
                        return  False
                    else:
                        colFlag.add(board[j][i])

        # 第二个条件判断，每个3*3 的格子
        for i in range(0,9,3):
            for j in range(0,9,3):
                flag =[]
                for m in range(3):
                    for n in range(3):
                        if board[i+m][j+n] != '.':
                            if board[i+m][j+n] in flag:
                                return  False
                            else:
                                flag.append(board[i+m][j+n])

        return  True

    def isValidSudoku2(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        暴力统计Sudoku的两个条件
        1. 每一行每一列都不能有相同的数字
        2. 每个3*3 的格子不能有相同的数字
        给每行，每一列，以及每一个3*3 的格子都申请一个set，这样遍历一遍board，遇到i，j就判断其是否已经出现
        在相应的列的set或者行的set或者相应的3*3的格子set中，如果出现了，就返回False，否则继续
        """

        # 首先申请set
        rowSetsList = []
        colSetsList = []
        gridSetList = []
        for i in range(9):
            rowSetsList.append(set())
            colSetsList.append(set())
            gridSetList.append(set())
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    c = board[i][j]
                    if c in rowSetsList[i] or c in colSetsList[j] or c in gridSetList[i//3*3+j//3]:
                        return  False
                    rowSetsList[i].add(c)
                    colSetsList[j].add(c)
                    gridSetList[i//3*3+j//3].add(c)

        return  True



