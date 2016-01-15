/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-15 15:46
Description : 
Source      : https://leetcode.com/problems/majority-element-ii/
*******************************************/
//AC - 8ms;
//Boyer-Moor Majority Vote Algorithm;
int* majorityElement0(int* nums, int size, int *returnSize)
{
    int count1 = 0, count2 = 0;
    int a, b;
    for(int i = 0; i < size; i++)
    {
        if(count1 == 0 || nums[i] == a)
            count1++, a = nums[i];
        else if(count2 == 0 || nums[i] == b)
            count2++, b = nums[i];
        else
            count1--, count2--;
    }
    count1 = count2 = 0;
    for(int i = 0; i < size; i++)
        if(nums[i] == a) 
            count1++;
        else if(nums[i] == b)
            count2++;
    int* res = (int*)malloc(sizeof(int)*2);
    int index = 0;
    if(count1 > size/3) 
        res[index++] = a;
    if(count2 > size/3)
        res[index++] = b;
    *returnSize = index;
    return res; 
}

//AC - 8ms;
int* majorityElement1(int* nums, int size, int *returnSize)
{
    int count1 = 0, count2 = 0;
    int a, b;
    for(int i = 0; i < size; i++)
    {
        if(nums[i] == a)
            count1++;
        else if(nums[i] == b)
            count2++;
        else 
        {
            if(count2 == 0)
                b = nums[i], count2 = 1;
            else if(count1 == 0)
                a = nums[i], count1 = 1;
            else
                count1--, count2--;
        }
    }
    count1 = count2 = 0;
    for(int i = 0; i < size; i++)
        if(nums[i] == a) 
            count1++;
        else if(nums[i] == b)
            count2++;
    int* res = (int*)malloc(sizeof(int)*2);
    int index = 0;
    if(count1 > size/3) 
        res[index++] = a;
    if(count2 > size/3)
        res[index++] = b;
    *returnSize = index;
    return res; 
}


//Generalized Boyer Moor Algorithm for 1/k;
int* majorityElement2(int* nums, int size, int* returnSize)
{
    int splitter = 2;//more than 1/3 so at most there will be 2 elements; as for 1/4 there will be at most 3 accordingly;
    int *elements = (int*)malloc(sizeof(int)*splitter);
    int *counts = (int*)malloc(sizeof(int)*splitter);
    int *res = (int*)malloc(sizeof(int)*splitter);
    for(int i = 0; i < size; i++)
    {
        int j = 0;
        for(; j < splitter; j++)
            if(elements[j] == nums[i])
            {
                counts[j]++;
                break;
            }
        if(j != splitter)
            continue;
        for(j = 0; j < splitter; j++)
            if(counts[j] == 0)
            {
                elements[j] = nums[i];
                counts[j] = 1;
                break;
            }
        if(j != splitter)
            continue;
        for(j = 0; j < splitter; j++)
            counts[j]--;
    }
    int index = 0;
    for(int i = 0; i < splitter; i++)
    {
        if(counts[i] == 0)
            continue;
        counts[i] = 0;
        for(int j = 0; j < size; j++)
            if(elements[i] == nums[j])
                counts[i]++;
        if(counts[i] > size/(splitter+1))
            res[index++] = elements[i];
    }
    *returnSize = index;
    return res;
}
