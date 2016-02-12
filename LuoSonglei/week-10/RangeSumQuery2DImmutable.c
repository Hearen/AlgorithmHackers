/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-12 10:43
Description : 
Source      : https://leetcode.com/problems/range-sum-query-2d-immutable/
*******************************************/
struct NumMatrix
{
    int** sumMatrix;
};

struct NumMatrix* NumMatrixCreate(int** matrix, int rSize, int cSize)
{
    struct NumMatrix *t = (struct NumMatrix*)malloc(sizeof(struct NumMatrix));
    t->sumMatrix = (int**)malloc(sizeof(int*)*rSize);
    int *sums = (int*)malloc(sizeof(int)*(cSize+1));
    for(int r = 0; r < rSize; r++)
    {
        (t->sumMatrix)[r] = (int*)malloc(sizeof(int)*cSize);
        sums[0] = matrix[r][0];
        for(int i = 0; i < cSize; i++)
        {
            if(i > 0)
                sums[i] = sums[i-1]+matrix[r][i];
            (t->sumMatrix)[r][i] = sums[i];
            if(r > 0)
                (t->sumMatrix)[r][i] += (t->sumMatrix)[r-1][i];
        }
    }
    return t;
}

//AC - 256ms;
int sumRegion(struct NumMatrix* numMatrix, int row1, int col1, int row2, int col2)
{
    int** sumMatrix = numMatrix->sumMatrix;
    int ret = sumMatrix[row2][col2];
    if(row1 > 0)
        ret -= sumMatrix[row1-1][col2];
    if(col1 > 0)
        ret -= sumMatrix[row2][col1-1];
    if(row1 > 0 && col1 > 0)
        ret += sumMatrix[row1-1][col1-1];
    return ret;
}

void NumMatrixFree(struct NumMatrix* numMatrix)
{
    free(numMatrix->sumMatrix);
    free(numMatrix);
}
