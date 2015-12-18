
class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        if not path or len(path)==0:
            return "";

        pathList = path.split("/")
        print(pathList)
        stack = []
        for p in pathList:
            if len(p)==0 or p=='/':
                continue
            if p == '..' :
                if len(stack)>0:
                    stack.pop()
            else:
                if p != '.':
                    stack.append(p)

        res = ''
        for p in stack:
            res +="/"+p
        if len(res) == 0:
            return "/"
        return res
# if __name__ == '__main__':
#     so = Solution()
#     print(so.simplifyPath("/a/./b/../../c/"))