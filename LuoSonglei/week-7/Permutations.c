/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-13 20:07
Description : 
Source      : https://leetcode.com/problems/permutations/
*******************************************/
void swap(int* p, int* q)
{
    int t = *p;
    *p = *q;
    *q = t;
}
void search(int* nums, int size, int** list, int* returnSize, int begin, int end)
{
    if(begin == end)
    {
        list[*returnSize] = (int*)malloc(sizeof(size));
        for(int i = 0; i < size; i++)
            list[*returnSize][i] = nums[i];
        (*returnSize)++;
        return;
    }
    for(int i = begin; i <= end; i++)
    {
        swap(nums+begin, nums+i);
        search(nums, size, list, returnSize, begin+1, end);
        swap(nums+begin, nums+i);
    }
}

//AC - 4ms;
int** permute(int* nums, int size, int* returnSize)
{
    *returnSize = 0;
    int count = 1;
    for(int i = 1; i <= size; i++)
        count *= i;
    int** list = (int**)malloc(sizeof(int*)*count);
    search(nums, size, list, returnSize, 0, size-1);
    return list;
}
