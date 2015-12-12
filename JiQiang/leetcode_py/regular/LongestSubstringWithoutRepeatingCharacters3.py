
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int

        我们使用一个lastSame 来标记最后一个字符的index，
        从该索引到i是没有重复的，当我们处理i的时候，
        我们获取i前面的最后一个s[i] 的位置，
        如果前面没有s[i] 那么说明 lastSame到i这么长的子串是没有重复字符的，更新maxLen ，
        如果 s[i] 的位置大于lastSame，那么说明 s[i] 在i前面的最后一个位置 到i之间是没有重复字符的，
        更新lastSame 为 s[i] 在i前面出现的位置。
        """
        if not s:
            return 0
        # 注意 s 前后的空白字符
        newS = s.strip()
        if  len(newS) <2:
            return  len(newS)
        maxLen = 0
        lastSame = -1 # 指向的位置到i都是没有重复的。
        mapDic = {}
        curI = -1
        for i,c in enumerate(newS):
            if c in mapDic:
                curI = mapDic[c]
                if curI > lastSame:
                    lastSame = curI
            mapDic[c] = i
            if maxLen < i-lastSame:
                maxLen = i - lastSame

        return maxLen
if __name__ == '__main__':

    so = Solution()
    print(so.lengthOfLongestSubstring("aabbbbbbcd"))
