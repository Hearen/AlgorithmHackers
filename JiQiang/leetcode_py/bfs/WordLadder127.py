

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        abc = "abcdefghijklmnopqrstuvwxyz"
        stack = []
        wordList.add(endWord)
        stack.append([beginWord,1])
        size = len(beginWord)
        while len(stack)>0:
            top,level = stack.pop(0)
            if top == endWord:return level
            for i in range(size):
                part1 = top[:i]
                part2 = top[i+1:]
                for j in  abc:
                    if top[i] != j:
                        nextW = part1+j+part2
                        if nextW in wordList:
                            stack.append((nextW,level+1))
                            wordList.remove(nextW)
        return  0
if __name__ == '__main__':

        so = Solution()
        wordlist=["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
        print(so.ladderLength("qa","sq",wordlist))
