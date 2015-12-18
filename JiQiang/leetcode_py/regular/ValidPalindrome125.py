
class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """

        if not s or len(s)==0:
            return True
        left = 0
        right = len(s)-1
        while left <= right:
            while left <= right and not self.isalNum(s[left]):
                left +=1
            while right >= left and not self.isalNum(s[right]):
                right-=1
            if left> right:
                return True
            a = s[left]
            b = s[right]
            if a.lower() == b.lower():
                left +=1
                right -=1
            else:
                return False
        return  True
    def isalNum(self,a):
        if a >= '0' and a <= '9':
            return  True
        if a.lower() >= 'a' and a.lower() <='z':
            return True
        return False
if __name__ == '__main__':
    so = Solution()
    print(so.isPalindrome("ab"))