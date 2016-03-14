/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-04 08:23
Description: Used to assist others for testing;
Source: 
*******************************************/
//this file is used to test some C features;
#include"utils.h"
void sort(int *nums, int numsSize)
{
    int m = 1;
    int tmp = 0;
    int v = 0;
    int closestSum = nums[0] + nums[1] + nums[2];
    for(;m < numsSize; m = 3*m + 1);
    for(; m > 0; m /= 3)
    for(int i = m; i < numsSize; i++)
    {
        int j = i;
        v = nums[i];
        while(j >= m && v < nums[j - m])
            {
                tmp = nums[j];
                nums[j] = nums[j-m];
                nums[j-m] = tmp; 
                j -= m;
            }
        nums[j] = v;
    }   
}
void sort1(int *nums, int numsSize)
{
    int h = 1;
    for(; h <= numsSize/9; h = 3 * h + 1);
    for(; h > 0; h /= 3)
    for(int i = h; i < numsSize; i++)
    {
        int tmp = nums[i];
        int j = i;
        while(j >= h && tmp < nums[j - h])//This condition is quite critical;
        {
            nums[j] = nums[j - h];
            j -= h;
        }
        nums[j] = tmp;
    }

}
void main()
{
    /*int numbers[SIZE];*/
    /*randomIntArray(numbers, SIZE, 0, MAX);*/
    /*printArray(numbers, SIZE);*/
    /*checkAscending(numbers, SIZE);*/
    /*printf("After sorting:\n***********************\n");*/
    /*sort(numbers, SIZE);*/
    /*printArray(numbers, SIZE);*/
    /*checkAscending(numbers, SIZE);*/
    /*char s[80];*/
    /*sprintf(s, "%d->%d", 2, 3);*/
    /*printf("length: %d\n",strlen(s));*/
    int a = 1;
    for(int i = 0; i <= 32; i++)
    {
        printf("%d,", a);
        a *= 2;
        if(i % 10 == 0)
            printf("\n");
    }
}
