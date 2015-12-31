/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-30 08:35
Description : 
Source      : https://leetcode.com/problems/n-queens-ii/
*******************************************/
#include <stdbool.h>
//Used to test whether the column of the next row conflicts with the current arrangement;
//the stack storing the column index for each row;
//top is a pointer pointing to the top of the stack also a row index;
//n is the size of the board;
//col is the column of the next row;
bool conflict(int* stack, int top, int n, int col)
{
    double slope;
    int d = 1; // the distance between two different rows - compared to the new row;
    while(top > -1)
    {
        /*printf("stack[top]: %d\n", stack[top]);*/
        slope = (col-stack[top--]) / (double)(d++);
        /*printf("slope: %f\n", slope);*/
        if(slope == 0 || slope == 1 || slope == -1)
            return true;
    }
    return false;
}

//Used to find the next new row and corresponding column that is 
//suitable for the arrangement and then return its new row index
//and the new suitable column which will be stored in stack;
int backtrack(int* stack, int top, int n)
{
    while(true)
    {
        while(top > -1 && stack[top]+1 == n) top--; // if the current row reached its final column, search for its previous row;
        if(top == -1) //if row index reaches its end, return -1;
            return top;
        int col = stack[top] + 1; // test next column for the suitable row;
        while(col < n) // test all the remained columns of the row until it's okay with the current arrangement, if not go back to select another row in the previous section;
        {
            stack[top] = col;
            if(conflict(stack, top-1, n, col))
                col++;
            else
                return top;
        }
    }
}
int totalNQueens(int n)
{
    if(n == 1)
        return 1;
    if(n < 4)
        return 0;
    int* stack = (int*)malloc(sizeof(int)*n);
    int top;
    int count = 0;
    int pre = 0;
    int start = 0;
    for(int i = 0; i < n; i++)
    {
        if(start > i)
            i = start;
        top = -1;
        stack[++top] = i;
        printf("start column: %d\n", i);
        while(top < n)
        {
            for(int j = 0; j < n; j++)
            {
                printf("pre-row: %d\tcur-col: %d\n", top, j);
                if(conflict(stack, top, n, j))
                    continue;
                else
                {
                    stack[++top] = j;
                    printf("count: %d\t---------------new row: %d\tcol: %d\n", count, top, j);
                    break;
                }
            }
            if(pre == top || top == n-1) //ensure the previous loop will increase top;
            {//backtracking until there is an valid row and column arrangement;
                if(top == n-1)
                {
                    count++;
                    while((top=backtrack(stack, top, n)) == n-1)
                        count++;
                }
                else
                    top = backtrack(stack, top, n);
                printf("after backtracking############top: %d\n", top);
                if(top == -1)
                    return count;
                if(top == 0) //record the start column for next round;
                    start = stack[top]+1;
                printf("after backtracking----new-row: %d\tnew-col: %d\n", top, stack[top]);
            }
            pre = top;
        }
    }
    return count;
}
