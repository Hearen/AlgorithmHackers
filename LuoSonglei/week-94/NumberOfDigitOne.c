/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-01 16:20
Description : 
Source      : https://leetcode.com/problems/number-of-digit-one/
*******************************************/
//AC - 0ms;
//https://leetcode.com/discuss/44281/4-lines-o-log-n-c-java-python
int countDigitOne(int n)
{
    if(n < 10) return 0;
    long long count = 0;
    for(long long m = 1; m <= n; m *= 10)
    {
        long long a = n/m;
        long long b = n%m;
        count += (a+8)/10*m+(a%10==1)*(b+1);
    }
    return count;
}
