
import  sys
class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        maxInt = 2147483647
        minInt = -2147483648

        if not str :
            return 0
        newStr = str.strip()
        if len(newStr) == 0:
            return 0
        i = 0
        c = newStr[i]
        flag = 1
        if c == '+':
            flag =1
            i +=1
        elif c == '-':
            flag = -1
            i+=1
        elif not self.isNum(c):
            return  0
        size = len(newStr)
        ans = 0
        j = i
        while i < size:
            if not self.isNum(newStr[i]):
                break
            i +=1
        base = 1
        i-=1
        while i > j-1:
            ans += (ord(newStr[i])-ord('0'))*base
            base*=10
            i -=1
        ans *= flag
        if ans > maxInt:
            return  maxInt
        if ans < minInt:
            return minInt
        return  ans
    def isNum(self,c):
        if ord(c) < ord('0') or ord(c) > ord('9'):
            return False
        return True

if __name__ == '__main__':
    so = Solution()
    print(so.myAtoi("2147483648"))
    print(sys.maxsize)

