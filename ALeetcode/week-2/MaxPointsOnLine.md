# Max Points on a Line

* Author      : LHearen
* E-mail      : LHearen@126.com
* Time        : 2015-12-29 20:30
* Description : Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
* Source      : https://leetcode.com/problems/max-points-on-a-line/

## Specification 
One intrinsic solution to this problem is to use three loops to traverse and find them all, during which we are going to find the line equation determined by two points and then check the last one in the innermost loop; but using two points to get the line equation is quite inconvenient and inefficient so we need to search for another method that can be used more easily - at last we find out determine whether three points in one line or not can simply determined by slope and one fixed point, by the way the slope must be calculated with the fixed point.

### Attention
To completely solve this problem, we have to care for several details:

1. calculating the slope might encounter underflow;
2. overlapped points should be handled separately;

### Code
* AC with 20ms
```
bool isEqual(struct Point pA, struct Point pB)
{
    return pA.x == pB.x && pA.y == pB.y;
}

bool slopeEqual(struct Point pA, struct Point pB, struct Point pC)
{
    if(pA.y == pB.y || pA.y == pC.y)
    {
        if(pA.y == pB.y && pA.y == pC.y)
            return true;
        //in case of repitition;
        if(pA.y == pB.y && pA.x == pB.x)
            return true;
        if(pA.y == pC.y && pA.x == pC.x)
            return true;
        return false;
    }
    if((double)(pA.x - pB.x) / (pA.y - pB.y) == (double)(pA.x - pC.x) / (pA.y - pC.y))
        return true;
    return false;
}

int maxPoints(struct Point* points, int pointsSize)
{
    if(pointsSize < 3)
        return pointsSize;
    int count = 1;
    int max = 2;
    for(int i = 0; i < pointsSize; i++)
        for(int j = i + 1; j < pointsSize; j++)
        {
            //collect the repeated points between i and j;
            for(int h = i + 1; h < j; h++)
                if(isEqual(points[i], points[h]))
                    count++;
            //find a different point;
            //all the same will be skipped and counted;
            for(;j < pointsSize && isEqual(points[i], points[j]); j++, count++);
            //the first different point;
            if(j < pointsSize)
                count++; 
            for(int k = j + 1; k < pointsSize; k++)
            {
                //save invalid checking loop;
                if(max > count + pointsSize - k + 1)
                    break;
                if(slopeEqual(points[i], points[j], points[k]))
                    count++;
            }
            if(count > max)
                max = count;
            count = 1;
        }
    return max;
}

```

## Final
There must be some better solutions to this problem, if you've got one, please never hesitate to inform me of that.
