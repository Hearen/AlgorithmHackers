class Solution(object):

    def match(self, s, p):
        if len(p) == 2 and p[-1] == '*':
            if p[0] == '.':
                return True
            elif s == p[0]:
                return True
            else:
                return False
        elif p == '.':
            return True
        elif p == s:
            return True
        else:
            return False

    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        target = [0]
        for i in range(len(s)):
            target.append(s[i])
        regular = [0]
        i = 0
        while i < len(p):
            if i < len(p) - 1 and p[i + 1] == '*':
                regular.append(p[i] + '*')
                i += 1
            else:
                regular.append(p[i])
            i += 1
        dp = [[False for j in range(len(regular))] for i in range(len(target))]
        dp[0][0] = True

        # init the first row
        flag = True
        for i in range(1, len(regular)):
            if len(regular) > 1 and regular[i][-1] == '*' and flag:
                dp[0][i] = True
            else:
                dp[0][i] = False
                flag = False

        # init the first column
        for i in range(1, len(target)):
            dp[i][0] = False

        for i in range(1, len(dp)):
            for j in range(1, len(dp[i])):
                if dp[i-1][j-1]:
                    dp[i][j] = self.match(target[i], regular[j])
                if not dp[i][j] and dp[i-1][j]:
                    if len(regular[j]) > 1 and (regular[j][0] == '.' or regular[j][0] == target[i]):
                        dp[i][j] = True
                if not dp[i][j] and dp[i][j-1]:
                    if len(regular[j]) > 1:
                        dp[i][j] = True
        return dp[len(dp) - 1][len(dp[-1]) - 1]

if __name__ == '__main__':
    s = "aaa"
    p = "ab*ac*a"
    solution = Solution()
    print solution.isMatch(s, p)
