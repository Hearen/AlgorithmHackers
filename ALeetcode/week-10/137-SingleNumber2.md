Single Number II
----------------
* Author: LHearen
* E-mail: LHearen@126.com
* Time  : Tue May 31 09:20:30 CST 2016
* Description: Given an array of integers, every element appears three times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* Source: https://leetcode.com/problems/single-number-ii/

### Solution
Along with detailed comments in the code, no further comments will be added here.

```
//AC - 8ms;
//direct method - calculate each bit and find the single one;
int singleNumber0(int* nums, int size)
{
    int b, ret = 0;
    int len = sizeof(int)*8;
    for(int i = 0; i < len; i++)
    {
        b = 1 << i;
        int count = 0;
        for(int j = 0; j < size; j++)
            if(b & nums[j])
                count++;
        if(count%3)
            ret |= b;
    
    }
    return ret;

}
```


```
//AC - 4ms;
//inspired by logical circuit design and boolean algebra;
//counter - unit of 3;
//current   incoming  next
//a b            c    a b
//0 0            0    0 0
//0 1            0    0 1
//1 0            0    1 0
//0 0            1    0 1
//0 1            1    1 0
//1 0            1    0 0
//a = a&~b&~c + ~a&b&c;
//b = ~a&b&~c + ~a&~b&c;
//return a|b since the single number can appear once or twice;
int singleNumber(int* nums, int size)
{
    int a=0, b=0;
    for(int i = 0; i < size; i++)
    {
        int t = (~a&b&nums[i])|(a&~b&~nums[i]);
        b = (~a&~b&nums[i])|(~a&b&~nums[i]);
        a = t;
    
    }
    return a|b;

}
```

### Feedback
There must be some better solutions to this problem, if you've got one, please never hesitate to inform me of that, so many thanks in advance!

