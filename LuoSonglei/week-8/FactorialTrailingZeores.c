/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 09:40
Description : 
Source      : https://leetcode.com/problems/factorial-trailing-zeroes/
*******************************************/
int countFactors(int a, int b)
{
    int count = 0;
    while(a)
    {
        if(a%b == 0)
            count++;
        a /= b;
    }
    return count;
}

//Time Limit Exceeded;
//Wrong Result;
int trailingZeroes0(int n)
{
    int count2 = 0;
    int count5 = 0;
    for(int i = 1; i <= n; i++)
        count2 += countFactors(i, 2);
    for(int i = 1; i <= n; i++)
        count5 += countFactors(i, 5);
    return count2 > count5? count5 : count2;
}

//AC - 0ms;
int trailingZeroes(int n)
{
    int count = 0;
    while(n)
    {
        count += n/5;
        n /= 5;
    }
    return count;
}
