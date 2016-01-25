/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-20 08:21
Description : 
Source      : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*******************************************/
//AC - 16ms;
int removeDuplicates0(int* nums, int size)
{
    if(size == 0)
        return 0;
    int pre = 0, cur = 1;
    for(; cur < size; cur++)
        if(nums[cur] != nums[pre])
            nums[++pre] = nums[cur];
    return pre+1;
}

//AC - 12ms;
int removeDuplicates1(int* nums, int size)
{
    if(size == 0)
        return 0;
    int pre = 0;
    for(int cur = 1; cur < size; cur++)
        if(nums[cur] != nums[pre])
            nums[++pre] = nums[cur];
    return pre+1;
}
