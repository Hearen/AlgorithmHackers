/*
 *Author: LHearen 
 *E-mail: LHearen@126.com 
 *Time: Wed Dec  2 13:34:56 CST 2015
 *Source: https://leetcode.com/problems/two-sum/
 */
int * twoSum(int *nums, int numsSize, int target)
{
    int *indexes = (int*)malloc(sizeof(int) * 2);
    int *a = (int*)malloc(sizeof(int) * numsSize);
    for(int i = 0; i < numsSize; i++)
        a[i] = i+1;
    int i, j, v, m = 1;
    int av = 0;
    for(; m < numsSize / 9; m = 3*m + 1);
    for(; m > 0; m /= 3)
        for(i = m; i < numsSize; i++)
        {
            v = nums[i];
            av = a[i];
            j = i;
            while(j >= m && nums[j - m] > v)
            {
                nums[j] = nums[j - m];
                a[j] = a[j - m];
                j -= m;
            }
            nums[j] = v;
            a[j] = av;
        }

    i = 0;
    j = numsSize - 1;
    while(j > i)
    {
        v = nums[i] + nums[j];
        if(v > target)
            j--;
        else if(v < target)
            i++;
        else
        {
            indexes[0] = a[i];
            indexes[1] = a[j];
            return indexes;
        }
    }
}
