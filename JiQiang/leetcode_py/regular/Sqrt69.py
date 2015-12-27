

class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x <= 1:
            return x
        x0 = 0
        cur = 1
        while abs(x0-cur)>0.001:
            x0 = cur
            cur = x/(2.0*x0)+x0/2.0
        return  int(cur)
if __name__ == '__main__':

    so = Solution()
    print(so.mySqrt(8))




