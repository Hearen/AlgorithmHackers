class Solution(object):

    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        dict = {}
        start = 0
        length = 0
        for i in range(len(s)):
            if s[i] in dict and dict[s[i]] != -1:
                length = max(length, i - start)
                for j in range(start, dict[s[i]]):
                    dict[s[j]] = -1
                start = dict[s[i]] + 1
            dict[s[i]] = i
        if start < len(s):
            length = max(length, len(s) - start)
        return length


if __name__ == "__main__":
    str = "abba"
    solution = Solution()
    print solution.lengthOfLongestSubstring(str)
