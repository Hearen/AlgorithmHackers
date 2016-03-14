

class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n==0:return  0
        if n <3 :
            return n
        dp=[0 ]*(n+1)
        dp[0]=1
        dp[1]=1
        dp[2] = 2
        t = 3
        while t < n+1:
            mid = t//2
            for i in range(mid):
                dp[t]+=dp[i]*dp[t-i-1]
            dp[t]<<=1
            if t % 2 == 1:
               dp[t]+=dp[mid]*dp[mid]
            t+=1
        return dp[n]
if __name__ == '__main__':

    so = Solution()
    print(so.numTrees(5))


