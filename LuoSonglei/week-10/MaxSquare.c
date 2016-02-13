/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-13 10:58
Description : 
Source      : https://leetcode.com/problems/maximal-square/
*******************************************/
//AC - 4ms;
//https://leetcode.com/discuss/38489/easy-solution-with-detailed-explanations-8ms-time-and-space
int maximalSquare(char** matrix, int rSize, int cSize)
{
    int max = 0;
    int *pre = (int*)malloc(sizeof(int)*cSize);
    int *cur = (int*)malloc(sizeof(int)*cSize);
    for(int r=0; r<rSize; r++)
        for(int c=0; c<cSize; c++)
        {
            if(c==0)
                cur[c] = matrix[r][c] - '0';
            else
            {
                if(matrix[r][c] == '1')
                {
                    if(r > 0)
                    {
                        int t = cur[c-1];
                        if(pre[c] < t)
                            t = pre[c];
                        if(pre[c-1] < t)
                            t = pre[c-1];
                        cur[c] = t+1;
                    }
                    else
                        cur[c] = 1;
                }
                else
                    cur[c] = 0;
            }
            if(cur[c] > max)
                max = cur[c];
        }
    int *t = pre;
    pre = cur;
    cur = t;
    return max*max;
}
