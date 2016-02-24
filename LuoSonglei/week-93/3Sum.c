/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-23 16:36
Description : 
Source      : https://leetcode.com/problems/3sum/
*******************************************/
void sort(int* nums, int begin, int end)
{
    int l=begin, r=end;
    int v = nums[begin+(end-begin)/2];
    while(l <= r)
    {
        while(nums[l] < v) l++;
        while(nums[r] > v) r--;
        if(l <= r)
        {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++; r--;
        }
    }
    if(r > begin)
        sort(nums, begin, r);
    if(l < end)
        sort(nums, l, end);
}

//AC - 24ms;
int** threeSum(int* nums, int size, int* returnSize)
{
    sort(nums, 0, size-1);
    int left, right;
    int** arr = (int**)malloc(sizeof(int*));
    *returnSize = 0;
    for(int i = 0; i < size-2; i++)
    {
        while(i<size-2 && i>0 && nums[i]==nums[i-1]) i++;
        left = i+1;
        right = size-1;
        int sum = -nums[i];
        while(left < right)
        {
            int t = nums[left]+nums[right];
            if(t > sum) right--;
            else if(t < sum) left++;
            else
            {
                if(!*returnSize || (*returnSize && (nums[i]!=arr[*returnSize-1][0] ||
                                nums[left]!=arr[*returnSize-1][1])))
                {
                    *returnSize += 1;
                    arr = (int**)realloc(arr, sizeof(int*)*(*returnSize));
                    arr[*returnSize-1] = (int*)malloc(sizeof(int)*3);
                    arr[*returnSize-1][0] = nums[i];
                    arr[*returnSize-1][1] = nums[left];
                    arr[*returnSize-1][2] = nums[right];
                }
                left++;
            }
        }
    }
    return arr;
}
