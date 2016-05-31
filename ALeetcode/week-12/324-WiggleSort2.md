WiggleSortII
------------
* Author: LHearen
* E-mail: LHearen@126.com
* Time  : Tue May 31 09:20:30 CST 2016
* Description: Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.
Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
* Source: https://leetcode.com/problems/wiggle-sort-ii/

### Solution

Can there any true O(n) solution of this problem?
I solved this by sorting and using another O(n) space to store the sorted elements and then rearranging them into the original array.

There are several things we should clearly find out:

in the result array, the even index position will contain smaller elements while the odd index position bigger ones;
to avoid the middle part of the sorted array meet each other too quick (for example if we rearrange them like this: the smaller in ascending order, the bigger in descending order -> in different order but filling the result array in the same direction); so we have to rearrange them in the same order to the result array;
but soon we will tumble into a dilemma by this test case [4, 5, 5, 6] in which if we rearrange them as the rules mentioned above it can be wrong;
how about starting to place them from the end of the result array? then -> 5, 6, 4, 5 should be the result (the smaller: 4, 5; the bigger: 5, 6 and place the bigger first 5 since the last index is 3, an odd index then the first 4 of the smaller and then the second of the bigger 6, and then the second of the smaller 5). Quite right! the odd and even position rule -> big : odd, small : even
Bang! End of Story!

space cost O(n)
time cost O(nlogn)


### Details in C

```
void swap(int* p, int* q)
{
    int t=*p; *p=*q; *q=t;

}

void sort(int* nums, int begin, int end)
{
    int l=begin, r=end;
    int v = nums[l+(r-l)/2];
    while(l <= r)
    {
        while(nums[l] < v) l++;
        while(nums[r] > v) r--;
        if(l <= r)
        {
            swap(nums+l, nums+r);
            l++; r--;
        
        }
    
    }
    if(begin < r)
        sort(nums, begin, r);
    if(l < end)
        sort(nums, l, end);

}

//AC - 40ms;
void wiggleSort(int* nums, int size)
{
    sort(nums, 0, size-1); //using quick sort to sort the array first;
    int *arr = (int*)malloc(sizeof(int)*size);
    for(int i = 0; i < size; i++)
        arr[i] = nums[i];
    int small= 0; //the first of smallers;
    int big = (size-1)/2+1; //the first of biggers;
    int index = size-1; //start to fill in reverse direction: from right to left;
    if(size%2 == 0) //if the size is even then the last should be indexed by odd size-1, so place the bigger one in odd position size-1;
        nums[index--] = arr[big++];
    while(index > -1)
    {
        nums[index--] = arr[small++];
        if(index > -1) //in case of "underflow";
            nums[index--] = arr[big++];
    
    }

}
```

### Feedback
There must be some better solutions to this problem, if you've got one, please never hesitate to inform me of that, so many thanks in advance!
