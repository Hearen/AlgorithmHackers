/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-26 09:09
Description : 
Source      : https://leetcode.com/problems/spiral-matrix-ii/
*******************************************/
//AC - 0ms;
int** generateMatrix(int n)
{
    int size = n*n;
    int count = 1;
    int** matrix = (int**)malloc(sizeof(int*)*n);
    for(int i = 0; i < n; i++)
        matrix[i] = (int*)malloc(sizeof(int)*n);
    int rmin=0, rmax=n-1;
    int cmin=0, cmax=n-1;
    while(count <= size)
    {
        for(int c = cmin; c <= cmax; c++) //from right to left including the last;
            matrix[rmin][c] = count++;
        if(count > size) break;
        for(int r = rmin+1; r <= rmax; r++) //from top to bottom including the last;
            matrix[r][cmax] = count++;
        for(int c = cmax-1; c >= cmin; c--) //from left to right including the last;
            matrix[rmax][c] = count++;
        for(int r = rmax-1; r > rmin; r--) //from bottom to top including the last;
            matrix[r][cmin] = count++;
        rmin++; rmax--; cmin++; cmax--;
    }
    return matrix;
}
