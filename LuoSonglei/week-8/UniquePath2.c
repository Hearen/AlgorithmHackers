/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-22 14:59
Description : 
Source      : https://leetcode.com/problems/unique-paths-ii/
*******************************************/
//AC - 0ms;
int uniquePathsWithObstacles0(int** grid, int rSize, int cSize)
{
    int** arrs = (int**)malloc(sizeof(int*)*rSize);
    for(int i = 0; i < rSize; i++)
        arrs[i] = (int*)malloc(sizeof(int)*cSize);
    for(int i = 0; i < rSize; i++)
        for(int j = 0; j < cSize; j++)
        {
            if(i==0 && j==0 && grid[i][j]==0)
            {
                arrs[i][j] = 1;
                continue;
            }
            if(grid[i][j] == 1)
            {
                arrs[i][j] = 0;
                continue;
            }
            int count = 0;
            if(j-1 > -1)
                count += arrs[i][j-1];
            if(i-1 > -1)
                count += arrs[i-1][j];
            arrs[i][j] = count;
        }
    return arrs[rSize-1][cSize-1];
}


int traverse(int** grid, int row, int col, int** arrs)
{
    if(row < 0 || col < 0)
        return 0;
    if(arrs[row][col] != -1)
        return arrs[row][col];
    int count = 0;
    if(grid[row][col] == 1)
        count = 0;
    else if(row == 0 && col == 0)
        count = 1;
    else
        count = traverse(grid, row-1, col, arrs) + traverse(grid, row, col-1, arrs);
    arrs[row][col] = count;
    return count;
}

//AC - 4ms;
int uniquePathsWithObstacles1(int** grid, int rSize, int cSize)
{
    int **arrs = (int**)malloc(sizeof(int*)*rSize);
    for(int i = 0; i < rSize; i++)
    {
        arrs[i] = (int*)malloc(sizeof(int)*cSize);
        for(int j = 0; j < cSize; j++)
            arrs[i][j] = -1;
    }
    traverse(grid, rSize-1, cSize-1, arrs);
    return arrs[rSize-1][cSize-1];
}
