/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-04 09:05
Description: 
Source: https://leetcode.com/problems/subsets/
*******************************************/
//*returnSize will be halfed after each iteration;
//index is used to follow the position in nums;
//setIndex is used to follow the position in allSets;
#include <stdio.h>
#include<stdlib.h>
#define TEST
void combination(int* nums, int numsSize, int* columnSizes, int baseIndex, int returnSize, int **allSets, int index, int setIndex)
{
    #ifdef TEST
        printf("numsIndex: %d\t setIndex: %d\n", index, setIndex);
        printf("columnSizes %d:\t%d\n",columnSizes[returnSize]);
    #endif
    if(index == numsSize)
    {
        return;
    }
    
    #ifdef TEST
        printf("returnSize: %d\n", returnSize);
    #endif
    for(int i = 0; i < returnSize; i++)
    {
        if(i < returnSize/2)
        {
            *allSets[i] = nums[index];
            #ifdef TEST
                printf("allSets %d:\t%d\n", *allSets[i], i);
                printf("setIndex: %d\n",setIndex);
            #endif
            columnSizes[baseIndex + i] = setIndex;
            combination(nums, numsSize, columnSizes, baseIndex + returnSize/2, returnSize/2, allSets, index + 1, setIndex + 1);
        }
        else
        {
            combination(nums, numsSize, columnSizes, baseIndex, returnSize/2, allSets, index + 1, setIndex);
        }
    }
}
int **subsets(int* nums, int numsSize, int* columnSizes, int* returnSize)
{
    int total = 1;
    int count = 0;
    while(count < numsSize)
    {
        total *= 2;
        count++;
    }
    #ifdef TEST
        printf("%d\n", total);
    #endif
    columnSizes = (int*)malloc(sizeof(int) * total);
    *returnSize = total;
    int **allSets = (int**)malloc(sizeof(int*) * total);
    for(int i = 0; i < total; i++)
        allSets[i] = (int*)malloc(sizeof(int) * numsSize);
    combination(nums, numsSize, columnSizes, 0, *returnSize, allSets, 0, 0);
    return allSets;
}

int main(int argc, char *argv[])
{
    int nums[] = {0};
    int *columnSizes;
    int *returnSize;
    int **sets;
    sets = subsets(nums, sizeof(nums) / sizeof(int), columnSizes, returnSize);
    for(int i = 0; i < *returnSize; i++)
    {
        for(int j = 0; j < columnSizes[i]; j++)
            printf("%d\t", sets[j]);
        printf("\n");
    }
    return 0;
}
