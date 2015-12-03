/*******************************************
    Author: LHearen
    E-mail: LHearen@126.com
    Time  :	2015-12-03 08:02
    Description: 
    Source: https://leetcode.com/problems/unique-paths/
*******************************************/
//Runtime Error - too huge;
long long factorial(int n)
{
    if(n == 0)
        return 1;
    long long result = 1;
    while(n > 0)
    {
        result *= n;
        n--;
    }
    return result;
}
int uniquePaths0(int m, int n)
{
    return factorial(m + n - 2) / factorial(n - 1) / factorial(m - 1);
}

//member must be long long to handle big integer;
int uniquePaths1(int m, int n)
{
    m--, n--;
    int min = m > n? n : m;
    int max = m > n? m : n;
    long long denominator = 1;
    long long member = 1;
    while(min > 0)
    {
        member *= min + max;
        denominator *= min;
        min --;
    }
    return member / denominator;
}
