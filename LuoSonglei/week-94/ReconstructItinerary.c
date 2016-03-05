/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-05 11:28
Description : Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
Source      : https://leetcode.com/problems/reconstruct-itinerary/
*******************************************/
#include <stdlib.h>
struct Mapper
{
    char *key;
    char **values;
    int size;
};

void insert(struct Mapper*** dict, int* size, char* key, char* value)
{
    for(int i = 0; i < *size; i++)
    {
        if(!strcmp((*dict)[i]->key, key)) 
        {
            struct Mapper *t = (*dict)[i];
            t->size += 1;
            t->values = (char**)realloc(t->values, sizeof(char*)*(t->size));
            int j = t->size-2;
            while(strcmp(t->values[j], value) == 1) 
            {
                t->values[j+1] = t->values[j];
                j--;
            }
            t->values[j] = value;
            return ;
        }
    }
    *size += 1;
    *dict = (struct Mapper**)realloc(*dict, sizeof(struct Mapper*)*(*size));
    struct Mapper *t = (struct Mapper*)malloc(sizeof(struct Mapper));
    t->key = key;
    t->values = (char**)malloc(sizeof(char*));
    t->values[0] = value;
    t->size = 1;
    (*dict)[*size-1] = t;
}

void traverse(struct Mapper *start, struct Mapper** dict, int size, char** stack, int* returnSize, int tCount)
{
    printf("\n\n");
    printf("collected: \n");
    for(int j = 0; j < *returnSize; j++)
        printf("%s -> ", stack[j]);
    printf("current: %s\treturnSize: %d\n", start->key, *returnSize);
    if(*returnSize == tCount) return ;
    *returnSize += 1;
    stack[*returnSize-1] = start->key;
    if(*returnSize == tCount) return ;
    for(int i = 0; i < start->size; i++)
    {
        int t = *returnSize;
        struct Mapper *next = NULL;
        for(int j = 0; j < size; j++)
            if(!strcmp(dict[j]->key, start->values[i]))
                next = dict[j];
        if(!next) return ;
        traverse(next, dict, size, stack, returnSize, tCount);
        if(*returnSize == tCount) return ;
        *returnSize = t;
    }
}
char** findItinerary(char*** tickets, int rSize, int cSize, int* returnSize)
{
    int count = 0;
    struct Mapper **dict = (struct Mapper**)malloc(sizeof(struct Mapper*));
    for(int i = 0; i < rSize; i++) //constructing graph in edges list;
        insert(&dict, &count, tickets[i][0], tickets[i][1]);
    char** tt = (char**)malloc(sizeof(char*)*2*rSize);
    int tCount = 0;
    for(int i = 0; i < rSize; i++)
    {
        int j = 0;
        while(j < tCount)
        {
            if(!strcmp(tickets[i][0], tt[j]))
                break;
            j++;
        }
        if(j == tCount)
            tt[tCount++] = tickets[i][0];
        j = 0;
        while(j < tCount)
        {
            if(!strcmp(tickets[i][1], tt[j]))
                break;
            j++;
        }
        if(j == tCount)
            tt[tCount++] = tickets[i][1];
    }
    printf("tCount: %d\n", tCount);
    for(int i = 0; i < count; i++)
    {
        printf("key: %s\t --> ", dict[i]->key);
        for(int j = 0; j < dict[i]->size; j++)
            printf("\t%s", dict[i]->values[j]);
        printf("\n");
    }
    char** stack = (char**)malloc(sizeof(char*)*count);
    for(int i = 0; i < count; i++)
    {
        *returnSize = 0;
        traverse(dict[i], dict, count, stack, returnSize, tCount);
        for(int j = 0; j < *returnSize; j++)
            printf("%s -> ", stack[j]);
        if(*returnSize == tCount) return stack;
    }
    return NULL;
}
