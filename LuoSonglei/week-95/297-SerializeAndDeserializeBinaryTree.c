/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-11 15:06
Description : Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

1
/ \
2   3
    / \
    4   5
                  as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


Source      : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
*******************************************/
#include <stdlib.h>
#define LEN 10000
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
};

char* serialize(struct TreeNode* root)
{
    if(!root) return "X,";
    char *t = (char*)malloc(sizeof(char)*LEN);
    int size = 0;
    int val = root->val;
    while(val) //collect the string and convert it number in reverse order;
    {
        t[size++] = val%10 + '0';
        val /= 10;
    }
    for(int i = 0; i < size/2; i++) //since it's reversed, then reverse it again to make it normal;
    {
        char c = t[size-i-1]; t[size-i-1]=t[i]; t[i]=c;
    }
    t[size++] = ','; //add splitter;
    t[size] = '\0'; //terminate the string;
    char *left = serialize(root->left); //collect left and right children;
    char *right = serialize(root->right);
    int leftSize = strlen(left);
    int rightSize = strlen(right);
    t = (char*)realloc(t, sizeof(char)*(size+leftSize+rightSize+2));
    strcat(t, left);
    strcat(t, right);
    return  t;
}

char** split(char* s, int* size) //split a string by ',';
{
    char** arr = (char**)malloc(sizeof(char*));
    *size = 0;
    char* t = (char*)malloc(sizeof(char)*30);
    int index = 0;
    for(int i = 0; s[i]; i++)
    {
        if(s[i] != ',')
            t[index++] = s[i];
        else
        {
            t[index] = '\0';
            *size += 1;
            arr = (char**)realloc(arr, sizeof(char*)*(*size));
            arr[*size-1] = t;
            t = (char*)malloc(sizeof(char)*30);
            index = 0;
        }
    }
    return arr;
}

struct TreeNode* helper0(char*** arr) //using the pointer of the array to move it for recursion;
{
    if(strcmp(**arr, "X") == 0) return NULL;
    int num = 0;
    for(int i = 0; (**arr)[i]; i++)
        num = 10*num + (**arr)[i]-'0';
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->val = num;
    *arr += 1; //move to skip the current number;
    root->left = helper(arr);
    *arr += 1; //skip the left number;
    root->right = helper(arr);
    return root;
}
struct TreeNode* deserialize0(char *s)
{
    int size = 0;
    char** arr = split(s, &size);
    return helper(&arr);
}

struct TreeNode* helper(char** s)
{
    if(**s == 'X') return NULL; 
    int num = 0;
    int count = 0;
    while(**s != ',') //collect number and meantime skip the current number;
        num = 10*num + *((*s)++) - '0';
    *s += 1; //skip the comma ',';
    struct TreeNode *root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->val = num;
    root->left = helper(s);
    while((*(*s)++) != ','); //skip the left value;
    root->right = helper(s);
    retrn root;
}

struct TreeNode* deserialize(char* s)
{
    return helper(&s);
}
