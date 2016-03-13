/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-13 10:28
Description : Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
Source      : https://leetcode.com/problems/word-break/
*******************************************/
#include <cstdbool.h>
#define MIN(a, b) ((a) < (b) ? (a) : (b))
//TLE
//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
//Using naive DFS will result in this case, try to record the status information;

//AC - BFS - 0ms
bool wordBreak0(char* s, char** dict, int size)
{
    int min=INT_MAX, max=0; //compare only in a limited range of length of the substring actually;
    int* lens = (int*)malloc(sizeof(int)*size); //used to compare substring with words;
    int lSize = 0;
    for(int i = 0; i < size; i++)
    {
        int len = strlen(dict[i]);
        lens[lSize++] = len;
        if(len < min) min = len;
        if(len > max) max = len;
    }
    int len = strlen(s);
    bool* visited = (bool*)malloc(sizeof(bool)*len); //used to record whether the index visited or not;
    memset(visited, 0, len*sizeof(bool));
    int* queue = (int*)malloc(sizeof(int)*len*100); //avoid parallel stacks' interdenpendency;
    int begin=0, end=-1;
    queue[++end] = 0;
    while(end-begin > -1)
    {
        int start = queue[begin++]; 
        if(!visited[start]) //unvisited so far;
        {
            visited[start] = true; //label it as visited;
            for(int j = min; j <= MIN(max, len-start); j++) //check different length of substringfrom the start index;
            {
                int i = 0;
                for(; i < size; i++)
                    if(lens[i]==j && strncmp(dict[i], s+start, j)==0)
                        break;
                if(i != size)
                {
                    int next = start+j;
                    queue[++end] = next;
                    if(next == len)
                        return true;
                }
            }
        }
    }
    return false;
}

//AC - DFS - 0ms;
bool wordBreak(char* s, char** dict, int size)
{
    int min=INT_MAX, max=0; //compare only in a limited range of length of the substring actually;
    int* lens = (int*)malloc(sizeof(int)*size); //used to compare substring with words;
    int lSize = 0;
    for(int i = 0; i < size; i++)
    {
        int len = strlen(dict[i]);
        lens[lSize++] = len;
        if(len < min) min = len;
        if(len > max) max = len;
    }
    int len = strlen(s);
    bool* visited = (bool*)malloc(sizeof(bool)*len); //used to record whether the index visited or not;
    memset(visited, 0, len*sizeof(bool));
    int* stack = (int*)malloc(sizeof(int)*len*100); //avoid parallel stacks' interdenpendency;
    int top = -1;
    stack[++top] = 0;
    while(top > -1)
    {
        int start = stack[top--]; 
        if(!visited[start]) //unvisited so far;
        {
            visited[start] = true; //label it as visited;
            for(int j = min; j <= MIN(max, len-start); j++) //check different length of substringfrom the start index;
            {
                int i = 0;
                for(; i < size; i++)
                    if(lens[i]==j && strncmp(dict[i], s+start, j)==0)
                        break;
                if(i != size)
                {
                    int next = start+j;
                    stack[++top] = next;
                    if(next == len)
                        return true;
                }
            }
        }
    }
    return false;
}
