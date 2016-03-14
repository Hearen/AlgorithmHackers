


class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not needle or len(needle)==0:
            return 0
        if not haystack or len(haystack)==0:
            return  -1
        ns = len(needle)
        hs = len(haystack)
        nextFlag = [0 for i in range(ns)]
        for i in range(1,ns):
            k = nextFlag[i-1]
            c = needle[i]
            while k >0 and needle[k] != c:
                k = nextFlag[k-1]
            if needle[k] == c:
                nextFlag[i] = k+1
        i = 0
        j = 0
        while i < hs and j < ns and (hs -i) >=(ns-j):
            if needle[j] == haystack[i]:
                i+=1
                j+=1
            elif j ==0:
                i+=1
            else:
                j = nextFlag[j-1] # 前面那个字符的
        if j == ns:
            return  i - j
        return  -1
if __name__ == '__main__':

    so = Solution()
    print(so.strStr("a","a"))


