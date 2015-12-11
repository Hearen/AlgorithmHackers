

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        这个方式，当使用java提交的时候就会超时。
        """

        ans = []
        if not s or len(s)<10:
            return ans

        words = {}
        k = len(s)
        for i in range(k-9):
            temp = s[i:i+10]
            if temp in words:
               c = words[temp]
               if c == 1:
                   ans.append(temp)
               words[temp] = words[temp]+1
            else:
                words[temp]=1
        return  ans

if __name__ == '__main__':
    so = Solution()
    print(so.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))

