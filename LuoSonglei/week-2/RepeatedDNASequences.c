/*******************************************
Author: LHearen
E-mail: LHearen@126.com
Time  :	2015-12-13 21:00
Description: 
Source: https://leetcode.com/problems/repeated-dna-sequences/
*******************************************/

#include"utils.h"
#define T
bool equal(char*s0, char*s1, int len)
{
    for(int i = 0; i < len; i++)
        if(*(s0+i) != *(s1+i))
            return false;
    return true;
}
bool exists(char** ss, char* s, int size, int len)
{
    for(int i = 0; i < size; i++)
    {
        if(equal(ss[i], s, len))
        {
            return true;
        }
    }
    return false;
}

//Exceeds time limit;
char** findRepeatedDnaSequences0(char*s, int* returnSize)
{
    char s0[11] = "";
    char s1[11] = "";
    int size = 0;
    while(*(s+size) != '\0')
        size++;
    #ifdef T
        printf("Size: %d\n", size);
    #endif
    char** sArray = (char**)malloc(sizeof(char*) * size);
    for(int i = 0; i < size; i++)
        sArray[i] = (char*)malloc(11 * sizeof(char));
    int index = 0;
    for(int i = 0; *(s+i+10) != '\0'; i++)
    {
        /*strncpy(s0, s+i, 10);*/
        for(int j = i + 1; *(s+j+10) != '\0'; j++)
        {
            #ifdef T
                printf("s0:%s\n", s0);
                printf("s1:%s\n", s1);
            #endif
            //this section can be optimized further;
            /*strncpy(s1, s+j, 10);*/
            if(equal(s+i, s+j, 10))
            {
                #ifdef T0
                    printf("%s\tindex: %d\n", s0, index);
                #endif
                if(!exists(sArray, s+i, index, 10))
                   strncpy(sArray[index++], s0+i, 10);
            }
        }
    }
    *returnSize = index;
    return sArray;
}

char** findRepeatedDnaSequences(char*s, int* returnSize)
{
    int size = 0;
    while(*(s+size) != '\0')
        size++;
    if(size < 11)
        return NULL;
    char hashTable[1<<21] = {0};
    int hashNum = 0;
    int index = 0;
    char** sArray = (char**)malloc(sizeof(char*) * size);
    for(int i = 0; i < 9; i++)
        hashNum = hashNum << 2 | (*(s+i) - 'A' + 1) % 5;
    for(int i = 9; i < size; i++)
    {
        if(hashTable[hashNum = (hashNum << 2 | (*(s+i) - 'A' + 1) % 5) & 0xfffff]++ == 1)
        {
            //until it's necessary;
            sArray[i] = (char*)malloc(11 * sizeof(char));
            strncpy(sArray[index], s-9, 10);
            //end the string;
            sArray[index++][10] = '\0';
        }
    }
    *returnSize = index;
    return sArray;
}
