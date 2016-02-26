/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-26 14:02
Description : 
Source      : https://leetcode.com/problems/rotate-image/
*******************************************/
//AC - 0ms;
void rotate(int** matrix, int rSize, int cSize)
{
    int** matrix0 = (int**)malloc(sizeof(int*)*rSize);
    for(int i = 0; i < rSize; i++)
        matrix0[i] = (int*)malloc(sizeof(int)*cSize);
    for(int r = 0; r < rSize; r++)
        for(int c = 0; c < cSize; c++)
            matrix0[c][cSize-r-1] = matrix[r][c];
    for(int r = 0; r < rSize; r++)
        for(int c = 0; c < cSize; c++)
            matrix[r][c] = matrix0[r][c];
}
