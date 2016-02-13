/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-13 16:35
Description : 
Source      : https://leetcode.com/problems/decode-ways/
*******************************************/
int isValid(char a, char b)
{
    return a=='1' || (a=='2' && b<'7');
}

//AC - 0ms;
int numDecodings(char* s)
{
    int len = strlen(s);
    if(len == 0 || s[0] == '0') return 0;
    if(len == 1) return 1;
    int t, f1 = 1, f2 = 1;
    for(int i = 1; i < len; i++)
    {
        if(s[i]!='0' && isValid(s[i-1], s[i])) t = f1+f2;
        if(s[i]!='0' && !isValid(s[i-1], s[i])) t = f2;
        if(s[i]=='0' && isValid(s[i-1], s[i])) t = f1;
        if(s[i]=='0' && !isValid(s[i-1], s[i])) return 0;
        f1=f2;
        f2=t;
    }
    return t;
}
