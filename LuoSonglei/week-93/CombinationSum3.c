/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-25 20:26
Description : 

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]


Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

Source      : https://leetcode.com/problems/combination-sum-iii/
*******************************************/
#include <stdlib.h>
#include <stdio.h>
void traverse(int* nums, int size, int start, int k, int target, int* stack, int top, int*** arr, int** colSizes, int* returnSize)
{
    if(top+1 == k) //there are k elements in stack already;
    {
        if(target==0) //check whether the stack should be collected as a valid result;
        {
            *returnSize += 1;
            *colSizes = (int*)realloc(*colSizes, sizeof(int)*(*returnSize));
            (*colSizes)[*returnSize-1] = k;
            *arr = (int**)realloc(*arr, sizeof(int*)*(*returnSize));
            (*arr)[*returnSize-1] = (int*)malloc(sizeof(int)*k);
            for(int i = 0; i < k; i++)
                (*arr)[*returnSize-1][i] = stack[i];
        }
        return ;
    }
    for(int i = start; i < size; i++)
    {
        if(nums[i] > target) return ; //pruning, since it's already bigger than the target, no need to move to the next round;
        stack[top+1] = nums[i]; //collect the number if it's still less or equal to the target;
        traverse(nums, size, i+1, k, target-nums[i], stack, top+1, arr, colSizes, returnSize);
    }
}
int** combinationSum3(int k, int target, int** colSizes, int* returnSize)
{
    int nums[] = {1,2,3,4,5,6,7,8,9};
    int size = sizeof(nums)/sizeof(int);
    int** arr = (int**)malloc(sizeof(int*));
    *returnSize = 0;
    *colSizes = (int*)malloc(sizeof(int));
    int *stack = (int*)malloc(sizeof(int)*k);
    int top = -1;
    for(int i = 0; i < size; i++)
    {
        if(nums[i] > target) break; //pruning, since it's already bigger than the target, no need to move to the next round;
        stack[top+1] = nums[i];
        traverse(nums, size, i+1, k, target-nums[i], stack, top+1, &arr, colSizes, returnSize);
    }
    return arr;
}

int main()
{
    int k = 6;
    int target = 30;
    scanf("%d", &target);
    printf("target: %d\n", target);
    int *colSizes;
    int size;
    int **arr = combinationSum3(k, target, &colSizes, &size); 
    for(int i = 0;  i < size; i++)
    {
        for(int j = 0; j < k; j++)
            printf("%d\t", arr[i][j]);
        printf("\n");
    }
    return 0;
}
