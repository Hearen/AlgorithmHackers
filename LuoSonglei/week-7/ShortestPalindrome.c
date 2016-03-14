/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-18 11:09
Description : 
Source      : https://leetcode.com/problems/shortest-palindrome/
*******************************************/
int findCenter(char*s, int size)
{
    int center = 0;
    for(int i = 0; i <= size/2; i++)
    {
        int l = i, r = i; 
        while(s[l] == s[r])
        {
            l--, r++;
            if(l < 0)
                break;
        }
        if(l == -1)
            center = i;
    }
    return center;
}
char* shortestPalindrome(char* s)
{
    int len = strlen(s);
    int center = findCenter(s, len);
    int size = (len-center)*2;
    char* str = (char*)malloc(sizeof(char)*size);
    int l = center, r = center;
    int index = 0;
    for(int i = len-1; i >= center; i--)
        str[index++] = s[i];
    for(int i = center+1; i < len; i++)
        str[index++] = s[i];
    str[index] = '\0';
    printf("center: %d\tstr: %s\n", center, str);
    return str;
}
