

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not  needle or len(needle) ==0:
            return 0
        nSize = len(needle)
        hSize = len(haystack)
        if nSize > hSize :
            return -1

        for i in range(hSize - nSize+1):
            flag = True
            for j in range(nSize):
                if haystack[j+i] !=  needle[j]:
                    flag = False
                    break
            if flag:
                return i
        return  -1

if __name__ == '__main__':
    so = Solution()
    print(so.strStr("123","1"))



