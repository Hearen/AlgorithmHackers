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
    if(n == 1)
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
    for(int i = 0; i < rSize; i++)
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
    for(int i = 0; i < n; i++) //collecting the bottom leaves;
    {
        if(colSizes[i] == 1)
        {
            *returnSize += 1;
            arr[*returnSize-1] = i;
        }
    }
    int* nextLevel = (int*)malloc(sizeof(int)*n); //traversing in a bottom-up way;
    int next = 0;
    while(*returnSize) //there is more;
    {
        for(int i = 0; i < *returnSize; i++)
        {
            int end = arr[i];
            for(int j = 0; j < n; j++) //remove it from its connected vertexes;
            {
                for(int k = 0; k < colSizes[j]; k++) //searching it in node j checking whether they are connected;
                {
                    if(graph[j][k] == end) //connected then remove it from node j;
                    {
                        int h = k+1;
                        while(h < colSizes[j]) //remove it;
                        {
                            graph[j][h-1] = graph[j][h];
                            h++;
                        }
                        colSizes[j]--;
                        if(colSizes[j] == 1) //if now node j becomes a leaf itself, add it to the nextLevel;
                        {
                            next++;
                            nextLevel[next-1] = j;
                        }
                        break;
                    }
                }
            }
        }
        if(!next) return arr; //no next level any more then arr collected all the top-level and return it;
        *returnSize = next; //prepare for the next level traversal;
        next = 0;
        int *t = arr; arr=nextLevel; nextLevel=t;
    }
}
