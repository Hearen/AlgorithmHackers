---
author: LHearen
time: Sat Jan 23 20:20:36 CST 2016
categories: 
-week8
tags: 
-DP
---

#### Unique Paths II

*Author      : LHearen*

*E-mail      : LHearen@126.com*

*Time        : 2015-12-29 20:30*

*Description : Follow up for Unique Paths: Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.*

*Source      : https://leetcode.com/problems/unique-paths-ii/*

#### Prefix
There is a direct way as UniquePaths, but that will definitely make the solution hard to realize and the complexity in space and time cost is rather high. At this very moment, we can spot one special feature in this problem, over-lapping sub-problems and the direct way will take lots of time to do the same sub-problems and that is why it will cost so much. So to improve the performance, we should try to store the handled sub-problems for later use and as a result we can try *Memoization* to hack it first; since *Memoization* can be simply used, then the *Dynamic Programming* might be helpful, so we will have the second solution.

#### Solution 1 - Memoization
To fully make use of the outstanding features of DP, we have to allocate an array to store the states for each position and initialize them to -1 for checking whether it is handled already or not, and when it is handled, we can then directly use it to further decrease time cost. As we can easily understand, when there is a block in the **position** the path will be set as 0 and all others will be determined by the left and upper position and before we continue we will record the current result to the array for re-use.
Both of them will cost O(row*column) in space and time complexity.

##### Code in C - 4ms;
'''
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
'''

#### Solution 2 - Dynamic Programming
As we can see, the previous solution will demand initialization before traversal and then in each recursion there will also require further function invoking, to further improve the performance and save time cost, we can have a try at Dynamic Programming which is a bottom-up method and the major clues are quite the same as the previous one.

##### Code in C - 0ms;
'''
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
'''

##### Additional
There must be some better solutions to this problem, if you\'ve got one, please never hesitate to inform me of that, so many thanks in advance!
