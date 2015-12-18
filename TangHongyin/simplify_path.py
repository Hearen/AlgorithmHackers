class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """

        tempStack = []
        stack = []
        # init
        if path[0] != '/':
            stack.append('/')
        if path[-1] != '/':
            path += '/'

        for i in range(len(path)):
            if path[i] == '/':
                tempStr = "".join(tempStack)
                # when stack == "(/)xxx/" and path = "xxx//"
                if tempStr == "" and len(stack) > 0 and stack[-1] == '/':
                    continue
                # when stack == "(/)xxx/" and path = "xxx/./"
                if tempStr == ".":
                    tempStack = []
                    continue
                # when stack == "(/)xxx/" and path = "xxx/../"
                if tempStr == "..":
                    tempStack = []
                    # make sure not pop the root dir
                    if len(stack) > 1:
                        stack.pop()
                    while len(stack) > 1 and stack[-1] != '/':
                        stack.pop()
                    continue
                stack += tempStack
                tempStack = []
                stack.append(path[i])
            else:
                tempStack.append(path[i])
        # pop the last slash
        if len(stack) > 1 and stack[-1] == '/':
            stack.pop()

        return "".join(stack)

if __name__ == '__main__':
    solution = Solution()
    path = "/..."
    print solution.simplifyPath(path)
