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

//AC - 876ms;
int countPrimes0(int n)
{
    int count = 0;
    for(int i = 1; i <= n; i++)
        if(isPrime(i)) count++;
    return count;
}

//AC - 32ms - using Sieve of Eratosthenes algorithm;
int countPrimes(int n)
{
    if(n <= 2) return 0;
    bool *arr = (bool*)malloc(sizeof(bool)*n);
    memset(arr, 0, sizeof(bool)*n);
    int root = sqrt(n);
    int count = n-2; //original start, take 4, 5 to initialize;
    int base = 2;
    for(int i = 2; i <= root; i++) //sqrt is enough since n=p*q, one of them must be smaller or equal to sqrt;
    {
        if(!arr[i]) //unset;
        {
            for(int j=i*i; j < n; j+=i) //set all its multiples within n;
            {
                if(!arr[j])
                {
                    arr[j] = true;
                    count--; //set one multiples within n, decrease the amount of primes;
                }
            }
        }
    }
    return count;
}
