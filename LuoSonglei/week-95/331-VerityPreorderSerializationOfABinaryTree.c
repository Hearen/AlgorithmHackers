/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-08 20:29
Description : One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
     /   \
    3     2
  / \   / \
4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
Source      : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
*******************************************/
#include <cstdbool.h>
char** split(char* s, int* size)
{
    char** arr = (char**)malloc(sizeof(char*));
    char *t = (char*)malloc(sizeof(char)*30); 
    int index = 0;
     for(int i = 0; i < strlen(s)+1; i++)
    {
       if(s[i]==',' || s[i]=='\0')
        {
            if(s[i]==',' || s[i]=='\0')
            {
                t[index] = '\0';
                *size += 1;
                arr = (char**)realloc(arr, sizeof(char*)*(*size));
                arr[*size-1] = t;
            }
            index = 0;
            t = (char*)malloc(sizeof(char)*30);
        }
        else
        {
            t[index++] = s[i];
        }
    }
    return arr;
}

//AC - 8ms;
//https://leetcode.com/discuss/83825/simple-python-solution-using-stack-with-explanation
//https://leetcode.com/discuss/84073/straight-forward-c-solution-with-explanation
bool isValidSerialization0(char* preorder)
{
    int size = 1;
    char** arr = split(preorder, &size);
    int difference = 0;
    for(int i = 1; i < size; i++)
    {
        if(strcmp(arr[i], "#") == 0) //it's null;
            difference++;
        else //it's null cannot have not-null children;
            difference--;
        if(difference>1 || (difference==1&&i!=size-1)) return false;
    }
    if(difference < 1) return false;
    return true;
}

//AC - 0ms;
bool isValidSerialization(char* preorder)
{
    int difference = 0;
    int size = strlen(preorder);
    for(int i = 1; i <= size; i++)
    {
        if(preorder[i]==',' || preorder[i]=='\0') 
        {
            if(preorder[i-1] == '#') //null;
                difference++;
            else //not null; 
                difference--;
        }
        if(difference > 1) return false; //surpass more than 1, return false directly;
        if(difference==1 && i!=size) return false; //not end of the string but it reaches difference 1 already, terminate the checking directly;
    }
    if(difference < 1) return false; //after traversing the difference should be exactly one;
    return true;
}
