/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-12 21:19
Description : Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
Source      : https://leetcode.com/problems/largest-number/
*******************************************/
#include <cstdbool.h>
#define LEN 20
bool compare(int a, int b) //if the string a+b is bigger then the string b+a return true;
{
    char *t0 = (char*)malloc(sizeof(char)*2*LEN);
    *t0 = '\0';
    strcat(t0,a);
    strcat(t0, b);
    char *t1 = (char*)malloc(sizeof(char)*LEN);
    *t1= '\0';
    strcat(t1, b);
    strcat(t1,a);
    return strcmp(t0, t1)>0; //using strcmp to achieve comparing operation;
}

char* toString(int a) //turn a int to a string;
{
    char* t = (char*)malloc(sizeof(char)*30);
    int index = 0;
    while(a) //collect each digit from low to high;
    {
        t[index++] = a%10+'0';
        a /= 10;
    }
    t[index] = '\0';
    for(int i = 0; i < index/2; i++) //reverse the string;
    {
        char c=t[i]; t[i]=t[index-i-1]; t[index-i-1]=c;
    }
    return t;
}

char* largestNumber(int* nums, int size)
{
    char** arrs = (char**)malloc(sizeof(char*)*size);
    for(int i = 0; i < size; i++) //turn each number to string;
    {
        if(nums[i] == 0)
            arrs[i] = "0";
        else
            arrs[i] = toString(nums[i]);
    }
    char* s = (char*)malloc(sizeof(char)*size*LEN);
    *s = '\0';
    int max;
    for(int i = 0; i < size; i++) //using selection sort to sort the number strings;
    {
        max = i;
        for(int j = i+1; j < size; j++) //find the ith biggest number string;
            if(compare(arrs[j], arrs[max]))
                max = j;
        char *t = arrs[i];
        arrs[i] = arrs[max];
        arrs[max] = t;
        if(arrs[0][0] == '0') return "0"; //if the first letter of the first number string is 0, then the result will definitely "0", just return "0";
        strcat(s, arrs[i]); //collect the string from 0 to size-1 in descending order;
    }
    return s;
}
