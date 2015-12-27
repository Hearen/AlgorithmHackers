/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-27 11:33
Description : 
Source      : https://leetcode.com/problems/find-the-duplicate-number/
*******************************************/
//AC - 8ms;
int findDuplicate0(int* nums, int size)
{
    int* s = (int*)malloc(sizeof(int)*size);
    for(int i = 0; i < size; i++)
        s[i] = 0;
    for(int i = 0; i < size; i++)
    {
        s[nums[i]]++;
        if(s[nums[i]] > 1)
            return nums[i];
    }
    return 0;
}

//AC - 4ms;
int findDuplicate1(int* nums, int size)
{
    if(size > 0)
    {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    return -1;
}
