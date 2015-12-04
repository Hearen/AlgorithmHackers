/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-03 09:02
Description: 
Source: https://leetcode.com/problems/summary-ranges/
*******************************************/
#include <stdlib.h>
#include<string.h>
#include <stdio.h>
//when dealing with malloc, be careful its range;
//returnSize here is used to store the array length;
char** summaryRanges(int * nums, int numsSize, int* returnSize)
{
    char **sArray = (char**)malloc(numsSize * sizeof(char*));
    int l = 0;
    int h = 0;
    int index = 0;
    char s[100];
    int unitSize = 0;
    for(int i = 1; i < numsSize; i++)
    {
        if(nums[i] - nums[h] == 1)
        {
            h = i;
        }
        else
        {
            if(h == l)
                sprintf(s, "%d", nums[h]);   
            else
            {
                sprintf(s, "%d->%d", nums[l], nums[h]);
            }
            l = i;
            h = i;
            sArray[index] = (char*)malloc((strlen(s) + 1)* sizeof(char));
            strcpy(sArray[index], s); 
            index++;
        }
    }
    //in case of empty array disturbing the final result;
    //the last range cannot be collected in previous loop;
    if(numsSize > 0)
    {
        //handle the last range;
        if(h == l)
            sprintf(s, "%d", nums[h]);   
        else
            sprintf(s, "%d->%d", nums[l], nums[h]);
        sArray[index] = (char*)malloc(unitSize * sizeof(char));
        strcpy(sArray[index++], s); 
    }
    //collect result;
    *returnSize = index;
    char** tmp = (char**)malloc(*returnSize * sizeof(char*));
    for(int i = 0; i < *returnSize; i++)
    {
        tmp[i] = (char*)malloc(sizeof(char) * (strlen(sArray[i]) + 1));
        strcpy(tmp[i], sArray[i]);
    }
    free(sArray);
    return tmp;
}


int main(int argc, char *argv[])
{
    int nums[] = {-2147483648,-2147483647,2147483647};
    //[], [0,1,2,4,5,7], [2]
    int *resultSize;
    char** ss = summaryRanges(nums, sizeof(nums) / sizeof(int), resultSize);
    int size = *resultSize;
    for(int i = 0; i < size; i++)
    {
        printf("%s\n", ss[i]);
    }
    return 0;
}
