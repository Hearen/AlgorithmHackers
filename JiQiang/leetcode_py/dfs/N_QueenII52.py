

class Solution(object):


    def Soluton(self):
        self.count =0

    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.count=0
        pos = [0 for i in range(n)]
        self.dfs(n,pos,0)
        return  self.count


    def dfs(self,n,pos,i):
        if i == n:
            self.count+=1

        for tempPos in range(n):
            if self.isValid(pos,i,tempPos):
                pos[i] = tempPos
                self.dfs(n,pos,i+1)

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
    print(so.totalNQueens(8))