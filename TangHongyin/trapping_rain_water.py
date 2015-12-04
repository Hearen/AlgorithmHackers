class Rect(object):
    x = 0
    y = 0

    def __init__(self, x, y):
        self.x = x
        self.y = y


class Solution(object):

    def trap(self, height):
        queue = []
        queue_index = []
        water = 0

        for i in range(len(height)):

            rect = Rect(1, height[i])

            if len(queue) == 0 or height[i] <= queue[-1].y:
                queue.append(rect)
                queue_index.append(i)
            else:
                last_box = 0
                last_index = 0
                part_box = 0
                while len(queue) > 0 and queue[-1].y <= height[i]:
                    last_box = queue[-1].x * queue[-1].y
                    last_index = queue_index[-1]
                    part_box += last_box
                    queue.pop()
                    queue_index.pop()

                if len(queue) > 0:
                    water += (i - queue_index[-1] - 1) * height[i] - part_box
                    queue.append(Rect(i - queue_index[-1], height[i]))
                    queue_index.append(i)
                else:
                    part_box -= last_box
                    water += (i - last_index - 1) * last_box - part_box
                    queue.append(Rect(1, height[i]))
                    queue_index.append(i)
        return water

if __name__ == '__main__':
    height = [2,6,3,8,2,7,2,5,0]
    solution = Solution()
    print solution.trap(height)
