/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-04 21:47
Description : There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
Source      : https://leetcode.com/problems/course-schedule-ii/
*******************************************/
#include <bool.h>
void traverse(int start, int courses, int** graph, int* colSize, int* visited, int* arr, int *returnSize)
{
    printf("start: %d\tcourses: %d\treturnSize: %d\n", start, courses, *returnSize);
    if(*returnSize == courses) return ;
    if(visited[start] == 1) return ;
    visited[start] = 1;
    arr[++(*returnSize)] = start;
    for(int i = 0; i < colSize[start]; i++)
        traverse(graph[start][i], courses, graph, colSize, visited, arr, returnSize);
    visited[start] = 0;
}

int* findOrder(int courses, int** prerequisites, int rSize, int cSize, int* returnSize)
{
    int* colSize = (int*)malloc(sizeof(int)*courses);
    memset(colSize, 0, sizeof(int)*courses);
    int** graph = (int**)malloc(sizeof(int*)*courses);
    for(int i = 0; i < courses; i++)
        graph[i] = (int*)malloc(sizeof(int)*2);
    printf("allocating for graph done\n");
    for(int r = 0; r < rSize; r++)
    {
        int num = prerequisites[r][1];
        colSize[num]++;
        graph[num][colSize[num]-1] = prerequisites[r][0];
    }
    for(int i = 0; i < courses; i++)
    {
        for(int j = 0; j < colSize[i]; j++)
            printf("%d\t", graph[i][j]);
        printf("\n");
    }
    int *arr = (int*)malloc(sizeof(int)*courses);
    *returnSize = 0;
    bool* visited = (bool*)malloc(sizeof(bool)*courses);
    memset(visited, 0, sizeof(int)*courses);
    for(int i = 0; i < courses; i++)
    {
        arr[*returnSize] = i;
        traverse(i, courses, graph, colSize, visited, arr, returnSize);
        if(*returnSize == courses) return arr;
    }
    return NULL;
}
