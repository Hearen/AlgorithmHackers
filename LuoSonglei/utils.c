/*******************************************
    Author: LHearen
    E-mail: LHearen@126.com
    Time  :	2015-12-02 21:27
    Description: 
    Source: 
*******************************************/
#include"utils.h"

void randomIntArray(int* array, int size, int low, int high)
{
    srand(time(NULL));
    for(int i = 0; i < size; i++)
    {
        array[i] = rand()%(high-low) + low;
    }
}

void printArray(int *nums, int size)
{
    for(int i = 0; i < size; i++)
        printf("%d, ", nums[i]);
}

void swap(int*p, int*q)
{
    int tmp = *p;
    *p = *q;
    *q = tmp;
}

void checkAscending(int *nums, int size)
{
    for(int i = 0; i < size - 1; i++)
        if(nums[i] > nums[i + 1])
        {
            perror("Sorting failed!\n");
            printf("Sorting failed!\n");
            return;
        }
    perror("Sorted successfully!\n");
    printf("Sorted successfully!\n");
}


void shakerSort(int * nums, int size)
{
    bool isSorted = false;
    int index0 = 0, index1 = size - 1;
    for(int k = 0; k < size; k++)
    {
        if(k % 2 == 0)
        {
            for(int i = index0; i < index1; i++)
            {
                isSorted = true;
                for(int j = index1; j > i; j--)
                {
                    if(nums[j] < nums[j - 1])
                    {
                        isSorted = false;
                        swap(nums + j, nums + j - 1);
                    }
                }
                if(isSorted)
                    break;
            }
            index0++;
        }
        else
        {
            for(int i = index0; i < index1 - 1; i++)
            {
                isSorted = true;
                for(int j = index0; j < index1 - i; j++)
                {
                    if(nums[j] > nums[j+1])
                    {
                        isSorted = false;
                        swap(nums + j, nums + j);
                    }
                }
                if(isSorted)
                    break;
            }
            index1--;
        }
        if(isSorted)
            break;
    }
}


void bubbleSort0(int * nums, int size)
{
    for(int i = 0; i < size - 1; i++)
        for(int j = size - 1; j > i; j--)
        {
            if(nums[j] < nums[j - 1])
                swap(nums + j, nums + j - 1);
        }
}

void bubbleSort1(int * nums, int size)
{
    bool isSorted = false;
    for(int i = 0; i < size - 1; i++)
    {
        isSorted = true;
        for(int j = size - 1; j > i; j--)
        {
            if(nums[j] < nums[j - 1])
            {
                isSorted = false;
                swap(nums + j, nums + j - 1);
            }
        }
        if(isSorted)
            break;
    }
}

void selectionSort(int *nums, int size)
{
    int min, tmp;
    for(int i = 0; i < size; i++)
    {
        min = i;
        for(int j = i; j < size; j++)
        {
            if(nums[j] < nums[min])
                min = j;
        }
        tmp = nums[i]; nums[i] = nums[min]; nums[min] = tmp;
    }
}

void insertionSort(int* nums, int l, int r)
{
    //Via bubbling, you can also make the minimal in the first position;
    //All the rest elements will be less than the first;
    int min=l;
    for(int i = l; i <= r; i++)
    {
        if(nums[i] < nums[min])
            min = i;
    }
    swap(nums + l, nums + min);
    int j = 0;
    for(int i = l + 1; i <= r; i++)
    {
        int j = i - 1;
        int tmp = nums[i];
        while(nums[j] > tmp)
        {
            nums[j+1] = nums[j];
            j--;
        }
        nums[j + 1] = tmp;
    }
}
void insertionSort0(int* nums, int size)
{
    for(int i = 0; i < size - 1; i++)
    {
        for(int j = i + 1; j > 0; j--)
        {
            if(nums[j] < nums[j - 1])
                swap(nums + j, nums + j - 1);
        }
    }
}
void insertionSort1(int* nums, int size)
{
    for(int i = 0; i < size - 1; i++)
    {
        for(int j = i + 1; j > 0; j--)
        {
            if(nums[j] < nums[j - 1])
                swap(nums + j, nums + j - 1);
            else//Jump out the inner loop ASAP;
                break;
        }
    }
}

void insertionSort2(int* nums, int size)
{
    //Via bubbling, you can also make the minimal in the first position;
    //All the rest elements will be less than the first;
    int min=0;
    for(int i = 0; i < size; i++)
    {
        if(nums[i] < nums[min])
            min = i;
    }
    swap(nums, nums + min);
    int j = 0;
    for(int i = 2; i < size; i++)
    {
        int j = i - 1;
        int index = i;
        int tmp = nums[i];
        while(1)
        {
            if(nums[i] < nums[j])
                index = j--;
            else//Jump out of the loop ASAP; 
                break;
        }
        for(j = i; j > index; j--)//Less swap operations achieved;
            nums[j] = nums[j - 1];
        nums[index] = tmp;
    }
}

void insertionSort3(int* nums, int size)
{
    //Via bubbling, you can also make the minimal in the first position;
    //All the rest elements will be less than the first;
    int min=0;
    for(int i = 0; i < size; i++)
    {
        if(nums[i] < nums[min])
            min = i;
    }
    swap(nums, nums + min);
    int j = 0;
    for(int i = 2; i < size; i++)
    {
        int j = i - 1;
        int tmp = nums[i];
        while(nums[j] > tmp)
        {
            nums[j+1] = nums[j];
            j--;
        }
        nums[j + 1] = tmp;
    }
}

//The length of the step determines the performance dramatically;
void shellSort0(int *nums, int size)
{
    int h = 1;
    for(; h <= size/9; h = 3 * h + 1);
    for(; h > 0; h /= 3)
        for(int i = h; i < size; i++)
        {
            int tmp = nums[i];
            int j = i;
            for(; j >= h; j -= h)
            {
                if(tmp < nums[j - h])
                {
                    nums[j] = nums[j - h];
                }
                else
                    break;
            }
            nums[j] = tmp;
        }
}

void shellSort1(int *nums, int size)
{
    int h = 1;
    for(; h <= size/9; h = 3 * h + 1);
    for(; h > 0; h /= 3)
        for(int i = h; i < size; i++)
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

void keySort(int *nums, int size, int keySize)
{
    int *array = (int*)malloc(sizeof(int) * keySize);
    int *nums1 = (int*)malloc(sizeof(int) * size);
    for(int i = 0; i < keySize; i++) array[i] = 0;
    for(int i = 0; i < size; i++) array[nums[i]+1]++; //The distance between the current and the latter one;
    for(int i = 0; i < keySize - 1; i++) array[i + 1] += array[i];
    for(int i = 0; i < size; i++) nums1[array[nums[i]]++] = nums[i];
    for(int i = 0; i < size; i++) nums[i] = nums1[i];
}


void merge(int *a, int l, int m, int r)
{
    int i, j, k;
    for(i = m + 1; i > l; i--) aux[i - 1] = a[i - 1];
    //reverse half of the array to eliminate checking overhead;
    for(j = m; j < r; j++) aux[r + m - j] = a[j + 1];
    //make sure the last loop will render i = l & j = r;
    for(k = l; k <= r; k++)
        a[k] = aux[i] > aux[j] ? aux[j--] : aux[i++];
}

void mergeAB(int *a, int *aux, int l, int m, int r)
{
    int i = l;
    int j = m + 1;
    int k;
    for(k = l; k <= r; k++)
    {
        //make sure the last will also be considered;
        if(i > m) 
        {
            a[k] = aux[j++];
            continue;
        }
        if(j > r)
        {
            a[k] = aux[i++];
            continue;
        }
        //this statement ensures the stability of the sort;
        a[k] = aux[i] > aux[j] ? aux[j++] : aux[i++];
    }
}

