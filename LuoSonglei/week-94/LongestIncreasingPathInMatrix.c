/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-05 09:36
Description : Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
[9,9,4],
[6,6,8],
[2,1,1]

]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
[3,4,5],
[3,2,6],
[2,2,1]

]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Source      : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
*******************************************/
#include <bool.h>
const int Directions[][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
bool inRange(int r, int c, int rSize, int cSize)
{
    return r>=0 && r<rSize && c>=0 && c<cSize;
}

int traverse(int r, int c, int rSize, int cSize, int** matrix, int** maxes)
{
    if(!inRange(r, c, rSize, cSize)) return 0;
    if(maxes[r][c] != -1) return maxes[r][c];
    int cur = matrix[r][c];
    int max = 1; //as long as it's valid, it will be at least 1;
    int t = 0;
    if(inRange(r-1, c, rSize, cSize) && cur > matrix[r-1][c])
    {
        t = traverse(r-1, c, rSize, cSize, matrix, maxes)+1;
        if(t > max)
            max = t;
    }
    if(inRange(r+1, c, rSize, cSize) && cur > matrix[r+1][c])
    {
        t = traverse(r+1, c, rSize, cSize, matrix, maxes)+1;
        if(t > max)
            max = t;
    }
    if(inRange(r, c-1, rSize, cSize) && cur > matrix[r][c-1])
    {
        t = traverse(r, c-1, rSize, cSize, matrix, maxes)+1;
        if(t > max)
            max = t;
    }
    if(inRange(r, c+1, rSize, cSize) && cur > matrix[r][c+1])
    {
        t = traverse(r, c+1, rSize, cSize, matrix, maxes)+1;
        if(t > max)
            max = t;
    }
    return maxes[r][c] = max;
}

int traverse0(int r, int c, int rSize, int cSize, int** matrix, int** maxes)
{
    if(!inRange(r, c, rSize, cSize)) return 0;
    if(maxes[r][c] != -1) return maxes[r][c];
    int cur = matrix[r][c];
    int max = 1; //as long as it's valid, it will be at least 1;
    int t = 0;
    for(int i = 0; i < 4; i++) //check the cells around;
    {
        int r0 = r+Directions[i][0];
        int c0 = c+Directions[i][1];
        if(inRange(r0, c0, rSize, cSize) && cur > matrix[r0][c0])
        {
            t = traverse(r0, c0, rSize, cSize, matrix, maxes)+1;
            if(t > max)
                max = t;
        }
    }
    return maxes[r][c] = max;//update the current cell;
}

int longestIncreasingPath(int** matrix, int rSize, int cSize)
{
    int **maxes = (int**)malloc(sizeof(int*)*rSize);
    for(int i = 0; i < rSize; i++) //initialize the maxes states matrix;
    {
        maxes[i] = (int*)malloc(sizeof(int)*cSize);
        for(int j = 0; j < cSize; j++)
            maxes[i][j] = -1;
    }
    int max = 0;
    for(int r = 0; r < rSize; r++) //try to start the traversal from each cell;
    {
        for(int c = 0; c < cSize; c++)
        {
            int t = traverse(r, c, rSize, cSize, matrix, maxes);
            if(t > max)
                max = t;
        }
    }
    return max;
}
