class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0 :
            return 1
        elif x in [0, 1] or n == 1:
            return x
        elif n == -1:
            return 1 / x

        half = self.myPow(x, n // 2 if n > 0 else (n+1) //2 )

        if n%2 == 0:
            return half * half
        elif n > 0:
            return half * half * x
        else:
            return half * half / x