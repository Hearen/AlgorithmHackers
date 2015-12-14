import  sys
# Definition for a point.
class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        if not points:
            return 0
        if len(points) < 3:
            return  len(points)
        res = 0
        for p in points:
            mapDic = {}
            same =0
            ySame = 1
            for p2 in points:
                b = False
                if p.x == p2.x and p.y == p2.y:
                    same+=1
                    continue
                if p.x == p2.x :
                    b = True
                    ySame +=1
                if not b:
                    k = float((p.y - p2.y))/float((p.x-p2.x))
                    if k in mapDic:
                        mapDic[k] =mapDic[k]+1
                    else:
                        mapDic[k] = 1
            if len(mapDic) == 0:
                temM = same
            else:
                temM = max(mapDic.values())+same
            temM = max(temM,ySame)
            if temM > res:
                res = temM
        return  res



if __name__ == '__main__':

    so = Solution()
    ps = []
    ls = [[84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]]
    for tL in ls:
        ps.append(Point(tL[0],tL[1]))
    # ps.append(Point(1,1))
    # ps.append(Point(1,1))
    # ps.append(Point(2,2))
    # ps.append(Point(2,2))

    print(so.maxPoints(ps))



