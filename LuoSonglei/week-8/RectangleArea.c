/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-21 08:55
Description : 
Source      : https://leetcode.com/problems/rectangle-area/
*******************************************/
//AC - 20ms;
int computeArea(int a, int b, int c, int d, int e, int f, int g, int h)
{
    if(a>=g || c<=e || b>=h || d<=f)
        return (c-a)*(d-b)+(g-e)*(h-f);
    int leftMax = a > e? a : e;
    int bottomMax = b > f? b : f;
    int rightMin = c < g? c : g;
    int topMin = d < h? d : h;
    return (c-a)*(d-b)+(g-e)*(h-f) - (rightMin-leftMax)*(topMin-bottomMax);
}
