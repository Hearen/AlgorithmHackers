# Definition for a point.
class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b


class Solution(object):
    # be care of the two same points
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        dict = {}
        if len(points) <= 2:
            return len(points)
        max_points = 0
        for i in range(len(points)):
            # points[i] = Point(points[i][0], points[i][1])
            for j in range(i + 1, len(points)):
                # points[j] = Point(points[j][0], points[j][1])
                k = 0
                b = 0

                if (points[i].x - points[j].x) == 0:
                    k = 'nan'
                    b = points[i].x
                else:
                    k = float(points[i].y - points[j].y) / float(points[i].x - points[j].x)
                    b = points[i].y - k * points[i].x
                if not (k, b) in dict:
                    dict[(k, b)] = []
                if i not in dict[(k, b)]:
                    dict[(k, b)].append(i)
                if j not in dict[(k, b)]:
                    dict[(k, b)].append(j)

                if len(dict[(k,b)]) > max_points:
                    max_points = len(dict[(k,b)])
                max_points = max(max_points, len(dict[(k, b)]))
        print [(points[x].x, points[x].y) for x in dict[(0.414285714286,16)]]
        return max_points

if __name__ == "__main__":
    points = [[560,248],[0,16],[30,250],[950,187],[630,277],[950,187],[-212,-268],[-287,-222],[53,37],[-280,-100],[-1,-14],[-5,4],[-35,-387],[-95,11],[-70,-13],[-700,-274],[-95,11],[-2,-33],[3,62],[-4,-47],[106,98],[-7,-65],[-8,-71],[-8,-147],[5,5],[-5,-90],[-420,-158],[-420,-158],[-350,-129],[-475,-53],[-4,-47],[-380,-37],[0,-24],[35,299],[-8,-71],[-2,-6],[8,25],[6,13],[-106,-146],[53,37],[-7,-128],[-5,-1],[-318,-390],[-15,-191],[-665,-85],[318,342],[7,138],[-570,-69],[-9,-4],[0,-9],[1,-7],[-51,23],[4,1],[-7,5],[-280,-100],[700,306],[0,-23],[-7,-4],[-246,-184],[350,161],[-424,-512],[35,299],[0,-24],[-140,-42],[-760,-101],[-9,-9],[140,74],[-285,-21],[-350,-129],[-6,9],[-630,-245],[700,306],[1,-17],[0,16],[-70,-13],[1,24],[-328,-260],[-34,26],[7,-5],[-371,-451],[-570,-69],[0,27],[-7,-65],[-9,-166],[-475,-53],[-68,20],[210,103],[700,306],[7,-6],[-3,-52],[-106,-146],[560,248],[10,6],[6,119],[0,2],[-41,6],[7,19],[30,250]]
    for i in range(len(points)):
        points[i] = Point(points[i][0], points[i][1])
    solution = Solution()
    print solution.maxPoints(points)
