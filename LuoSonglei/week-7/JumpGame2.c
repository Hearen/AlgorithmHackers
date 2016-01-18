/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-18 09:25
Description : 
Source      : https://leetcode.com/problems/jump-game-ii/
*******************************************/
//AC - 8ms;
int jump(int* nums, int size)
{
    if(size <= 1)
        return 0;
    int jump = 0;
    for(int i = 0; i < size; i++)
    {
        if(i+nums[i] >= size-1)
            return ++jump;
        int max = 0, next = 0;
        for(int j = 1; j <= nums[i]; j++)
        {
            if(j+nums[i+j] > max)
            {
                max = j+nums[i+j];
                next = j;
            }
        }
        i += next-1;
        jump++;
    }
}
