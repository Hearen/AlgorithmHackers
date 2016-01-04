/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-04 08:01
Description : 
Source      : https://leetcode.com/problems/sort-colors/
*******************************************/
#define FOO
void swap(int* p, int* q)
{
    int t = *p;
    *p = *q;
    *q = t;
}

//AC - 0ms;
void sortColors(int* nums, int size)
{
    int p, l, r, q;
    p = l = 0, q = r = size-1;
    while(l <= r)
    {
        while(l < size && nums[l] == 0) l++;
        while(r > -1 && nums[r] == 2) r--;
        if(l < size && nums[l] == 1 && l <= q)
            swap(nums+(l++), nums+(p++)); 
        if(r > -1 && nums[r] == 1 && r >= p)
            swap(nums+(r--), nums+(q--));
        else if(l <= r && nums[r] == 0 && nums[l] == 2)
        {
            swap(nums+r, nums+l);
            r--, l++;
        }
    }
    #ifdef FOO
        for(int i = 0; i < size; i++)
            printf("%d\t", nums[i]);
        printf("\n");
        printf("l: %d\tr: %d\n", l, r);
    #endif
    nums[p] == 1? p : p--;
    nums[q] == 1? q : q++;
    while(l > -1 && p > -1)
        swap(nums+l--, nums+p--);
    while(r < size && q < size)
        swap(nums+r++, nums+q++);
}

void sort(int* nums, int l, int r)
{
    int i = l, j = r;
    int mid = nums[(i+j)>>1];
    while(i <= j)
    {
        mid = (i+j)>>1; 
        while(nums[i] < mid) i++;
        while(nums[j] > mid) j--;
        if(i <= j)
        {
            swap(nums+i, nums+j);
            i++, j--;
        }
    }
    if(l < j)
        sort(nums, l, j);
    if(i < r)
        sort(nums, i, r);
}
//AC - 0ms;
void sortColors1(int* nums, int size)
{
   sort(nums, 0, size-1); 
}
