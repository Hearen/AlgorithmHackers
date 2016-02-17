/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-17 10:08
Description : 
Source      : https://leetcode.com/problems/edit-distance/
*******************************************/
int min(int a, int b, int c)
{
    if(a > b)
        return b < c? b : c;
    else
        return a < c? a : c;
}

//AC - 12ms;
int minDistance(char* s1, char* s2)
{
    int len1=strlen(s1), len2=strlen(s2);
    int **mins = (int**)malloc(sizeof(int*)*(len1+1));
    for(int i = 0; i <= len1; i++)
    {
        mins[i] = (int*)malloc(sizeof(int)*(len2+1));
        memset(mins[i], 0, sizeof(int)*(len2+1));
    }
    for(int i = 0; i <= len1; i++)
        mins[i][0] = i;
    for(int i = 0; i <= len2; i++)
        mins[0][i] = i;
    for(int i = 1; i <= len1; i++)
        for(int j = 1; j <= len2; j++)
        {
            if(s1[i-1] == s2[j-1])
                mins[i][j] = mins[i-1][j-1];
            else
                mins[i][j] = min(mins[i-1][j], mins[i][j-1], mins[i-1][j-1]) + 1;
        }
    return mins[len1][len2];
}
