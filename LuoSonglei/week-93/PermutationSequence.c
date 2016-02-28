/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-28 22:20
Description : 
Source      : https://leetcode.com/problems/permutation-sequence/
*******************************************/
void swap(int* p, int* q)
{
    int t = *p; *p = *q; *q = t;
}
void reverse(int* nums, int begin, int end)
{
    for(int i = begin; i < (begin+end+1)/2; i++)
        swap(nums+i, nums+end+begin-i);
}

//AC - 0ms;
char* getPermutation(int n, int k)
{
    int *nums = (int*)malloc(sizeof(int)*n);
    for(int i = 0; i < n; i++)
        nums[i] = i+1;
    k--;
    while(k)
    {
        int i=n-1, j=n-1;
        while(i>0 && nums[i]<=nums[i-1]) i--; //make sure the [i..n-1] is in descending order;
        while(nums[j] <= nums[i-1]) j--; //find the first bigger one backwards;
        swap(nums+j, nums+i-1); //ensure the next is bigger;
        reverse(nums, i, n-1); //since [i..n-1] is descending, after reverse it will be ascending and as a result - [i..n-1] will be the smallest - the smallest in the bigger results - the next permutation;
    }
    char *s = (char*)malloc(sizeof(char)*(n+1));
    for(int i = 0; i < n; i++)
        s[i] = nums[i]+'0';
    s[n] = '\0';
    return s;
}
