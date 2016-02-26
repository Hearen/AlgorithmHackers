/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-25 21:20
Description : 
Source      : https://leetcode.com/problems/game-of-life/
*******************************************/
#define MIN(a, b) ((a) < (b) ? (a) : (b))
#define MAX(a, b) ((a) > (b) ? (a) : (b))
//in-place solution using bit manipulation;
void gameOfLife(int** board, int rSize, int cSize)
{
    for(int i = 0; i < rSize; i++)
        for(int j = 0; j < cSize; j++)
        {
            int count = 0;
            for(int rr = MAX(i-1, 0); rr < MIN(i+1, rSize); rr++)
                for(int cc = MAX(j-1, 0); cc < MIN(j+1, cSize); cc++)
                    count += board[rr][cc]&1; //in-place;
            count -= board[i][j];
            if(count==3 || (board[i][j]&&count==2))
                board[i][j] |= 2;
        }
    for(int i = 0; i < rSize; i++)
        for(int j = 0; j < cSize; j++)
            board[i][j] >>= 1;
}
