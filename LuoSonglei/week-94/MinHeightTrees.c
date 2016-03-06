/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-05 21:47
Description : For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

0
|
1
/ \
2   3
return [1]
Source      : https://leetcode.com/problems/minimum-height-trees/
*******************************************/
int* findMinHeightTrees(int n, int** edges, int rSize, int cSize, int* returnSize)
{
    int* arr = (int*)malloc(sizeof(int)*n);
    *returnSize = 0;
    if(n == 1) //corner case;
    {
        *returnSize += 1;
        arr[*returnSize-1] = 0;
        return arr;
    }
    int** graph = (int**)malloc(sizeof(int*)*n); //constructing the graph as a DAG - Directed Acyclic Graph;
    for(int i = 0; i < n; i++)
        graph[i] = (int*)malloc(sizeof(int));
    int* colSizes = (int*)malloc(sizeof(int)*n);
    memset(colSizes, 0, sizeof(int)*n);
    for(int i = 0; i < rSize; i++) //constructing the graph in edges list format;
    {
        int begin = edges[i][0];
        int end = edges[i][1];
        colSizes[begin]++;
        graph[begin] = (int*)realloc(graph[begin], sizeof(int)*colSizes[begin]); //dynamically allocate the space - just use the required space, nothing more;
        graph[begin][colSizes[begin]-1] = end;
        colSizes[end]++;
        graph[end] = (int*)realloc(graph[end], sizeof(int)*colSizes[end]);
        graph[end][colSizes[end]-1] = begin;
    }
    int* degrees = (int*)malloc(sizeof(int)*n);
    for(int i = 0; i < n; i++) //collecting the bottom leaves;
    {
        degrees[i] = colSizes[i]; //copy the degrees;
        if(colSizes[i] == 1)
        {
            *returnSize += 1;
            arr[*returnSize-1] = i;
        }
    }
    int count = n; //record the vertexes left;
    int* nextLevel = (int*)malloc(sizeof(int)*n); //used with arr imitating queue operations;
    int next = 0;
    while(count > 2)
    {
        for(int i = 0; i < *returnSize; i++)
        {
            int end = arr[i];
            count--; //remove the leaf then the vertexes left should be decremented;
            for(int k = 0; k < colSizes[end]; k++) //decrement related vertexes in degrees;
            {
                int begin = graph[end][k];
                degrees[begin]--;
                if(degrees[begin] == 1) //when the degree of the connected vertex is 1 which means it turns leaf now, collect it for next level;
                    nextLevel[next++] = graph[end][k];
            }
        }
        *returnSize = next; //update next, returnSize, arr and nextLevel for next round;
        next = 0;
        int *t=arr; arr=nextLevel; nextLevel=t;
    }
    return arr;
}
