/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-05 10:41
Description : Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

Source      : https://leetcode.com/problems/number-of-islands/
*******************************************/
#include <bool.h>
const int Directions[][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
bool inRange(int r, int c, int rSize, int cSize)
{
    return r>=0 && r<rSize && c>=0 && c<cSize;
}

void traverse0(int r, int c, int rSize, int cSize, char** grid, bool** visited)
{
    if(!inRange(r, c, rSize, cSize)) return ;
    if(visited[r][c]) return ;
    if(grid[r][c] == '0') return ;
    visited[r][c] = 1;
    for(int i = 0; i < 4; i++)
    {
        int r0 = r+Directions[i][0];
        int c0 = c+Directions[i][1];
        traverse(r0, c0, rSize, cSize, grid, visited);
    }
}

//AC - 4ms;
int numIslands0(char** grid, int rSize, int cSize)
{
    bool** visited = (bool**)malloc(sizeof(bool*)*rSize);
    for(int r = 0; r < rSize; r++)
    {
        visited[r] = (bool*)malloc(sizeof(bool)*cSize);
        memset(visited[r], 0, sizeof(bool)*cSize);
    }
    int count = 0;
    for(int r = 0; r < rSize; r++)
        for(int c = 0; c < cSize; c++)
        {
            if(grid[r][c]=='1' && !visited[r][c])
            {
                traverse(r, c, rSize, cSize, grid, visited);
                count++;
            }
        }
    return count;
}

void traverse(int r, int c, int rSize, int cSize, char** grid)
{
    grid[r][c] = '0';
    if(r>0 && grid[r-1][c]=='1')
        traverse(r-1, c, rSize, cSize, grid);
    if(c>0 && grid[r][c-1]=='1')
        traverse(r, c-1, rSize, cSize, grid);
    if(r<rSize-1 && grid[r+1][c]=='1')
        traverse(r+1, c, rSize, cSize, grid);
    if(r<cSize-1 && grid[r][c+1]=='1')
        traverse(r, c+1, rSize, cSize, grid);
}

//AC - 0ms;
int numIslands(char** grid, int rSize, int cSize)
{
    if(rSize==0 || cSize==0) return 0;
    int count = 0;
    for(int r = 0; r < rSize; r++)
    {
        for(int c = 0; c < cSize; c++)
        {
            if(grid[r][c] == '1')
            {
                count++;
                traverse(r, c, rSize, cSize, grid);
            }
        }
    }
    return count;
}
