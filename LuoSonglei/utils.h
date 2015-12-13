/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-02 21:27
Description: assistant file for easier testing;
Source: 
*******************************************/
#ifndef UTILS_H
#define UTILS_H
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#include<math.h>
#include<stdbool.h>

#define SIZE 200
#define MAX 1000

#define minP(pa, pb) (*(pa) > *(pb) ? (pb) : (pa))
#define maxP(pa, pb) (*(pa) > *(pb) ? (pa) : (pb))
#define min(a, b) (a) < (b) ? (a) : (b)
#define max(a, b) (a) > (b) ? (a) : (b)

extern int STACK[SIZE];
extern int INDEX;
int aux[SIZE];

void stackInit();
int pop();
void push(int l, int r);
bool isEmpty();

void randomIntArray(int* array, int size, int low, int high);
void printArray(int *nums, int size);
void swap(int*p, int*q);
void checkAscending(int *nums, int size);

void shakerSort(int * nums, int size);
void selectionSort(int *nums, int size);
void bubbleSort0(int * nums, int size);
void bubbleSort1(int * nums, int size);
void insertionSort(int* nums, int l, int r);
void insertionSort0(int* nums, int size);
void insertionSort1(int* nums, int size);
void insertionSort2(int* nums, int size);
void insertionSort3(int* nums, int size);
void shellSort0(int *nums, int size);
void shellSort1(int *nums, int size);
void keySort(int *nums, int size, int keySize);

void merge(int *a, int l, int m, int r);
void mergeAB(int *a, int *aux, int l, int m, int r);
#endif
