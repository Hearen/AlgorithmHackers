class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        sum = 0
        bit = 1
        flag = True
        for i in reversed(str):
            if i.isdigit():
                sum += bit * int(i)
                bit *= 10
            else:
                if i == ' ':
                    continue
                else:
                    if not flag:
                        return 0
                    elif i == '-':
                        sum = 0 - sum
                        flag = False
                    elif i == '+':
                        flag = False
                    else:
                        return 0
        if sum > 2147483647:
            return 2147483647
        elif sum < -2147483648:
            return -2147483648
        return sum

if __name__ == '__main__':
    solution = Solution()
    print solution.myAtoi("     +004500")