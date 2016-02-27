/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-27 10:03
Description : 
Source      : https://leetcode.com/problems/next-permutation/
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
void nextPermutation(int* nums, int size)
{
    int i=size-1, j=size-1;
    while(i>0 && nums[i]<=nums[i-1]) i--; //make sure the [i..size-1] is in descending order;
    if(i==0) //the whole array is descending now, reverse it to the smallest as problem requires;
    {
        reverse(nums, 0, size-1);
        return ;
    }
    while(nums[j] <= nums[i-1]) j--; //find the first bigger one backwards;
    swap(nums+j, nums+i-1); //ensure the next is bigger;
    reverse(nums, i, size-1); //since [i..size-1] is descending, after reverse it will be ascending and as a result - [i..size-1] will be the smallest - the smallest in the bigger results - the next permutation;
}
