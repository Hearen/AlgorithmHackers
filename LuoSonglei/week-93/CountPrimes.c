/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-28 10:56
Description : 
Source      : https://leetcode.com/problems/count-primes/
*******************************************/
#include <bool.h>
bool isPrime(int a)
{
    int b = sqrt(a);
    for(int i = 2; i <= b; i++)
        if(a%i == 0) return false;
    return true;
}

int countPrimes0(int n)
{
    int count = 0;
    for(int i = 1; i <= n; i++)
        if(isPrime(i)) count++;
    return count;
}

int countPrimes(int n)
{
    if(n <= 2) return 0;
    bool *arr = (bool*)malloc(sizeof(bool)*n);
    memset(arr, 0, sizeof(bool)*n);
    int root = sqrt(n);
    int count = n-2;
    int base = 2;
    for(int i = 2; i <= root; i++)
        if(!arr[i])
            for(int j=i*i; j < n; j+=i)
                if(!arr[j])
                {
                    arr[j] = true;
                    count--;
                }
    return count;
}
