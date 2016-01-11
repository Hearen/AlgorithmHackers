/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-02 20:29
Description : 
Source      : https://leetcode.com/problems/subsets-ii/
*******************************************/
#define FOO
void search0(int index, int* nums, int size, int* stack, int top, int** columnSizes, int* count, int** table)
{
    #ifdef FOO
        printf("inside search index: %d\tsize: %dtop: %d\n", index, size, top);
    #endif
    if(index == size)
    {
        #ifdef FOO
            printf("Before allocating for table[*count] count: %d\sizee of table: %d\n", *count, sizeof(table)/sizeof(int*));
        #endif
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

int** subsetsWithDup0(int* nums, int size, int** columnSizes, int* returnSize)
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
    *returnSize = 1;
    for(int i = 0; i < size; i++)
        *returnSize *= 2;
    #ifdef FOO
        printf("returnSize: %d\n", *returnSize);
    #endif
    *columnSizes = (int*)malloc(sizeof(int) * (*returnSize));
    int** table = (int**)malloc(sizeof(int*) * (*returnSize));
    int* stack = (int*)malloc(sizeof(int)*(*returnSize));
    int top = -1;
    int* count = 0;
    search(0, nums, size, stack, top, columnSizes, count, table);
    return table;
}

void search(int* nums, int size, int begin, int* stack, int top, int** columnSizes, int* count, int** table)
{
    if(begin != 0 && top == -1)
        return;
    (*columnSizes)[*count] = top+1;
    table[*count] = (int*)malloc(sizeof(int)*(top+1));
    for(int i = 0; i <= top; i++)
        table[*count][i] = stack[i];
    (*count)++;
    for(int i = begin; i < size; i++)
    {
        if(i == begin || nums[i] != nums[i-1])
        {
            stack[++top] = nums[i];
            search(nums, size, i+1, stack, top, columnSizes, count, table);
            top--;
        }
    }
}

//AC - 4ms;
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
    *returnSize = 1;
    for(int i = 0; i < size; i++)
        *returnSize *= 2;
    *columnSizes = (int*)malloc(sizeof(int)*(*returnSize));
    int** table = (int**)malloc(sizeof(int*)*(*returnSize));
    int* stack = (int*)malloc(sizeof(int)*size);
    int top = -1;
    int tmp = 0;
    int* count = &tmp;
    search(nums, size, 0, stack, top, columnSizes, count, table);
    *returnSize = *count;
    return table;
}
