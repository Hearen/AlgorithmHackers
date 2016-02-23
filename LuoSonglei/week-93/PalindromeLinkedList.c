/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-23 08:46
Description : 
Source      : https://leetcode.com/problems/palindrome-linked-list/
*******************************************/
#include <stdbool.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};
//AC - 12ms;
bool isPalindrome(struct ListNode* head)
{
    int* arr = (int*)malloc(sizeof(int));
    int size = 0;
    struct ListNode* p = head;
    while(p)
    {
        size++;
        arr = (int*)realloc(arr, sizeof(int)*size);
        arr[size-1] = p->val;
        p = p->next;
    }
    for(int i = 0; i < size/2; i++)
        if(arr[i] != arr[size-i-1])
            return false;
    return true;
}

