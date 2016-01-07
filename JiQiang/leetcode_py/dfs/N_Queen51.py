


class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        pos = [0 for i in range(n)]

        ans = []
        self.dfs(ans,n,pos,0)
        return ans

    def dfs(self,ans,n,pos,i):
        if i == n:
            ans.append(self.generateOneAns(pos,n))
            return

        for tempPos in range(n):
            if self.isValid(pos,i,tempPos):
                pos[i] = tempPos
                self.dfs(ans,n,pos,i+1)
    def generateOneAns(self,pos,n):
        one =[]
        for i in pos:
            oneLine =""
            for j in range(i):
                oneLine+="."
            oneLine +="Q"
            for j in range(i+1,n):
                oneLine+="."
            one.append(oneLine)
        return  one

    def isValid(self,pos,i,k):
        """
        :param pos: 位置数组，每个皇后在每行的位置
        :param i:   当前要处理的行
        :param k:   放到当前行的第k个位置
        :return:    返回是否可以放置
        """
        if i > len(pos)-1:
            return False
        for j in range(i):
            if pos[j] == k:
                return  False
            if abs(j - i) == abs(k-pos[j]):
                return False
        return True


if __name__ == '__main__':

    so = Solution()
    print(so.isValid([1,0],1,1))
    print(len(so.solveNQueens(2)))
