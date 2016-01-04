/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-30 08:35
Description : 
Source      : https://leetcode.com/problems/n-queens-ii/
*******************************************/
#include <stdbool.h>
#define TEST
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
        #ifdef TEST
        printf("stack[top]: %d\n", stack[top]);
        #endif
        slope = (col-stack[top--]) / (double)(d++);
        #ifdef TEST
            printf("slope: %f\n", slope);
        #endif
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
int totalNQueens0(int n)
{
    //handle special cases;
    if(n == 1)
        return 1;
    if(n < 4)
        return 0;
    // stack is used to store the column index for each row - the row index is indicated by the stack index for example stack[0]=1 means the first row takes the second column;
    int* stack = (int*)malloc(sizeof(int)*n);
    int top; //the index pointing to the top of the stack; 
    int count = 0; //used to count the viable arrangement;
    int pre = 0; //record the previous viable row index;
    int start = 0; //used to record the beginning row index for the next round;
    for(int i = 0; i < n; i++)
    {
        if(start > i)
            i = start;
        top = -1;
        stack[++top] = i;
        #ifdef TEST
            printf("start column: %d\n", i);
        #endif
        while(top < n)
        {
            for(int j = 0; j < n; j++)
            {
                #ifdef TEST
                    printf("pre-row: %d\tcur-col: %d\n", top, j);
                #endif
                if(conflict(stack, top, n, j))
                    continue;
                else
                {
                    stack[++top] = j;
                    #ifdef TEST
                        printf("count: %d\t---------------new row: %d\tcol: %d\n", count, top, j);
                    #endif
                    break;
                }
            }
            if(pre == top || top == n-1) //ensure the previous loop will increase top;
            {//backtracking until there is an valid row and column arrangement;
                if(top == n-1)
                    count++;
                while((top=backtrack(stack, top, n)) == n-1)
                    count++;
                #ifdef TEST
                    printf("after backtracking############top: %d\n", top);
                #endif
                if(top == -1)
                    return count;
                if(top == 0) //record the start column for next round;
                    start = stack[top]+1;
                #ifdef TEST
                    printf("after backtracking----new-row: %d\tnew-col: %d\n", top, stack[top]);
                #endif
            }
            pre = top;
        }
    }
    return count;
}

void find(int row, int size, bool* col, bool* fslash, bool* bslash, int* count)
{
    if(row == size)
    {
        (*count)++;
        return;
    }
    for(int j = 0; j < size; j++)
    {
        if(col[j] && fslash[row+j] && bslash[row+size-j])
        {
            col[j] = fslash[row+j] = bslash[row+size-j] = false;
            find(row+1, size, col, fslash, bslash, count);
            col[j] = fslash[row+j] = bslash[row+size-j] = true;
        }
    }
}

//AC - 0ms;
int totalNQueens(int n)
{
    bool* col=(bool*)malloc(sizeof(bool)*n);
    for(int i = 0; i < n; i++)
        col[i] = true;
    bool* fslash=(bool*)malloc(sizeof(bool)*(2*n));
    bool* bslash=(bool*)malloc(sizeof(bool)*(2*n));
    for(int i = 0; i < 2*n; i++)
    {
        fslash[i] = true;
        bslash[i] = true;
    }
    int count = 0;
    find(0, n, col, fslash, bslash, &count);
    return count;
}
