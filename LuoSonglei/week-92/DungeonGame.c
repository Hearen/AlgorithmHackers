/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-17 13:52
Description : 
Source      : https://leetcode.com/problems/dungeon-game/
*******************************************/
#include <limits.h>
#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a) : (b))
//AC - 8ms;
int calculateMinimumHP0(int** dungeon, int rSize, int cSize)
{
    int** mins = (int**)malloc(sizeof(int*)*rSize);
    for(int i = 0; i < rSize; i++)
    {
        mins[i] = (int*)malloc(sizeof(int)*cSize);
        memset(mins[i], 0, sizeof(int)*cSize);
    }
    for(int i = rSize-1; i >= 0; i--)
        for(int j = cSize-1; j >= 0; j--)
        {
            if(i==rSize-1 && j==cSize-1)
                mins[i][j] = MAX(1, 1-dungeon[i][j]);
            else if(i == rSize-1)
                mins[i][j] = MAX(1, mins[i][j+1]-dungeon[i][j]);
            else if(j == cSize-1)
                mins[i][j] = MAX(1, mins[i+1][j]-dungeon[i][j]);
            else
                mins[i][j] = MAX(1, MIN(mins[i+1][j], mins[i][j+1])-dungeon[i][j]);
        }
    return mins[0][0];
}

//AC - 8ms - reduce the different conditions by adding an edge;
int calculateMinimumHP(int** dungeon, int rSize, int cSize)
{
    int** mins = (int**)malloc(sizeof(int*)*(rSize+1));
    for(int i = 0; i <=rSize; i++)
    {
        mins[i] = (int*)malloc(sizeof(int)*(cSize+1));
        memset(mins[i], 0, sizeof(int)*cSize);
    }
    for(int i = 0; i <= rSize; i++)
        mins[i][cSize] = INT_MAX;
    for(int i = 0; i <= cSize; i++)
        mins[rSize][i] = INT_MAX;
    mins[rSize-1][cSize] = 1;
    mins[rSize][cSize-1] = 1;
    for(int i = rSize-1; i >= 0; i--)
        for(int j = cSize-1; j >= 0; j--)
            mins[i][j] = MAX(1, MIN(mins[i+1][j], mins[i][j+1])-dungeon[i][j]);
    return mins[0][0];
}
