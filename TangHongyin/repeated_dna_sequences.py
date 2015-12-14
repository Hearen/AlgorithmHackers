class Solution(object):

    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        dict = {}
        result = []
        start = 0
        for i in range(len(s)):
            if i >= 9:
                new_key = s[start:i + 1]
                if new_key not in dict:
                    # if not appeared
                    dict[new_key] = True
                else:
                    # if only appeared once
                    if dict[new_key]:
                        result.append(new_key)
                        # appeared twice
                        dict[new_key] = False
                start += 1
        return result

if __name__ == '__main__':
    s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    solution = Solution()
    print solution.findRepeatedDnaSequences(s)
