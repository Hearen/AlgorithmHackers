/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-29 09:30
Description : Used to achieve heap sorting, 
		this method is quicker than 
		normal methods but slower than
		quick and merge sorting;
*******************************************/
void swap(int *p, int *q)
{
    int t = *p;
    *p = *q;
    *q = t;
}

void fixUp(int* a, int k)
{
    while(k > 1 && a[k/2] < a[k])
        swap(a+k/2, a+k), k /= 2;
}

void fixDown(int* a, int size, int k)
{
    int j;
    while(2*k < size)
    {
        j = 2*k;
        if(j < size-1 && a[j] < a[j+1]) j++;//select the bigger one;
        if(a[k] >= a[j]) break;
        swap(a+k, a+j), k = j;
    }
}


void heapSort0(int* a, int size)
{
    for(int k=size/2+1; k >= 0; k--)
        fixDown(a, size, k);
    while(size > 1)
    {
        swap(a, a+size-1);
        fixDown(a, --size, 0);
    }
}

//More portable;
void headSort1(int *a, int l, int r)
{
    int size = r-l+1;
    for(int k=size/2; k >= 0; k--)
        fixDown(a+l, size, k);
    while(size > 1)
    {
        swap(a+l, a+l+size-1);
        fixDown(a+l, --size, 0);
    }
}

void main()
{
    int numbers[10000];
    int size = rand()%1000 + 200;
    randomIntArray(numbers, size, 0, 10000);
    printArray(numbers, size);
    checkAscending(numbers, size);
    printf("After sorting:\n***********************\n");
    heapSort(numbers, size);
    printArray(numbers, size);
    checkAscending(numbers, size);
}
