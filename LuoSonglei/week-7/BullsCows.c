/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-14 08:01
Description : 
Source      : https://leetcode.com/problems/bulls-and-cows/
*******************************************/
#define FOO
#define LEN 1000
char* int2Str(int a, int* size)
{
    char* s = (char*)malloc(sizeof(char)*LEN);
    char t[LEN];
    int index = 0;
    if(a == 0)
        t[index++] = '0';
    while(a)
    {
        t[index++] = a%10 + '0';
        a /= 10;
    }
    for(int i = 0; i < index; i++)
    {
        s[index-i-1] = t[i];
    }
    s[index] = '\0';
    *size = index;
    return s;
}

//AC - 0ms;
char* getHint(char* secret, char* guess)
{
    int map[10] = {0};
    char* p = secret;
    while(*p)
        map[*(p++)-'0']++;
    #ifdef FOO
        for(int i = 0; i < 10; i++)
            printf("map[%d]: %d\n", i, map[i]);
    #endif
    int bulls = 0, cows = 0;
    p = secret;
    char *q = guess;
    while(*p)
    {
        int key = *q - '0';
        if(*p == *q)
        {
            map[key]--;
            bulls++;
        }
        p++, q++; 
    }
    p = secret;
    while(*p)
    {
        int key = *guess -'0';
        if(*p != *guess && map[key] > 0)
        {
            cows++;
            map[key]--;
        }
        guess++, p++;
    }
    #ifdef FOO
        printf("bulls: %d\tcows: %d\n", bulls, cows);
    #endif
    int bSize, cSize;
    char *bullStr = int2Str(bulls, &bSize), *cowStr = int2Str(cows, &cSize);
    #ifdef FOO
        printf("bullsStr: %s\tcowsStr: %s\n", bullStr, cowStr);
    #endif
    char res[LEN] = "";
    strcat(res, bullStr);
    res[bSize] = 'A';
    res[bSize+1] = '\0';
    strcat(res, cowStr);
    res[bSize+cSize+1] = 'B';
    res[bSize+cSize+2] = '\0';
    #ifdef FOO
        printf("result: %s\n", res);
    #endif
    return res;
}
