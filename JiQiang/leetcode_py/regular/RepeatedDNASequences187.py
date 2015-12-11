

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
    def findRepeatedDnaSequences2(self, s):
        """
        :type s: str
        :rtype: List[str]
        四个字母转成3个bit，然后使用一个int就可以存放10个字符。

        """
        ans = []
        if not s or len(s)<10:
            return ans
        words = {}
        k = len(s)
        mask = 0x7FFFFFF
        key = int(0)
        for i in range(10):
            key <<= 3
            key = key | (ord(s[i])&(0x7))
        words[key] =1
        for i in range(10,k):
            key &= mask
            key <<=3
            key = key | ord(s[i])&(0x7)
            if key in words:
                c = words[key]

                if c == 1:
                    ans.append(s[i-9:i+1])
                    words[key] = 2
            else:
                words[key] = 1
        return  ans


if __name__ == '__main__':
    so = Solution()
    print(so.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
    print(so.findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))



