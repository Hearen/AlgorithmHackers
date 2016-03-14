/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-27 23:19
Description : 
Source      : https://leetcode.com/problems/add-binary/
*******************************************/
#include <bool.h>
//AC - 0ms;
char* addBinary(char* a, char* b)
{
    int aLen = strlen(a);
    int bLen = strlen(b);
    int len = aLen>bLen? aLen+2 : bLen+2;
    char *s = (char*)malloc(sizeof(char*)*len);
    int index = 0;
    char c; //used to determine the result of two chars only;
    bool C = false; //bit carry indicator;
    while(aLen || bLen)
    {
        if(!aLen || !bLen) //one of them has reached its end;
            c = !aLen? b[bLen-1] : a[aLen-1];
        else //both of them have not finish;
        {
            if(a[aLen-1]=='1' && b[bLen-1]=='1')
                c = '0';
            else 
            {
                if(a[aLen-1]=='1' || b[bLen-1]=='1')
                    c = '1';
                else
                    c = '0';
            }
        }
        if((C&&c=='0') || (!C&&c=='1')) //using the carry of the previous loop to determine the exact value of the current bit;
            s[index++] = '1';
        else
            s[index++] = '0';
        if((a[aLen-1]=='1'&&b[bLen-1]=='1') || (c=='1'&&C)) //update the carry indicator for the next bit;
            C = true;
        else
            C = false;
        if(aLen) aLen--; //if it has not finished, move further forward;
        if(bLen) bLen--;
    }
    if(C) s[index++] = '1'; //check the last carry;
    for(int i = 0; i < index/2; i++) //reverse the whole result since we are recording them reversely;
    {
        char t=s[i]; s[i]=s[index-i-1]; s[index-i-1]=t;
    }
    s[index] = '\0'; //set the end character;
    return s;
}
