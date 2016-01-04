/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-02 20:29
Description : 
Source      : https://leetcode.com/problems/subsets-ii/
*******************************************/
#define FOO
void search(int index, int* nums, int size, int* stack, int top, int** columnSizes, int* count, int** table)
{
    #ifdef FOO
        printf("inside search index: %d\tsize: %dtop: %d\n", index, size, top);
    #endif
    if(index == size)
    {
        table[*count] = (int*)malloc(sizeof(int)*(top+1));
        #ifdef FOO
            printf("Before collecting...\n");
        #endif
        for(int i = 0; i <= top; i++)
        {
            printf("stack[%d]: %d\n", i, stack[i]);
            table[*count][i] = nums[stack[i]];
        }
        #ifdef FOO
            printf("After collecting...\n");
        #endif
        (*columnSizes)[*count] = top+1;
        #ifdef FOO
            for(int i = 0; i < (*columnSizes)[*count]; i++)
                printf("%d\n", table[*count][i]);
        #endif
        (*count)++;
        #ifdef FOO
            printf("End searching index: %d\tsize: %d\ttop: %d\tcount: %d\n", index, size, top, *count);
            printf("\n");
        #endif
        return;
    }
    #ifdef FOO
        printf("does not exist: %d in top: %d\tstack[top]: %d\n", index, top, stack[top]);
    #endif
    search(index+1, nums, size, stack, top, columnSizes, count, table);
    stack[++top] = index;
    #ifdef FOO
        printf("when it appears: %d in top: %d\tstack[top]: %d\n", index, top, stack[top]);
    #endif
    search(index+1, nums, size, stack, top, columnSizes, count, table);
}

int** subsetsWithDup(int* nums, int size, int** columnSizes, int* returnSize)
{
    int i, min = 0;
    for(i = 0; i < size; i++)
        if(nums[i] < nums[min])
            min = i;
    int t = nums[min];
    nums[min] = nums[0];
    nums[0] = t;
    for(i = 1; i < size; i++)
    {
        t = nums[i];
        int j = i;
        while(t < nums[j-1])
        {
            nums[j] = nums[--j];
        }
        nums[j] = t;
    }
    #ifdef FOO0
        for(i = 0; i < size; i++)
            printf("%d\n", nums[i]);
    #endif
    *columnSizes = (int*)malloc(sizeof(int) * (*returnSize));
    int** table = (int**)malloc(sizeof(int*) * (*returnSize));
    int* stack = (int*)malloc(sizeof(int)*(*returnSize));
    int top = -1;
    search(0, nums, size, stack, top, columnSizes, returnSize, table);
    return table;
}
