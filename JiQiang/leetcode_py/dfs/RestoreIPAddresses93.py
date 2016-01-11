

class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        ans = []
        self.dfs(ans,[],s,0,0)
        return ans

    def dfs(self,ans,tempAns,s,curIndex,ipIndex):
        """

        :param s: 给定的字符串
        :param curIndex: 将要处理的位置
        :param ipIndex: 当前要生成第几个ip位置 0-3 个
        :return:
        """
        if len(s) == curIndex and ipIndex == 4:
            ans.append(".".join(tempAns))
            return

        # 有可能会有解
        if len(s) > curIndex and ipIndex < 4:
            l=1
            while l < 4 and l+curIndex <= len(s):
                curIP = s[curIndex:l+curIndex]
                curIPNum = int(curIP)
                if self.numDigitsNum(curIPNum) != l:
                    return
                if curIPNum > 255:
                    return
                tempAns.append(curIP)
                self.dfs(ans,tempAns,s,curIndex+l,ipIndex+1)
                tempAns.pop()
                l+=1
    def numDigitsNum(self,num):
        if num < 10:
            return 1
        if num<100:
            return  2
        if num<1000:
            return  3

if __name__ == '__main__':

    so = Solution()
    print(so.restoreIpAddresses("0000"))