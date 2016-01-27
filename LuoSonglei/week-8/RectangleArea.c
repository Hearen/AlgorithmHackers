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
    int size = (c-a)*(d-b)+(g-e)*(h-f);
    if(a>=g || c<=e || b>=h || d<=f)//without overlap;
        return size; 
    //overlapped area;
    int leftMax = a > e? a : e;
    int bottomMax = b > f? b : f;
    int rightMin = c < g? c : g;
    int topMin = d < h? d : h;
    return size - (rightMin-leftMax)*(topMin-bottomMax);
}
