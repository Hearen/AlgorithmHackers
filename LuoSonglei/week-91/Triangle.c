/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-12 10:12
Description : 
Source      : https://leetcode.com/problems/triangle/
*******************************************/
//AC - 8ms;
int minimumTotal0(int** triangle, int rSize, int *cSize)
{
    int len = sizeof(int)*cSize[rSize-1];
    int *mins0 = (int*)malloc(len);
    int *mins1 = (int*)malloc(len);
    mins0[0] = triangle[0][0];
    for(int r = 1; r < rSize; r++)
    {
        for(int c = 0; c < cSize[r]; c++)
        {
            if(c == 0)
            {
                mins1[c] = mins0[c]+triangle[r][c];
                continue;
            }
            if(c == cSize[r]-1)
            {
                mins1[c] = mins0[c-1]+triangle[r][c];
                continue;
            }
            int t = triangle[r][c] + mins0[c];
            if(mins0[c] > mins0[c-1])
                t = triangle[r][c] + mins0[c-1];
            mins1[c] = t;
        }
        int *t = mins0;
        mins0 = mins1;
        mins1 = t;
    }
    int t = mins0[0];
    for(int i = 0; i < cSize[rSize-1]; i++)
        if(t > mins0[i])
            t = mins0[i];
    return t;
}

//AC - 8ms;
int minimumTotal(int** triangle, int rSize, int *cSize)
{
    int len = sizeof(int)*cSize[rSize-1];
    int *mins0 = (int*)malloc(len);
    int *mins1 = (int*)malloc(len);
    mins0[0] = triangle[0][0];
    for(int r = 1; r < rSize; r++)
    {
        for(int c = 0; c < cSize[r]; c++)
        {
            if(c == cSize[r]-1)
                mins0[c] = mins0[c-1];
            int t = triangle[r][c] + mins0[c];
            if(c > 0 && mins0[c] > mins0[c-1])
                t = triangle[r][c] + mins0[c-1];
            mins1[c] = t;
        }
        int *t = mins0;
        mins0 = mins1;
        mins1 = t;
    }
    int t = mins0[0];
    for(int i = 0; i < cSize[rSize-1]; i++)
        if(t > mins0[i])
            t = mins0[i];
    return t;
}
