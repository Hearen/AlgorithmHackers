/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-26 08:42
Description : 
Source      : https://leetcode.com/problems/spiral-matrix/
*******************************************/
//AC - 0ms;
int* spiralOrder(int** matrix, int rSize, int cSize)
{
    int count = 0;
    int size = rSize*cSize;
    int *arr = (int*)malloc(sizeof(int)*size);
    int rmin=0, rmax=rSize-1;
    int cmin=0, cmax=cSize-1;
    while(count < size)
    {
        for(int c = cmin; c <= cmax; c++) //from left to right including the last;
            arr[count++] = matrix[rmin][c];
        if(count == size) break; //only one row;
        for(int r = rmin+1; r <= rmax; r++) //from top to bottom including the last;
            arr[count++] = matrix[r][cmax];
        if(count == size) break; //only one column;
        for(int c = cmax-1; c >= cmin; c--) //from right to left including the last;
            arr[count++] = matrix[rmax][c];
        for(int r = rmax-1; r > rmin; r--) //from bottom to top excluding the last;
            arr[count++] = matrix[r][cmin];
        rmin++; rmax--; cmin++; cmax--;
    }
    return arr;
}
