/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-04 20:02
Description : There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
Source      : https://leetcode.com/problems/course-schedule/
*******************************************/
#include <bool.h>
void traverse(int start, int** graph, int* colSize, int* visited, bool* isCycle)
{
    if(visited[start] == 1) { *isCycle = true; return ; }
    visited[start] = 1;
    for(int i = 0; i < colSize[start]; i++)
    {
        traverse(graph[start][i], graph, colSize, visited, isCycle);
        if(*isCycle) return ;
    }
    visited[start] = 2;
}
bool canFinish(int courses, int** prerequisites, int rSize, int cSize)
{
    int space = sizeof(int)*courses;
    int* colSize = (int*)malloc(space); //count of edges of a certain node;
    memset(colSize, 0, space);
    int** graph = (int**)malloc(sizeof(int*)*courses); //constructing the graph;
    for(int i = 0; i < courses; i++)
        graph[i] = (int*)malloc(sizeof(int)*2);
    for(int r = 0; r < rSize; r++)
    {
        int num = prerequisites[r][1]; //the head of the edge;
        colSize[num]++;
        graph[num][colSize[num]-1] = prerequisites[r][0];
    }
    int *visited = (int*)malloc(space);
    memset(visited, 0, space);
    bool isCycle = false;
    for(int i = 0; i < courses; i++)
    {
        if(isCycle) return false;
        if(visited[i] == 0) traverse(i, graph, colSize, visited, &isCycle);
    }
    return !isCycle;
}
