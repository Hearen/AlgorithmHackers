/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-12 20:07
Description : 
Source      : https://leetcode.com/problems/surrounded-regions/
*******************************************/
//AC - 4ms;
void solve(char** board, int rSize, int cSize)
{
    int *rStack = (int*)malloc(sizeof(int)*rSize*cSize);
    int *cStack = (int*)malloc(sizeof(int)*rSize*cSize);
    int top = -1;
    for(int i = 0; i < rSize; i++)
        for(int j = 0; j < cSize; j++)
        {
            if(i == 0 || j == 0 || i == rSize-1 || j == cSize-1)
            {
                if(board[i][j] == 'O')
                {
                    rStack[++top] = i;
                    cStack[top] = j;
                    board[i][j] = 'a';
                }
            }
        }
    while(top > -1)
    {
        int r = rStack[top], c = cStack[top--];
        if(r+1 < rSize && board[r+1][c] == 'O')
        {
            board[r+1][c] = 'a';
            rStack[++top] = r+1;
            cStack[top] = c;
        }
        if(c+1 < cSize && board[r][c+1] == 'O')
        {
            board[r][c+1] = 'a';
            rStack[++top] = r;
            cStack[top] = c+1;
        }
        if(r-1 > -1 && board[r-1][c] == 'O')
        {
            board[r-1][c] = 'a';
            rStack[++top] = r-1;
            cStack[top] = c;
        }
        if(c-1 > -1 && board[r][c-1] == 'O')
        {
            board[r][c-1] = 'a';
            rStack[++top] = r;
            cStack[top] = c-1;
        }
    }
    for(int i = 0; i < rSize; i++)
    {
        for(int j = 0; j < cSize; j++)
        {
            if(board[i][j] == 'a')
                board[i][j] = 'O';
            else
               board[i][j] = 'X'; 
        }
    }
}
