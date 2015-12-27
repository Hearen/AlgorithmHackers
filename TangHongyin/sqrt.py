class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        i = 0
        j = x / 2 + 1
        while i <= j:
            mid = (i + j) // 2
            sq = mid * mid
            if sq == x:
                return mid
            elif sq < x:
                i = mid + 1
            else:
                j = mid - 1
        return j

if __name__ == '__main__':
    solution = Solution()
    print solution.mySqrt(3)