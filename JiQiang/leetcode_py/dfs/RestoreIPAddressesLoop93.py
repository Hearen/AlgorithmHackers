

class Solution(object):
    def restoreIpAddresses(self, s):
        """
        这里不是使用回溯法，而是循环
        a b c d 表示ip四个位置上的长度，我们只要生成前三个就可以了。
        :type s: str
        :rtype: List[str]
        """
        ans = []
        ipLen = [0,0,0]
        sSize = len(s)
        if sSize >12 or sSize < 4:
            return ans
        for i in range(1,4):
            if sSize - i > 9 :
                continue
            # 如果有前导的0，直接跳出。
            if  i >1 and s[0] =='0' or  sSize - i < 3:
                break
            for j in range(1,4):
                if sSize - i -j > 6:
                    continue
                if j > 1 and s[i] == '0' or sSize - i -j < 2:
                    break
                for k in range(1,4):
                    if sSize - i - j - k > 3:
                        continue
                    if k > 1 and s[i+j] =='0' or sSize - i - j - k <1:
                        break
                    if sSize - i - j - k > 1 and s[i+k+j]=='0':
                        continue
                    oneA = self.oneAns(s,[i,j,k])
                    if oneA:
                        ans.append(oneA)
        return ans
    def oneAns(self,s,part):
        """
        给定一个分割，返回ip
        :param s:str
        :param part: List[int]
        :return: str
        """
        su = 0
        be = 0
        ans =""
        for i in part:
            su +=i
            a = s[be:su]
            if(int(a) > 255):
                return None
            ans += a+"."
            be +=i
        a = s[su:len(s)]
        if(int(a) > 255):
            return None
        ans +=a
        return ans


if __name__ == '__main__':

    so = Solution()
    print(so.restoreIpAddresses("101023"))