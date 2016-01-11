/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-11 08:54
Description : 
Source      : https://leetcode.com/problems/count-of-smaller-numbers-after-self/
*******************************************/
//Time Limit Exceeded; 
int* countSmaller(int* nums, int size, int* returnSize)
{
    int* counts = (int*)malloc(sizeof(int)*size);
    *returnSize = size;
    for(int i = 0; i < size; i++)
        counts[i] = 0;
    for(int i = size-2; i > -1; i--)
    {
        int cur = i;
        for(int j = i+1; j < size; j++)
        {
            if(nums[cur] > nums[j])
            {
                counts[cur]++;
                if(nums[j] > 0)
                {
                    counts[cur] += counts[j];
                    break;
                }
            }
        }
    }
    return counts;
}
