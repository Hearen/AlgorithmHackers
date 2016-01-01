#### N-Queens problem

*Author      : LHearen*

*E-mail      : LHearen@126.com*

*Time        : 2015-12-29 20:30*

*Description : Return the total number of distinct solutions of N-Queen problem*

*Source      : https://leetcode.com/problems/n-queens-ii/*

##### Prefix 
Obviously there are two quite different solutions to this problem though both of them are belonging to backtracking:
* one is to use stack to store the state for each row and check the new row for a viable column but when there is no suitable one, we back track to the previous row until the first;

* the other is to use several arrays to store the status of the blocked columns and when the column of the current row is taken, we move forward and due to the recursion we will in the end search out all the suitable arrangements and return the total count.

##### Using stack
Before we truly get started, we have to figure out two basic methods to be used in the following solutions:
* row-based traversing method which means we will check each row of the board and find the suitable columns for them; 
* check the conflict by the *slope* calculated from the *row index* and *column index* of two different queens.

To use a stack to record the viable arrangement for the handled rows and when the current row does not have a suitable arrangement, we will go back to select a another column for the previous row but when the previous row also reaches its end, we will look back further to the previous row and continue the process until we reach the end - the first row which meantime also reaches its end; when the column works, we will move further to the next row until the end but we will not stop till the last row reaches it end - the last column to find the all the viable arrangments and then go back to the previous row and the next column of the previous row and the like until first row reaches it end and at that time we will have collected all the viable arrangments and return the count.

##### Using DFS - a recursive method
In this method, we will use three different arrays to store the position arealdy blocked: the column, the forward slash and back slash direction and check the viability of each column for the current row and then move forward till the end which might turn out to be valid for some and invalid for the others but we will only collect the valid ones and return the total count.


##### Code in C
*AC with 4ms - using stack*
```
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
int totalNQueens(int n)
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
```

*AC - 0ms -using DFS*
```
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
```

##### Additional
There must be some better solutions to this problem, if you've got one, please never hesitate to inform me of that.
