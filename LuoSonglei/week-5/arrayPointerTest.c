#include <stdio.h>
#include <stdlib.h>

void generate(int** array, int* size)
{
    *size = 4;
    *array = (int*)malloc(sizeof(int) * (*size));
    for(int i = 0; i < *size; i++)
    {
        (*array)[i] = *size * 10;
    }
}
int main(int argc, char *argv[])
{
    int* array;
    int* size;
    generate(&array, size);
    for(int i = 0; i < *size; i++)
        printf("dynamically generate array: %d\n", array[i]);
    return 0;
}
