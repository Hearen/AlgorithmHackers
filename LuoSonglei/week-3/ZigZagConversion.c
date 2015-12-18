/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-16 21:01
Description : 
Source      : https://leetcode.com/problems/zigzag-conversion/
*******************************************/

char* convert(char* s, int num)
{
    if(num == 1)
        return s;
    int size = strlen(s) + 1;
    char* col = (char*)malloc(sizeof(char)*size);
    int d0 = num * 2 - 2;
    int index = 0;
    for(int i = 0; i < num; i++)
    {
        int d = d0 - i * 2; //get the first distance;
        for(int j = i; j < size - 1;)
        {
            if(d > 0)
            {
                col[index++] = *(s+j);
                j += d; //move to the next character;
            }
            d = d0 - d; //get the next complementary distance;  
        }
    }
    col[index] = '\0';
    return col;
}
