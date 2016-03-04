/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-04 14:00
Description : Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
Source      : https://leetcode.com/problems/bitwise-and-of-numbers-range/
*******************************************/
int rangeBitwiseAnd(int m, int n)
{
    int count = 0;
    while(m != n)
    {
        m >>= 1;
        n >>= 1;
        count++;
    }
    return m << count;
}
