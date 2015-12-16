/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-16 21:01
Description : 
Source      : https://leetcode.com/problems/zigzag-conversion/
*******************************************/

char* convert(char* s, int num)
{
    int size = strlen(s);
    char* col = (char*)malloc(sizeof(char) * (size+1));
    int cIndex = 0;
    int sIndex = 0;
    int mid = num / 2;
    int d = 0;
    for(int i = 0; i < num; i++)
    {
        d = num + 1;
        if(i == mid)
            d /= 2;
        sIndex = i;
        while(sIndex < size)
        {
            col[cIndex++] = s[sIndex];
            sIndex += d;
        }
    }
    col[cIndex] = '\0';
    return col;
}
