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
void combination(int* nums, int numsSize, int** columnSizes, int* returnSize, int **allSets, int index, int setIndex)
{
    if(index == numsSize)
    {
        *columnSizes[*returnSize] = setIndex;
        return;
    }
    for(int i = 0; i < *returnSize; i++)
    {
        if(i < *returnSize/2)
        {
            combination(nums, numsSize, columnSizes, *returnSize/2, allSets, index + 1, setIndex + 1);
            allSets[i] = nums[index];
        }
        else
        {
            combination(nums, numsSize, columnSizes, *returnSize/2, allSets, index + 1, setIndex);
        }
    }
}
int **subsets(int* nums, int numsSize, int** columnSizes, int* returnSize)
{
    int total = 1;
    int count = 0;
    while(count < numsSize)
    {
        total *= 2;
        count++;
    }
    columnSizes = (int*)malloc(sizeof(int*) * total);
    *returnSize = total;
    int **allSets = (int*)malloc(sizeof(int*) * total);
    for(int i = 0; i < total; i++)
        allSets[i] = (int*)malloc(sizeof(int) * numsSize);
    combination(nums, numsSize, columnSizes, returnSize, allSets, 0, 0);
    return allSets;
}
