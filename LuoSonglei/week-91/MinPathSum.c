/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-12 14:43
Description : 
Source      : https://leetcode.com/problems/minimum-path-sum/
*******************************************/
//AC - 20ms;
int minPathSum(int** grid, int rSize, int cSize)
{
    int *t, *sums0, *sums1;
    sums0 = (int*)malloc(sizeof(int)*cSize);
    sums1 = (int*)malloc(sizeof(int)*cSize);
    sums0[0] = grid[0][0];
    for(int i = 1; i < cSize; i++)
        sums0[i] = sums0[i-1] + grid[0][i];
    for(int r=1; r<rSize; r++)
    {
        for(int c=0; c<cSize; c++)
        {
            int min = sums0[c];
            if(c > 0 && min > sums1[c-1])
                min = sums1[c-1];
            sums1[c] = min+grid[r][c];
        }
        t=sums0, sums0=sums1, sums1=t;
    }
    return sums0[cSize-1];
}
