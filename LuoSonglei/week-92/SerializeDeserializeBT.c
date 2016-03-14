/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-19 10:11
Description : 
Source      : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
*******************************************/
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};

#include <stdlib.h>
char* toString(struct TreeNode* node)
{
    printf("inside toString\n");
    if(!node) return "-";
    int val = node->val;
    char* s = (char*)malloc(sizeof(char));
    int size = 0;
    while(val)
    {
        size++;
        s = (char*)realloc(s, sizeof(char)*(size+1));
        s[size-1] = val%10+'0';
        val /= 10;
    }
    s[size] = '\0';
    printf("s: %s\n", s);
    for(int i = 0; i < size/2; i++)
    {
        char t = s[i]; s[i] = s[size-i-1]; s[size-i-1] = t;
    }
    return s;
}

char* serialize(struct TreeNode* root)
{
    printf("inside serialize\n");
    if(!root) return NULL;
    struct TreeNode** arr = (struct TreeNode**)malloc(sizeof(struct TreeNode*)*2);
    int pre=0, index = 1;
    arr[1] = root;
    while(1)
    {
        int top = index+1;
        printf("pre: %d\tindex: %d\ttop: %d\n", pre, index, top);
        int count = 0;
        arr = (struct TreeNode**)realloc(arr, sizeof(struct TreeNode*)*2*top);
        for(int i = pre+1, pre = index; i < top; i++)
        {
            index = 2*i;
            arr[index] = NULL;
            if(arr[i]->left)
                arr[index] = arr[i]->left, count++;
            index = 2*i + 1;
            arr[index] = NULL;
            if(arr[i]->right)
                arr[index] = arr[i]->right, count++;
            printf("i: %d\tindex: %d\n", i, index);
        }
        if(!count)
        {
            index = pre;
            break;
        }
        pre = index;
    }
    printf("\n\nindex: %d\ncollecting...\n", index);
    char* s = (char*)malloc(sizeof(char));
    for(int i = 1; i <= index; i++)
    {
        char *t = toString(arr[i]);
        printf("i: %d\t%s\n", i, t);
        int len = strlen(t);
        s = (char*)realloc(s, sizeof(char)*(len+2));
        strcat(s, t);
        strcat(s, ",");
    }
    s[strlen(s)-1] = '\0';
    printf("final result: %s\n", s);
    return s;
}

int toInt(char* s)
{
    int t = 0;
    while(*s)
        t += 10*t + (*s++)-'0';
    return t;
}
struct TreeNode* deserialize(char* data)
{
    char** arr = (char**)malloc(sizeof(char*));
    int size = 1;
    int pre = 0, cur = 0;
    while(*(data+cur))
    {
        while(*(data+cur) != ',' && *(data+cur)) cur++;
        int len = cur-pre;
        cur++;
        char *t = (char*)malloc(sizeof(char)*(len+1));
        *t = '\0';
        strncpy(t, data+pre, len);
        arr = (char**)realloc(arr, sizeof(char*)*(size+1));
        arr[size] = t;
        pre = cur;
        size++;
    }
    for(int i = 1; i < size; i++)
    {

    }
}
