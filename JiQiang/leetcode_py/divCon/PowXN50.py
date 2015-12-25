

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if abs(x) < 0.000000001 or x ==1:
            return x
        if n ==0:
            return 1
        if n == 1:
            return  x
        # if n < 0:
        #     return  1.0/self.myPowPositiveN(x,-n)
        # return  self.myPowPositiveN(x,n)
        if n < 0:
            return  1.0/self.myPowDiv(x,-n)
        return  self.myPowDiv(x,n)

    def myPowPositiveN(self,x,posiN):

        res = x
        #ra = (i for i in range(1,posiN))
        j = 1
        while j<posiN :
            res *=x
            j+=1
            if abs(res) <0.000000001:
                return 0
        return  res
    # 输入的n是正整数
    def myPowDiv(self,x,n):
        if n <= 0:
            return 1
        if n ==1:
            return x
        if n == 2:
            return x*x
        left = self.myPowDiv(x,n//2)
        right =self.myPowDiv(x,n-n//2)
        return  left*right


if __name__ == '__main__':

    so = Solution()
    print(so.myPow(8.88023,3))

