/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-17 21:14
Description : 
Source      : https://leetcode.com/problems/burst-balloons/
*******************************************/
//AC - 12ms;
int maxCoins(int* nums, int size)
{
    int *nums1 = (int*)malloc(sizeof(int)*(size+2));
    nums1[0] = nums1[size+1] = 1;
    for(int i = 0; i < size; i++)
        nums1[i+1] = nums[i];
    size += 2;
    int** maxs = (int**)malloc(sizeof(int*)*size); //maxs store the max result between index i and j exclusively;
    for(int i = 0; i < size; i++)
    {
        maxs[i] = (int*)malloc(sizeof(int)*size);
        memset(maxs[i], 0, sizeof(int)*size);
    }
    for(int i = 2; i < size; i++) //start from length - 2 till length - size-1;
        for(int left = 0; left+i < size; left++)
        {
            int right = left+i;
            for(int j = left+1; j < right; j++)
            {
                int t = maxs[left][j]+maxs[j][right]+nums1[left]*nums1[right]*nums1[j];
                if(t > maxs[left][right])
                    maxs[left][right] = t;
            }
        }
    return maxs[0][size-1]; //the max between the first and last - extra 1;
}
